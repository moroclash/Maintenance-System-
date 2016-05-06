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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            return H;
        } catch (SQLException ex) {
            Logger.getLogger(HtmlGner.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   }
    
   
   public String DrawListHtml(User u)
   {
       HashMap<String,String> H = Get_User_Type(u.getType_id());
       String htmllist = "<aside>"  
                        +"<div id=\"sidebar\"  class=\"nav-collapse \">"
                        +"<!-- sidebar menu start-->"
                        +"<ul class=\"sidebar-menu\" id=\"nav-accordion\">"       
                        +"<p class=\"centered\"><a href=\"profile.html\"><img src=\"assets/img/ui-sam.jpg\" class=\"img-circle\" width=\"60\"></a></p>"
                        +"<h5 class=\"centered\">"+u.getF_name()+" "+u.getL_name()+"</h5>";               
               
       for (Map.Entry<String, String> entry : H.entrySet()) {
           
           htmllist+="<li class=\"mt\">"
                   +"<a href=\""+entry.getValue()+"\">"
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
   
   
   
   
   
}
