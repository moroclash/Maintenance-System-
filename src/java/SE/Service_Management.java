/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class Service_Management {
    private static Service_Management manage=null;
    private ArrayList<Request>Request_buffer;
    private ArrayList<Complain> Complain_buffer;
    private Service_Management()
    {
        
    }
    static Service_Management Get_Serive_Management()
    {
        if(manage==null)
            return new Service_Management();
        return null;
    }
    void Add_Request(Request request)
    {
        
    }
    void Add_Complain(Complain complain)
    {
        
    }
//Emad
   public ArrayList<Request> Show_requists(int State) {
       DB_controller.Connect();
       ResultSet result = DB_controller.Select("*", "request", "State_id=" + State);
       ArrayList<Request> R = new ArrayList<Request>();
       try {
           while (result.next()) {
               Request re = new Request();
               re.setID(result.getInt("Request_id"));
               re.setState_id(result.getInt("State_id"));
               re.setDate_id(result.getInt("Date_id"));
               R.add(re);
           }
           return R;
       } catch (Exception E) {
           System.out.println("Error");
       }
       return null;
   }
    ArrayList<Employee> Show_empty_technical(String Date)
    {
        return null;
    }
    ArrayList<Integer> Date_Choose()
    {
        return null;
    }
    boolean Accept_Request(int Request_id)
    {
        return true;
    }
    Bill_Information Add_Componenet(ArrayList<Component> Component,Bill bill,String Technical_description)
    {
        return null;
    }
    ArrayList<Order>Show_My_Order(int Employee_id)
    {
        return null;
    }
    //Emad
    public ArrayList<Order> Show_all_order(int state) {
        DB_controller.Connect();
        ArrayList<Order> O=new ArrayList<Order>();
        ResultSet result = DB_controller.Select("*", "order_fixable", "State_id="+state);
        try {            
            while (result.next()) {
                Order order = new Order();
                order.setId(result.getInt("Order_fixable_id"));
                order.setDate(result.getInt("Date_start_id"));
                order.setDate_requist(result.getInt("recept_date_id"));
                order.setState(result.getInt("state_id"));
                order.setTecnical_description(result.getString("Technical_description"));
                order.setMy_Service(result.getInt("Service_id"));
                order.setMy_requist(result.getInt("Requist_id"));
                O.add(order);
            }
        } catch (Exception e) {
            System.out.println("Error in Show_all_ORDER");
        }
        DB_controller.Close();
        return O;
    }
    boolean Cancel_Request(int Request_id)
    {
        return true;
    }
    //Mohamed RAdwan
    public Request Search_requist(int Requist_id) {
         try
        {
            //Table request
            DB_controller.Connect();
            Request request=new Request();
            ResultSet res=DB_controller.Select("*", "request", "Request_id="+Requist_id);
            request.setID(Requist_id);
            request.setState_id(res.getInt("ate_id"));
            request.setDate_id(res.getInt("Date_id"));//lw h8er el Date id to int 
            ArrayList<Integer> Devices_ID=new  ArrayList<Integer>();
            //END Table Reqest
            
            //Table device_of_this_request
            ResultSet Devices=DB_controller.Select("Device_id", "device_of_this_request", "request_id="+Requist_id);
            while(Devices.next())
            {
                Devices_ID.add(Devices.getInt("Device_id"));             
            }
            request.setMy_device(Devices_ID);
            return request;
        }//END TRy
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
     //Mohamed RAdwan
     public boolean Give_order(Order order) {
        try{
            DB_controller.Connect();
            //Table order_fixable 
            HashMap<String,String> Order=new HashMap<>(10); 
            Order.put("Requist_id", String.valueOf(order.getMy_requist()));
            Order.put("Date_start_id",String.valueOf(Get_date_iD()));
            Order.put("Technical_description",order.getTecnical_description());
            Order.put("Service_id",String.valueOf(order.getMy_Service()));
            Order.put("State_id","3");//wait fix
            Order.put("date_End_id",String.valueOf(order.getDate_requist()));
            DB_controller.Insert("order_fixable", Order);
            //end teabl order_fixable

            //Table device_of_this_request
            HashMap<String,String> ordflexde=new HashMap<>(1);
            int counter=0;
            Request req= Search_requist(order.getMy_requist());
            ArrayList<Integer> dev=req.getMy_device();
            int id_request=req.getID();
            ArrayList<Integer> ID_rder_flexible_details=new ArrayList<>();
            for(Integer d:dev)
            {
              ResultSet result =  DB_controller.Select("Device_of_this_request_id", "device_of_this_request", "Device_id="+d+" request_id="+id_request);
              ID_rder_flexible_details.add(result.getInt("Device_of_this_request_id"));
            }

            //if you want to use it in table Device_of_this_request_id to insert in
            /*for(Integer d:dev)
            {
                ordflexde.put("Flexible_id",String.valueOf(id_order));
                ordflexde.put("Device_id",String.valueOf(d));
                DB_controller.Insert("order_flexible_details",ordflexde);
                ID_rder_flexible_details.add(d);
                ordflexde=new HashMap<>(1);
            }*/
            //END device_of_this_request

            //Table order_flixer
            ArrayList<Integer> Techincal_ID= order.getMy_Technical_id();
            counter=0;
            for(Integer d:ID_rder_flexible_details)
            {
                ordflexde.put("Technical_id",String.valueOf(Techincal_ID.get(counter)));
                ordflexde.put("Order_id",String.valueOf(d));
                DB_controller.Insert("order_flixer",ordflexde);
                ordflexde=new HashMap<>(1);
                counter ++;
            }//end table order_flixer

        }//end try
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
     }
//Emad
    public Device Search_device(int Device_id) {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "Device", "Device_ID=" + Device_id);
        int Model = -1;
        int companyID = -1;
        int Type_id = -1;
        Device D = new Device();
        try {
            while (result.next()) {
                D.setId(result.getInt("Device_id"));
                D.setState(result.getInt("state_id"));
                Model = result.getInt("Model_id");
            }
            result = DB_controller.Select("*", "model", "Model_id=" + Model);
            while (result.next()) {
                D.push("Model", result.getString("Name"));
                companyID = result.getInt("Comp_device_id");
            }
            result = DB_controller.Select("*", "main_factor", "Main_factor_id=" + companyID);
            while (result.next()) {
                D.push("Copmany", result.getString("Name"));
            }
            result = DB_controller.Select("*", "company_have_device", "Main_factor_id=" + companyID);
            while (result.next()) {
                Type_id = result.getInt("Device_type_id");
            }
            result = DB_controller.Select("*", "Device_type", "Device_Type_id=" + Type_id);
            while (result.next()) {
                D.push("Type", result.getString("name"));
            }
            return D;
        } catch (Exception E) {
            System.out.println("Error in Search_DEVICE");
        }
        return null;
    }
    //Sala7

    public void Return_order(int Order_id, String Technical_description) {
        DB_controller.Connect();
        DB_controller.Update("order_fixable ", " State_id = " + 3 + " Technical_description = " + Technical_description, " Order_fixable_id = " + Order_id);
        DB_controller.Close();
    }
    //omar
    public String get_address_from_db(int Address_id)
    {
        try {
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("*","address", "Address_id="+Address_id);
            if(res==null)
            {
                return "";
            }
            while (res.next()) { 
                if(res.getInt("Parent_id")==0)
                {
                    String s = res.getString("Address");
                    Data_access.DB_controller.Close();
                    return s ;
                }
                else
                {
                    int x = res.getInt("Parent_id");
                    String s =res.getString("Address");
                    Data_access.DB_controller.Close();
                    return s+","+get_address_from_db(x);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        Data_access.DB_controller.Close();
        return "";
    }
//omar
   public boolean Add_new_address_to_user(int District_id,String Street, String Num_of_home,int user_id){
       if(Validations.Is_alphanumaric(Street)&&Validations.Is_alphanumaric(Num_of_home))
       { 
           try {
               Data_access.DB_controller.Connect();
               HashMap<String, String> hash = new HashMap<String, String>();
               hash.put("Address", Street);
               hash.put("Parent_id", Integer.toString(District_id));
               int x = Data_access.DB_controller.Insert("address", hash);
               hash.clear();
               hash.put("Address", Num_of_home);
               hash.put("Parent_id", Integer.toString(x));
               x=Data_access.DB_controller.Insert("address", hash);
               hash.clear();
               hash.put("Address_id", Integer.toString(x));
               hash.put("User_id", Integer.toString(user_id));
               Data_access.DB_controller.Insert("user_address", hash);
               Data_access.DB_controller.Close();
               return true;
           } catch (Exception ex) {
               Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
       }
       return false;
   }
//omar
   public boolean Delete_user_address(int Address_id,int user_id) {
           Data_access.DB_controller.Connect();
           boolean z = Data_access.DB_controller.Delete("address", "Address_id="+Address_id);
           Data_access.DB_controller.Delete("user_address", "Address_id="+Address_id+" and User_id="+user_id);
           Data_access.DB_controller.Close();
           return z ;
   }
      public boolean Update_address(int Old_num_of_home_id,String new_Street ,String new_num_of_home) {
       if(Validations.Is_alpha(new_Street)&&Validations.Is_alphanumaric(new_num_of_home))
       { 
           try {
               Data_access.DB_controller.Connect();
               Data_access.DB_controller.Update("address","Address="+new_num_of_home,"Address_id="+Old_num_of_home_id);
               ResultSet res = Data_access.DB_controller.Select("Parent_id", "address", "Address_id="+Old_num_of_home_id);
               int x = 0;
               while (res.next()) {                    
                   x = res.getInt("Parent_id"); 
               }
               boolean z = Data_access.DB_controller.Update("address", "Address='"+new_Street+"'", "Address_id="+x);
               Data_access.DB_controller.Close();
               return z;
           } catch (SQLException ex) {
               Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return false;
   }
    //omar
    HashMap<Integer,String>Get_User_Address(int User_id)
    {
        try {
            HashMap<Integer,String> m = new HashMap<>();
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("Address_id", "user_address", "User_id="+User_id);
            int x=0;
            while(res.next())
            {
                x = res.getInt("Address_id");
                m.put(x,new System_manage().get_address_from_db(x));
            }
            Data_access.DB_controller.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        Data_access.DB_controller.Close();
        return null;    }
    //omar
    boolean Add_New_Phone_To_User(String New_phone,int User_id)
    {
        if(!Validations.Is_digit(New_phone))
            return false;
        Data_access.DB_controller.Connect();
        HashMap<String,String> m = new HashMap<>();
        m.put("User_id", Integer.toString(User_id));
        m.put("Phone",New_phone);
        Data_access.DB_controller.Insert("phone", m);
        Data_access.DB_controller.Close();
        return true;    }
    //omar
    boolean Delete_User_Phone(int Phone_id)
    {
        Data_access.DB_controller.Connect();
        boolean z = Data_access.DB_controller.Delete("phone", "phone_id="+Phone_id);
        Data_access.DB_controller.Close();
        return z;
    }
    //omar
    boolean Update_User_Phone(int Old_phone_id,String New_phone)
    {
        if(!Validations.Is_digit(New_phone))
            return false;
        Data_access.DB_controller.Connect();
        boolean z = Data_access.DB_controller.Update("phone", "phone="+New_phone , "Phone_id="+Old_phone_id);
        Data_access.DB_controller.Close();
        return z;
    }
    //omar
    HashMap<Integer,String> Get_User_Phone(int User_id)
    {
        try {
            HashMap<Integer,String> m = new HashMap<>();
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("*", "phone", "User_id="+User_id);
            while(res.next())
            {
                m.put(res.getInt("Phone_id"),res.getString("phone"));
            }
            Data_access.DB_controller.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        Data_access.DB_controller.Close();
        return null;
    }
//sala7
   public String Show_satate(int state)
   {
       DB_controller.Connect();
       ResultSet result = DB_controller.Select("State", " state ", " State_id = " + state);
       String res= "";
       try {
           while(result.next())
           {
             res = result.getString("State");
           }
           DB_controller.Close();
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return res;
   }
   //Emad
 public ArrayList<Complain> Show_complains(int State) {
       DB_controller.Connect();
       ResultSet result = DB_controller.Select("*", "Message_type", "Name='Complain'");
       ArrayList<Complain> C = new ArrayList<Complain>();
       int ID = 0;
       try {
           while (result.next()) {
               ID = result.getInt("Message_type_id");
           }
           result = DB_controller.Select("*", "recieved", "Message_id=" + ID + " and State_id=" + State);
           while (result.next()) {
               
               Complain complain = new Complain();
               complain.setId(ID);
               complain.setReciver(result.getInt("Reciever_id"));
               complain.setState(State);
               C.add(complain);
           }
           return C;
       } catch (Exception E) {
           System.out.println("Error in Complains");
       }
       return null;
   }   
}
