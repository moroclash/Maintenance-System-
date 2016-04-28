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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class System_manage {

    private ArrayList<Requist> Request_buffer;
    private ArrayList<Order> Order_buffer;
    private ArrayList<Complain> Comblain_buffer;

    public boolean Regist_customer(Customer customer) {
        return true;
    }

    public ArrayList<Requist> Show_requists(String State) {
        return null;
    }

    public ArrayList<String> Empty_time(int x, int y) {
        return null;
    }

    public ArrayList<Complain> All_complains(String State) {
        return null;
    }

    public ArrayList<Employee> Show_empty_technicals() {
        return null;
    }

    public ArrayList<Order> Show_empty_Order() {
        return null;
    }

    public ArrayList<Employee> Show_all_employee(int Branch_id) {
        return null;
    }

    public Branch Search_branch(int Branch_id) {
        return null;
    }

    public ArrayList<Employee> Show_all_employee(String Employee_type) {
        return null;
    }

    public Object Log_in(String User_Name, String Password) {
        return null;
    }

    public ArrayList<Requist> Show_my_requist() {
        return null;
    }

    public boolean Delete_requist(int Requist_id) {
        return true;
    }

    public Requist Search_requist(int Requist_id) {
        return null;
    }

    public boolean Reply_message(int Message_id, Comment comment) {
        return true;
    }

    public boolean Give_order(Order order) {
        return true;
    }

    public Bill Search_bill(int Branch_id) {
        return null;
    }

    public Feedback Search_feedback(int Order_id) {
        return null;
    }
//Emad
    public Device Search_device(int Device_id) {
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","Device","Device_ID="+Device_id);
        int Model=-1;
        int companyID=-1;
        int Type_id=-1;
          Device D=new Device();        
        try
        {
         while(result.next())
        {
          D.setId(result.getInt("Device_id"));
          D.setState(result.getInt("state_id"));
          Model=result.getInt("Model_id");
        }
         result=DB_controller.Select("*","model","Model_id="+Model);
         while(result.next())
         {
             D.push("Model", result.getString("Name"));
             companyID=result.getInt("Comp_device_id");
         }
         result=DB_controller.Select("*","main_factor","Main_factor_id="+companyID);
         while(result.next())
         {
             D.push("Copmany", result.getString("Name"));
         }
         result=DB_controller.Select("*","company_have_device","Main_factor_id="+companyID);
         while(result.next())
         {
             Type_id=result.getInt("Device_type_id");
         }
         result=DB_controller.Select("*","Device_type","Device_Type_id="+Type_id);
         while(result.next())
         {
             D.push("Type",result.getString("name"));
         }
         return D;
        }
        catch(Exception E)
        {
            System.out.println("Error in Search_DEVICE");
        }
        return null;
    }
    //Emad
    public boolean Up_complain_to_manager(Complain complain,int Branch_ID) {
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*", "branch","Branch_id="+Branch_ID);
        int Manager_id=-1;
        int MessageID=-1;
        try
        {
            while(result.next())
            {
                Manager_id=result.getInt("Manager_ID");
            }
         result=DB_controller.Select("*", "recieved","Message_ID="+complain.getId());  
         while(result.next())
         {
             MessageID=result.getInt("Message_ID");
         }
         HashMap <String,String>H=new HashMap();
         H.put("Reciever_id", Integer.toString(Manager_id));
         H.put("Message_ID", Integer.toString(MessageID));
         
         DB_controller.Insert("recieved",H);
         DB_controller.Close();
         return true;
        }
        catch(Exception E)
        {
            System.out.println("Error in UP Complain To manager");
        }
        return false;
    }

    public Order Search_order(int Order_id) {
        return null;
    }
    public int getDateID()
    {
         DB_controller.Connect();
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
         HashMap<String,String> Date=new HashMap<>(1);
         Date.put("Date", date.toString());
         DB_controller.Insert("date", Date);
         ResultSet isDate=DB_controller.Select("Date_id", "date", "Date="+date.toString());
         try
         {
             return isDate.getInt("Date_id");
              
         }
         catch(Exception s){
             s.printStackTrace();
             return -1;
         }
    }
    public boolean Send_Message(General_massge message) {
        DB_controller.Connect();
        HashMap<String,String> Mass=new HashMap<>(1);
        
        Mass.put("Content",message.getContent());
        Mass.put("sender_id",String.valueOf(message.getSender_id()));
        Mass.put("Type_id", Integer.toString(message.getMassage_type()));
        DB_controller.Insert(null, Mass);
        DB_controller.Insert("message",Mass);
        DB_controller.Select(null, null, null);
        
        return true;
    }
  //Emad
    public boolean Add_User(User user) {
        DB_controller.Connect();
        HashMap<String,String> U=new HashMap<String,String>();
        U.put("Fname",user.getF_name());
        U.put("Lname",user.getL_name());
        U.put("Email", user.getEmail());
        U.put("Password", user.getPassword());
        U.put("Gender",user.getGander());
        boolean check =DB_controller.Insert("USER", U);
        return check;
    }
    //Emad
    public User Search_user_by_id(int User_id) {
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user","User_ID="+User_id);
        User U=new User();        
        try
        {
            while(result.next())
            {
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getString("GENDER"));
                U.setPassword(result.getString("Password"));
            }
        ResultSet result2=DB_controller.Select("*","phone","User_ID="+User_id);
            while(result2.next())
            {
                U.setPhones(result2.getString("phone"));
            }             
        }
        catch(Exception e)
        {
            System.out.println("Error in Search User By ID");
        }
        if(U==null)
            return null;
        return U;
    }
    //Emad
    public User Search_user_by_name(String Name) {
        return null;
   }
    //Sala7
    public boolean Update_user(int User_id)
    {
        System_manage m = new System_manage();
        DB_controller.Connect();
        if (m.Search_user_by_id(User_id)== null) {
            return false;
        }
        else{
            Employee emp = new Employee();
            DB_controller.Update(" user " , " Fname =" + emp.getF_name() + " Lname = " + emp.getL_name() + " Password = " + emp.getPassword()
                    + " Email = " + emp.getEmail() + " gender = " + emp.getGander() ," User_id = " + User_id );
            DB_controller.Update( "  " , "  " , "  " );
        }
        DB_controller.Close();
        return true;
    }
    //Emad
    public boolean Delete_user(int User_id) {
        DB_controller.Connect();
        boolean check=DB_controller.Delete("user","User_ID="+User_id);
        return check;
    }
    //Emad
    public int Branch_quality(int Branch_id) {
        DB_controller.Connect();
        int NumberOfRows = 0;
        int Summtion = 0;
        int Persatage = 0;
        try {
            ResultSet result = DB_controller.Select("Branch_ID", "Feedback", "User_ID="+Branch_id);
            while (result.next())
            {
                Summtion=+result.getInt("Service_quality");
                NumberOfRows++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in Branch Quality");
        }
        Persatage=(Summtion/(NumberOfRows*100))*100;
        DB_controller.Close();
        return Persatage;
    }

    //Emad
    public boolean Block_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Update("user", "Block=1","User_ID="+User_id);
        DB_controller.Close();        
        return check;
    }

    //Emad
    public boolean Unblock_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Update("user", "Block=0","User_ID="+User_id);
        DB_controller.Close();        
        return check;
    }
   //Sala7
   public boolean Accept_order(int Order_id)
    {   
        DB_controller.Connect();
        System_manage m = new System_manage();
        if(m.Search_order(Order_id)==null){
            DB_controller.Close();
            return false;
        }
        else{
        DB_controller.Update("order_fixable " , " State_id = " + 4 , " Order_fixable_id = " + Order_id );
            }
        DB_controller.Close();
        return true;
    }
   //Sala7
     public boolean Is_fixed(Bill bill , String Technical_description , int order_id , int device_id)
    {   DB_controller.Connect();
        DB_controller.Update("order_fixable " , " State_id = " + 2 + " Technical_description = " + Technical_description , " Order_fixable_id = " + order_id );
        DB_controller.Update("device ", " State_id = " + 2 , " Device_id = " + device_id );
        
        
        
        DB_controller.Close();
        return true;
    }
   //Sala7
    public void Return_order(int Order_id,String Technical_description)
    {
        DB_controller.Connect();
        DB_controller.Update("order_fixable " , " State_id = " + 3 + " Technical_description = " + Technical_description , " Order_fixable_id = " + Order_id );
        DB_controller.Close();
    }

    //Emad
    public ArrayList<Order> Show_my_order() {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "order_fixable", "1");
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
                this.Order_buffer.add(order);
            }
        } catch (Exception e) {
            System.out.println("Error in Show_ALL_ORDER");
        }
        DB_controller.Close();
        return this.Order_buffer;
    }
    
    //omar
    public boolean Update_massage_state(int Old_massage_id ,int reciver_id ,int New_state)
    {
        Data_access.DB_controller.Connect();
        boolean b = Data_access.DB_controller.Update("recieved", "State = " + New_state , "Message_id ="+Old_massage_id+",Reciever_id="+reciver_id);
        Data_access.DB_controller.Close();
        return b;
    }
    
    //omar
    public String get_address_from_db(int Address_id)
    {
        try {
            ResultSet res = Data_access.DB_controller.Select("*","address", "Address_id="+Address_id);
            if(res==null)
            {
                return "";
            }
            
            if(res.getInt("Parent_id")==0)
                return res.getString("Address");
            else
            {
                int x=0;
                while (res.next()) {                    
                    x = res.getInt("Parent_id");
                }
                return res.getString("Address")+","+get_address_from_db(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
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
                Data_access.DB_controller.Insert("address", hash);
                ResultSet result = Data_access.DB_controller.Select("Address_id", "address", "Address="+Street);
                hash.clear();
                hash.put("Address", Num_of_home);
                int x = 0;
                while (result.next()) {                    
                    x = result.getInt("Address_id");
                }
                hash.put("Parent_id", Integer.toString(x));
                Data_access.DB_controller.Close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
    
    
    //omar
    public boolean Dellet_user_address(int Address_id,int user_id) {
            Data_access.DB_controller.Connect();
            boolean z = Data_access.DB_controller.Delete("address", "Address_id="+Address_id);
            Data_access.DB_controller.Delete("user_address", "Address_id="+Address_id+",User_id="+user_id);
            Data_access.DB_controller.Close();
            return z ;
    }
    
    //omar
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
                boolean z = Data_access.DB_controller.Update("address", "Address="+new_Street, "Address_id="+x);
                Data_access.DB_controller.Close();
                return z;
            } catch (SQLException ex) {
                Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    //omar
    public Massage Search_Massage(int Massage_id)
    {
        try {
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("*", "message", "Message_id="+Massage_id);
            int type=0;
            Massage c = new Massage();
            while (res.next()) {
                type = res.getInt("Type_id");
                    c.setContent(res.getString("Content"));
                    ResultSet res2 = Data_access.DB_controller.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                    while (res2.next()) {                        
                        c.setDate(res2.getString("Date"));
                    }
                    c.setId(Massage_id);
                    c.setMassage_type(type);
                    res2 = Data_access.DB_controller.Select("Reciever_id","recieved", "Message_id="+Massage_id);
                    while (res2.next()) {                        
                        c.setReciver(res2.getInt("Reciever_id"));
                        c.setState(res2.getInt("State_id"));
                    }
                    c.setTime(res.getString("Time"));
                    if(type == 1)
                    {
                        Complain m = (Complain) c;
                        res2 = Data_access.DB_controller.Select("Order_id","complain’s_order", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                        m.setOrder_id(res2.getInt("Order_id"));
                        }
                        Data_access.DB_controller.Close();
                        return c;
                    }
                    else
                    {
                        General_massge m = (General_massge) c;
                        m.setSender_id(res.getInt("sender_id"));
                        return c;
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    //omar
     public HashMap<Integer,String> get_user_address(int User_id) {
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
        return null;
    }
     
     
    //omar 
    public boolean Add_new_phone_to_user(String New_phone,int User_id) {
        if(!Validations.Is_digit(New_phone))
            return false;
        Data_access.DB_controller.Connect();
        HashMap<String,String> m = new HashMap<>();
        m.put("User_id", Integer.toString(User_id));
        m.put("Phone",New_phone);
        Data_access.DB_controller.Insert("phone", m);
        Data_access.DB_controller.Close();
        return true;
    }
    
    
    //omar 
    public boolean Delete_user_phone(int phone_id) {
        Data_access.DB_controller.Connect();
        boolean z = Data_access.DB_controller.Delete("phone", "phone="+phone_id);
        Data_access.DB_controller.Close();
        return z;
    }
    
    
    //omar
    public boolean Delete_user_phone(int Old_phone_id,String New_phone) {
        if(!Validations.Is_digit(New_phone))
            return false;
        Data_access.DB_controller.Connect();
        boolean z = Data_access.DB_controller.Update("phone", "phone="+New_phone , "Phone_id="+Old_phone_id);
        Data_access.DB_controller.Close();
        return z;
    }
    //omar
    public HashMap<Integer,String> get_user_phones(int User_id)
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
    
    //omar
    public boolean Add_new_additional_info(String Key, String Value) {
        return false;
    }
    
    //omar
    public boolean Delete_additional_info(String Key) {
        return false;
    }

    //omar
    public boolean Update_additional_info(String Old_key, String New_key, String New_value) {
        return false;
    }
    
}
