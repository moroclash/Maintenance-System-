/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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

    public Device Search_device(int Device_id) {
        return null;
    }

    public boolean Up_complain_to_manager(Complain complain) {
        return true;
    }

    public Order Search_order(int Order_id) {
        return null;
    }

    public boolean Send_Message(General_massge message, int Sender_id, int Reciver_id) {
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
        ResultSet result=DB_controller.Select("*","user",Integer.toString(User_id));
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
        ResultSet result2=DB_controller.Select("*","phone",Integer.toString(User_id));
            while(result2.next())
            {
                U.setPhones(result2.getString("phone"));
            }
        ResultSet result3=DB_controller.Select("*","address",Integer.toString(User_id));
            while(result3.next())
            {
                U.setAddress(result2.getString("Address"));
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
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user",Name);
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
        ResultSet result2=DB_controller.Select("*","phone",Name);
            while(result2.next())
            {
                U.setPhones(result2.getString("phone"));
            }
        ResultSet result3=DB_controller.Select("*","address",Name);
            while(result3.next())
            {
                U.setAddress(result2.getString("Address"));
            }               
        }
        catch(Exception e)
        {
            System.out.println("Error in Search User By ID");
        }
        if(U==null)
            return null;
        return U;    }
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
        boolean check=DB_controller.Delete("user",Integer.toString(User_id));
        return check;
    }
    //Emad
    public int Branch_quality(int Branch_id) {
        DB_controller.Connect();
        int NumberOfRows = 0;
        int Summtion = 0;
        int Persatage = 0;
        try {
            ResultSet result = DB_controller.Select("Branch_ID", "Feedback", Integer.toString(Branch_id));
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
        boolean check = DB_controller.Update("user", "Block=1", Integer.toString(User_id));
        DB_controller.Close();        
        return check;
    }

    //Emad
    public boolean Unblock_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Update("user", "Block=0", Integer.toString(User_id));
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
}
