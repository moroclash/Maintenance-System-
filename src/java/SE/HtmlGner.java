/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.util.HashMap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author moroclash
 */
public class HtmlGner {
    
    private static HtmlGner html = null;
    
    private HtmlGner()
    {}
    
    public static HtmlGner Get_HtmGner()
    {
        if(html == null)
            html =new HtmlGner();
        return html;
    }
    
    
   //omar 0_0 
   private  HashMap<String,String> Get_User_Type(int User_type_id)
   {
        try {
            HashMap<String,String> H = new HashMap<>();
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ResultSet res = Db.Select("Link_id", "user_type_links", "User_type_id="+User_type_id);
            ResultSet res2 = null;
            while(res.next())
            {
                res2 = Db.Select("*", "links", "Links_id="+res.getInt("Link_id"));
                while (res2.next()) {                    
                    H.put(res2.getString("Function_name"), res2.getString("Physical_name"));
                }
            }
            Db.Close();
            return H;
        } catch (SQLException ex) {
            Logger.getLogger(HtmlGner.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   }
    
   //omar 0_0
   public String DrawListHtml(User u)
   {
       HashMap<String,String> H = Get_User_Type(u.getType_id());
       String htmllist = "<aside>"  
                        +"<div id=\"sidebar\"  class=\"nav-collapse \">"
                        +"<!-- sidebar menu start-->"
                        +"<ul class=\"sidebar-menu\" id=\"nav-accordion\">"       
                        +"<p class=\"centered\"><a href=\"Show_my_profile.jsp\"><img src=\"assets/img/ui-sam.jpg\" class=\"img-circle\" width=\"60\"></a></p>"
                        +"<h5 class=\"centered\">"+u.getF_name()+" "+u.getL_name()+"</h5>";               
               
       for (Map.Entry<String, String> entry : H.entrySet()) {
           
           htmllist+="<li class=\"mt\">"
                   +"<a "+entry.getValue()+">"
                   +"<i class=\"fa fa-dashboard\"></i>"
                   +"<span>"+entry.getKey()+"</span>"
                   +"</a>"       
                   +"</li>" ;       
       }
       
       htmllist +="</ul>"
                +"</div>"
                +"</aside>";
      return htmllist;
   }
   
   

    
    
   //omar 0_0
   public  String Get_filed_Html(int Type_id)
   {
       try {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            String html = "";
            ResultSet res = Db.Select("Filed_html_id", "type_filed_html" , "Type_file_html_id="+Type_id);
            while(res.next())
            {
                int id = res.getInt("Filed_html_id");
                ResultSet res2 = Db.Select("Html", "filed_html", "Filed_html_id="+id);
                while(res2.next())
                {
                    html = res2.getString("Html");
                }
            }
            Db.Close();
            return html;
        } catch (SQLException ex) {
            Logger.getLogger(HtmlGner.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
   }
   
   
   
   
   
  
   
   //num_of_noty --> numper of notifyes that returned or 0 is all
   //n  if 1 is notyfy if 2 is massages   
   //omar
   public  ArrayList<String> Get_Noty(int num_of_noty,int n ,User user)
   {
       DB_controller Db = DB_controller.Get_DB_controller();
       Service_Management ser = Service_Management.Get_Serive_Management();
       System_manage sys = System_manage.Get_System_manage();
       String Filed = "";
       String returned = "";
       ArrayList<String> html=new ArrayList<>();
       html.add("");
       html.add("");
       if(n==1)
       {
          Filed=Get_filed_Html(14);
          Customer cus = null;
          if(user.getType_id()!=5)
              return html;
          cus = (Customer) user;
          cus.Load_Notify();
          ArrayList<Notify> MyNotifys = cus.Get_notify();
          html.set(0,Integer.toString(MyNotifys.size()));
          int i ;
          if(MyNotifys.size()==0)
              return html;
          if(num_of_noty == 0 ||num_of_noty>MyNotifys.size())
             i =  MyNotifys.size();
          else
             i = num_of_noty;
          String used = "";
          Request req = null;
          for(int l=i-1; l>=0 ; l--)
          {
              Notify o = MyNotifys.get(l);
              used = Filed.replace("<muted>2 Minutes Ago","<muted>"+o.getTime()+ "  " + sys.Get_this_date(o.getDate_id()));
              used = used.replace(" subscribed to your newsletter.<br/>",o.getContent()+"<br/>Branch : "+o.getBranch_id());
              returned +=used; 
          }
          html.set(1,returned);
          return html;
       }
       if(n==2)
       {
           Filed = Get_filed_Html(10);
           user.Load_inbox();
           ArrayList<Massage> massage = user.getInbox();
           int i ;
           if(massage.size()==0)
               return html;
           html.set(0,Integer.toString(massage.size()));
           System.err.println(massage.size());
           if(num_of_noty == 0 ||num_of_noty>massage.size())
             i =  massage.size();
           else
             i = num_of_noty;
           String used = "";
           for(int l=i-1; l>=0 ; l--)
           {
              General_massge o = (General_massge) massage.get(l);
              User u = (User) sys.Search_user_by_id(o.getSender_id());
              used = Filed.replace("Dj Sherman",u.getF_name()+" "+u.getL_name());
              used = used.replace("index.html#", "ShowMessage.jsp?chars="+l+"&id="+o.getId());
              used = used.replace("<span class=\"time\">4 hrs.","<span class=\"time\">"+sys.Get_this_date(o.getDate_id()));
              used = used.replace("Please, answer asap.", o.getTime());
              returned +=used; 
            }
           html.set(1,returned);
           return html;
       }
       return new ArrayList<>();
   }
   
  
   
   
   
   //Emad
    public ArrayList<String> Get_All_HTML_Attributes(ArrayList<String> Names,int ID)
   {
       ArrayList<String> Html=new ArrayList<String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       String Temp="";
       String Temp2="";
       String Temp3="";
       int i=0;
       try
       {
           for(int j=0;j<Names.size();j++)
           {
        ResultSet result =DB.Select("*","filed_html","Filed_html_id="+ID);            
           while(result.next())
           {
               Temp=result.getString("Html");
               Temp2=Temp.replace("value=\"\"","value=\""+Names.get(i)+"\""+"  ");
               Temp3=Temp2.replace("  >",">"+Names.get(i));
               Html.add(Temp3);
               i++;
           }               
           }
       }
       catch(Exception E)
       {
           System.out.println(E);
       }
       return Html;
   }
   
   //Emad
    public ArrayList<String> HTMLTypes(HashMap<Integer,String> Types)
   {
       ArrayList<String>HTML=new ArrayList<String>();
       String Text="";
       String Key="";
       String Value="";
       DB_controller DB=DB_controller.Get_DB_controller();
       String Temp="";
       String Temp2="";
       ResultSet result=DB.Select("*","filed_html","Filed_html_id=2");
       try
       {
           while(result.next())
           {
               Text=result.getString("Html");
           }
           for(Map.Entry<Integer,String> entry:Types.entrySet())
           {
               Temp=Text.replace("value=\"\"","value=\""+entry.getValue()+"\""+"  ");
               Temp2=Temp.replace("  >",">"+entry.getValue()+"");
               HTML.add(Temp2);
           }
       }
       catch(Exception E)
       {
           System.out.println("Error "+E);
       }
       return HTML;
   }
    
    
    
    //Emad
    //Emad
   public ArrayList<String> Last_Shape_Of_HTML_Attributes_Types(HashMap<String,String> H)
   {
       ArrayList<String>S=new ArrayList<String>();
       String HTML="";
       String Value="";
       String Key="";
       String Temp="";
       String Temp2="";
       String Temp3="";
       String Temp4="";
       int i=1;
       for(Map.Entry<String,String> entry:H.entrySet())
       {
           Key=entry.getKey();
           Value=entry.getValue();
           Temp=Value.replace("for=\"\"", "for=\""+Key+"\"");
           Temp2=Temp.replace("</label>","</label>"+Key+":");
           Temp3=Temp2.replace("<input","<input name="+"'"+Key+"'");
           i++;
           S.add(Temp3);
       }
       return S;
   } 
    
   
   //Emad
    public HashMap<String,String> Load_HTML_Types(int ID)
   {
       HashMap<String,String> H=new HashMap<String,String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ArrayList<Integer> A=new ArrayList<Integer>();
       ArrayList<String> St=new ArrayList<String>();
       ResultSet result=DB.Select("*","user_selected_option","User_type_id="+ID);
       try
       {
           while(result.next())
           {
               A.add(result.getInt("User_option_id"));
           }
           for(int i=0;i<A.size();i++)
           {
               result=DB.Select("*","user_option","User_option_id="+A.get(i));
               while(result.next())
               {
                   St.add(result.getString("Name"));
               }
           }
           for(int i=0;i<St.size();i++)
           {
               result=DB.Select("*","filed_html","Filed_html_id=1");
               while(result.next())
               {
                   H.put(St.get(i),result.getString("Html"));
               }
           }
       }
       catch(Exception E)
       {
           
       }
       return H;
   }
   
    
    
    
    //Emad
    //Emad
   public ArrayList<String> Last_Shape_Of_HTML_Attributes(HashMap<String,String> H,HashMap<Integer,String> Values)
   {
       ArrayList<String>S=new ArrayList<String>();
       String HTML="";
       String Value="";
       String Key="";
       String Temp="";
       String Temp2="";
       String Temp3="";
       String Temp4="";
       int i=1;
       for(Map.Entry<String,String> entry:H.entrySet())
       {
           Key=entry.getKey();
           Value=entry.getValue();
           Temp=Value.replace("for=\"\"", "for=\""+Key+"\"");
           Temp2=Temp.replace("</label>","</label>"+Key+":");
           Temp3=Temp2.replace("<input","<input name="+"'"+Key+"'");
           Temp4=Temp3.replace("type=\"text\"","type=\"text\" Value="+"'"+Values.get(i)+"'");
           i++;
           S.add(Temp4);
       }
       return S;
   }
    
   
   
       //Emad
   public HashMap<String,String> Get_HTML_Attributes(HashMap<Integer,String> V)
   {
       HashMap<String,String> H=new HashMap<String,String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       String Name="";
       String HTML="";
       int Temp=-1;
       ResultSet result=null;
       for(Map.Entry<Integer,String> entry:V.entrySet())
       {
           result=DB.Select("*","user_option","User_option_id="+entry.getKey());
           try
           {
               while(result.next())
               {
                   Name=result.getString("Name");
               }
               result=DB.Select("*","type_filed_html","Type= 'text'");
               while(result.next())
               {
                   Temp=result.getInt("Filed_html_id");
               }
               result=DB.Select("*","filed_html","Filed_html_id="+Temp);
               while(result.next())
               {
                   H.put(Name,result.getString("HTML"));
               }
           }
           catch(Exception E)
           {
               
           }
       }
       return H;
   }
   
   
   
}
    