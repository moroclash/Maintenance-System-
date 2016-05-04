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
import javax.mail.MessagingException;


/**
 *
 * @author Mohamed Salah
 */
public class Customer extends User {

    private int Sequrity_question_id;
    private String Sequrity_question_answer;
    ArrayList<Integer> subscribe_branshes;
    ArrayList<Notify> My_notify;

    
    //Emad
    public void Load_Notify()
    {

        this.My_notify=new ArrayList<Notify>();
        ArrayList<Integer>A=new ArrayList<Integer>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        System_manage S=System_manage.Get_System_manage();
        ResultSet result=DB.Select("*","recieved","Reciever_id=2");
        try 
        {
            while(result.next())
            {
                A.add(result.getInt("Message_id"));
            }
            for(int i=0;i<A.size();i++)
            {
            result=DB.Select("*","message","Message_id="+A.get(i)+" and Type_id=4");
            while(result.next())
            {
                Notify N=new Notify();
                N.setId(A.get(i));
                N.setContent(result.getString("Content"));
                N.setDate_id(result.getInt("Date_id"));
                N.setMassage_type_id(4);
                N.setState(result.getInt("State_id"));
                N.setMassage_type_id(result.getInt("Type_id"));
                N.setTime(Integer.toString(result.getInt("Time")));
                N.setBranch_id(result.getInt("sender_id"));
                this.My_notify.add(N);                
            }
            }
        } 
        catch (SQLException ex)
        
        {
            System.out.println("E"+ex);
        }
    }
    
    //Emad
    public void Add_notify(Notify N)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        HashMap <String,String> H=new HashMap<String,String>();
        H.put("Reciever_id",Integer.toString(this.getID()));
        H.put("Message_id",Integer.toString(N.getId()));
        H.put("State_id","4");
        DB.Insert("recieved",H);
        this.My_notify.add(N);
    }

    public ArrayList<Notify> Get_notify() {
        return null;
    }
    //sala7
    public boolean Add_Subscribe(int bransh_id) {
        
        System_manage sy = System_manage.Get_System_manage();
        Branch b = sy.Search_branch(bransh_id);
        b.Subcribe(getID());
        return true;
    }
    //Emad Done
    public ArrayList<Request> Show_My_requist() {
        ArrayList<Request> R=new ArrayList<Request>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result2=null;
        int ID=-1;
        try
        {
        ResultSet result=DB.Select("*","request","User_id="+this.getID());            
            while(result.next())
            {
                Request Req=new Request();
                ArrayList<Integer>A=new ArrayList<Integer>();
                ID=result.getInt("User_id");
                Req.setID(ID);
                Req.setAddress_ID(result.getInt("Address_ID"));
                Req.setDate_id(result.getInt("Date_id"));
                Req.setState_id(result.getInt("State_id"));
                result2=DB.Select("*","device_of_this_request","Request_id=1");
                while(result2.next())
                {
                    A.add(result2.getInt("Device_id"));
                }
                Req.setDevice_id(A);
                R.add(Req);
            }
            }
        catch(Exception Ex)
        {
            System.out.println("Error"+Ex);
        }
        return R;
    }

    
    
   //omar
    public ArrayList<Order> show_my_order() {
        try {
            DB_controller Db = DB_controller.Get_DB_controller();
            Service_Management sr = Service_Management.Get_Serive_Management();
            ArrayList<Order> or = new ArrayList<>();
            Db.Connect();
            ResultSet res = Db.Select("Request_id","request", "User_id="+getID()+" and not State_id=5");
            int req = 0 ;
            while (res.next()) {
                req = res.getInt("Request_id");
                ResultSet res2 = Db.Select("Order_fixable_id", "order_fixable", "Requist_id="+req);
                while(res2.next())
                {
                    or.add(sr.Search_order(res2.getInt("Order_fixable_id")));
                }
            }
            return or;
        } catch (SQLException ex) {
           
        }
        return null;
    }
    
    
//Emad
    public boolean forget_My_Password(String email, int Sequirty_question_id, String Answer) //asmy@gmail.com 
    {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        int User_ID = -1;
        int Option_Seq_ID1=-1;
        int Option_Seq_ID2=-1;        
        String A="";
        String B="";
        String Q="";
        String N="";
        String RealPassword="";
        
        ResultSet result = DB.Select("*", "User", "Email=" +"'"+ email+"'");
        try {
            while (result.next())
            {
                User_ID = result.getInt("User_ID"); 
                RealPassword=result.getString("Password");
                System.out.println(User_ID);
            }
            result =DB.Select("*", "security_question", "Security_question_id="+Sequirty_question_id);
            while(result.next())
            {
                Q=result.getString("Question"); //al Content bta3et el so2al al howa e5taro mn al interface 
                System.out.println(Q);
            }
            result=DB.Select("*", "user_option", "Name='Sequrity_Question_id'");
            while(result.next())
            {
                Option_Seq_ID1=result.getInt("User_option_id"); // User_Option_ID
                System.out.println(Option_Seq_ID1);
            }
            result=DB.Select("*", "user_option", "Name='Answer_question'");
            while(result.next())
            {
                Option_Seq_ID2=result.getInt("User_Option_ID");
                System.out.println(Option_Seq_ID2);                
            }            
            
            result=DB.Select("Value","user_selected_option_values","User_ID="+User_ID +" and User_selected_option_id=" +Option_Seq_ID1);
            while(result.next())
            {
                A=result.getString("Value");  //al so2al al howa msglo f3ln
            }
            result=DB.Select("Value","user_selected_option_values","User_ID="+User_ID +" and User_selected_option_id=" +Option_Seq_ID2);
            while(result.next())
            {
                B=result.getString("Value"); //al egaba al howa msglha f3ln
            }            
        } 
        catch (SQLException ex) 
        {
            
        }
        DB.Close();
        if(A.equals(Q)&&B.equals(Answer))
        {
            Message_Controller M=Message_Controller.Get_Message_Controller();
            try{
                M.Send_Email(this.getID(),"Remember Password","Dear Clinet: Here You Are Your Pasword Which you Forgot "+ "'"+RealPassword+"'");
                return true;
            }
            catch(Exception E)
            {
                System.out.println("Error in Forgot Password Fuction "+E);
                return false;
            }
        }
        return false;
    }

    //omar
    public void Set_sequrity_question(int Sequrity_question_id) {
        this.Sequrity_question_id = Sequrity_question_id;
    }

    //omar
    public int Get_sequrity_question_id() {
        return this.Sequrity_question_id;
    }

    //omar
    public void Set_sequrity_question_answer(String Sequrity_question_answer) {
        this.Sequrity_question_answer = Sequrity_question_answer;
    }

    //omar
    public String Get_sequrity_question_answer() {
        return this.Sequrity_question_answer;
    }

    //Emad
    //Add F al Service
    public boolean Make_request(Device Device, int User_ID) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> H = new HashMap();
        H.put("User_ID", Integer.toString(User_ID));
        H.put("Device_ID", Integer.toString(Device.getId()));
        H.put("State_ID", "1");
        int check = Db.Insert("Request", H);
        Db.Close();
        if (check == -1) {
            return false;
        }
        return true;
    }

    //Emad
    public boolean Select_time(Time_chooser My_chooser) {
        System_manage S = System_manage.Get_System_manage();
        DB_controller DB = DB_controller.Get_DB_controller();
        HashMap<String, String> H = new HashMap<String, String>();
        int User_ID = -1;
        int Option_ID = -1;
        ResultSet result = DB.Select("User_ID", "request", "Request_id=" + My_chooser.getRequest_ID());
        try {
            while (result.next()) {
                User_ID = result.getInt("User_ID");
            }
            result = DB.Select("User_option_id", "user_option", "Name='Branch_ID'");
            while (result.next()) {
                Option_ID = result.getInt("User_option_id");
            }
            result = DB.Select("value", "user_selected_option_values", "User_ID=" + User_ID + " and User_Option_ID=" + Option_ID);
            while (result.next()) {
                H.put("Branch_ID", result.getString("Value"));
            }
            result = DB.Select("Time_chooser_id", "time_chooser", "Request_fixable_id=" + My_chooser.getRequest_ID());
            while (result.next()) {
                H.put("Time_chooser_id", Integer.toString(result.getInt("Time_chooser_id")));
            }
            DB.Insert("time_choosed", H);
            DB.Close();
            return true;
        } catch (Exception Ex) {

        }
        return false;
    }

    //Emad
    public String Trace_my_device(int Device_id) {
        int State_ID = -100;
        String State = null;
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*", "DEVICE", "DEVICE_ID=" + Device_id);
        try {
            while (result.next()) {
                State_ID = result.getInt("State_id");
            }
            result = Db.Select("*", "STATE", "STATE_ID=" + State_ID);
            while (result.next()) {
                State = result.getString("State");
            }
            return State;
        } catch (Exception E) {
            System.out.println("Error in Trace_My_Device");
        }
        return null;
    }

    //Emad
    public boolean Make_complain(Complain complain, int Order_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Service_Management S=Service_Management.Get_Serive_Management();
        Db.Connect();
        HashMap<String, String> H = new HashMap<String, String>();
        H.put("Message_ID", Integer.toString(complain.getId()));
        H.put("Order_ID", Integer.toString(Order_id));
        S.Add_Complain(complain);
        int check = Db.Insert("Complain’s_order", H);
        Db.Close();
        if (check == -1) {
            return false;
        }
        return true;
    }

    //Emad
    public boolean Make_feedback(Feedback feedback, int Order_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> H = new HashMap<>();
        H.put("Order_id", Integer.toString(Order_id));
        H.put("Feedback_id", Integer.toString(feedback.getId()));
        H.put("System_quality", Integer.toString(feedback.getSystem_quality()));
        H.put("Service_quality", Integer.toString(feedback.getService_quality()));
        H.put("Branch_ID",Integer.toString(feedback.getBranch_id()));
        int check = Db.Insert("FEEDBACK", H);
        Db.Close();
        return check != -1;
    }

    //sala7
    @Override
    public boolean Log_in(String User_Name, String Password) {

        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result ;
        System_manage s = System_manage.Get_System_manage();
        Customer customer ;
        int id = -1;
        result = DB.Select("User_id ", " user ", " Email =  '" + User_Name + "'" + " and " + "Password = '" + Password + "'");
        
        int customer_id = -1;
        try {
            while (result.next()) {
              customer_id = result.getInt("User_id");
               
            }
            customer = (Customer) s.Search_user_by_id(customer_id);
            setF_name(customer.getF_name());
            setL_name(customer.getL_name());
            setEmail(customer.getEmail());
            setPassword(customer.getPassword());
            setGander(customer.getGander());
            setBlock(customer.getBlock());
            setType_id(customer.getType_id());
            setPhones(customer.getPhones());
            setAdditional_data(customer.getAdditional_data());
            setAddresses(customer.getAddresses());
            Set_sequrity_question(customer.Get_sequrity_question_id());
            Set_sequrity_question_answer(customer.Get_sequrity_question_answer());

        } catch (SQLException ex) {
            ex.printStackTrace();
          
            return false;
        }
      
        return true;
    }

    
    
    
}
