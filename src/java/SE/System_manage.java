/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class System_manage {

    private static System_manage system_manage = null ;
    
    private System_manage()
    {}
    
    public static System_manage Get_System_manage()
    {
        if(system_manage == null)
            system_manage = new System_manage();
        return system_manage;
    }

    public boolean Regist_customer(Customer customer) {
        return true;
    }
    
    
    
    public Systemreport Get_System_Report()
    {
        return null;
    }
    
    
    
    public BranchReport Get_Branch_Report(Branch branch)
    {
        return null;
    }
    
    
    
    
    
    //sala7
    public Branch Search_branch(int Branch_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        Branch branch = new Branch();
        ResultSet result = Db.Select("*", " branch ", " Branch_id =" +Branch_id);
        int location=-1;
        try {
            while(result.next())
            {
              branch.setId(result.getInt("Branch_id"));
              branch.setMnager_id(result.getInt("User_id"));
              location = result.getInt("");
            }
            result = Db.Select("Address", "address", "Address_id = " + location);
            while(result.next())
            {
                branch.setLocation(result.getString("Address"));
            }
            result = Db.Select("phone", "branch_phone", " Branch_id = " + Branch_id);
            while (result.next())
            {
              branch.push(result.getString("phone"));
            }
        } catch (SQLException ex) {
            Db.Close();
            return null;
        }
        return branch;
    }
    
    
    
    
    
    public ArrayList<Employee> Show_all_employee(String Employee_type) {
        try
        {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    
    
    
    
    
    
    //sala7
    public Bill_inf Search_bill(int Order_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        Bill bill = new Bill();
        int Method_ID=-1;
        ResultSet result = Db.Select("*" , " bill " , " Order_id = " + Order_id );
        try {
            while(result.next()){
               bill.setId(result.getInt("BILL_id"));
               bill.setDate_id(result.getInt("Date_id"));
               bill.setCost(result.getDouble("Cost"));
               bill.setMy_order(result.getInt("Order_id"));
               bill.setTime(result.getString("Time"));
               Method_ID=result.getInt("Payment_method_id");
            }
               result=Db.Select("Payment_method_id", "parent_methode " , "parent_methode_id = " + Method_ID);
               while(result.next())
               {
                //   bill.push("Payment_Method",result.getString("Methode"));
               }
               //return bill;
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
            Db.Close();
        }
        return null;
    }
    
    
    
    
    //sala7
    public Feedback Search_feedback(int Order_id) {
        Feedback feedback = new Feedback();
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*", "feedback", " Order_id = " + Order_id);
        try {
            while(result.next())
            {
              feedback.setId(result.getInt("Feedback_id"));
              feedback.setMy_order(result.getInt("Order_id"));
              feedback.setService_quality(result.getInt("System_quality"));
              feedback.setSystem_quality(result.getInt("Service_quality"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
            Db.Close();
            return null;
        }
        Db.Close();
        return feedback;
    }
    
    
    
     //Emad
    public void Add_User(User user) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> U = new HashMap<String, String>();
        U.put("Fname", user.getF_name());
        U.put("Lname", user.getL_name());
        U.put("Email", user.getEmail());
        U.put("Password", user.getPassword());
        U.put("Gender", user.getGander());
        U.put("Block", ""+user.getBlock());
        Insert_Option_Values(user,Db.Insert("user", U));
    }
    
    
    
    //Emad
    public User Search_user_by_id(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        String S;
        ResultSet result = Db.Select("*", "user", "User_ID=" + User_id);
        User U = new User();
        try {
            while (result.next()) {
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getString("GENDER"));
                U.setPassword(result.getString("Password"));
            }
            U.setAdditional_data(Get_Option_Values_OF_USER(User_id));
            return U;
        } catch (Exception e) {
            System.out.println("Error in Search User By ID"+e);
        }
        return null;
    }
    
    
    //Emad
    public User Search_user_by_name(String Name) {
        return null;
    }
    
    
    
    //Emad
    public boolean Delete_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Delete("user", "User_ID=" + User_id);
        return check;
    }
    
    
    //Emad
    public boolean Block_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Update("user", "Block=1", "User_ID=" + User_id);
        Db.Close();
        return check;
    }
    
    
  
    //Emad
    public boolean Unblock_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Update("user", "Block=0", "User_ID=" + User_id);
        Db.Close();
        return check;
    }
    
    
    
     //Mohamed RAdwan  
    public int Get_date_iD()
     {
        try
        {
         DB_controller Db = DB_controller.Get_DB_controller();
         //Table date   
         Db.Connect();
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
         HashMap<String,String> Date=new HashMap<>(1);
         Date.put("Date", date.toString());
         Db.Insert("date", Date);
         ResultSet isDate=Db.Select("Date_id", "date", "Date="+date.toString());
         return isDate.getInt("Date_id");
          //End Table date 
        }//END Try
         catch(Exception s){    
             s.printStackTrace();
             return -1;
         } 
     }//END Get_date_iD
    

    
    //Mohamed RAdwan
    public String Get_this_date(int ID){
         try
        {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ResultSet res=Db.Select("Date", "date", "Date_id="+ID);
           return res.getString("Date");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }//END //Mohamed RAdwan
    

    //Mohamed RAdwan 
    public String Get_time()
    {
         DB_controller Db = DB_controller.Get_DB_controller();
         Db.Connect();
         SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
         Date date = new Date();
         return  date.toString(); 
    }//END Get_time
    
    
    
    
    public boolean Add_New_phone_to_branch(String New_phone, int Branch_id)
    {
        return false;
    }
    
    
    
    public boolean Delete_branch_phone(int phone_id , int Branch_id)
    {
        return false;
    }
    
    
    public boolean Update_branch_phone(int Old_phone_id , int Branch_id , String New_phone)
    {
        return false;
    }
    
    
    
    
     //Emad
    //pre Path the name of new user and the parent id 
    //post add to table type user
    private int add_new_actor (String Name,int Parent_id)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name", Name);
        H.put("parent_id",Integer.toString(Parent_id));
        return Db.Insert("type_user", H);
    }
    
    
    
    
    
        //Emad
    public String Search_User_OptionByID(int Option_ID)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result=Db.Select("*","user_option","User_Option_ID="+Option_ID);
        try
        {
            while(result.next())
            {
                return result.getString("Name");
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in Search Option");
        }
        return null;
    }
    
    
    
    
    //Emad
    public int Search_User_OptionByName(String Option_Name)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result=Db.Select("*","user_option","Name='"+Option_Name+"'");
        try
        {
            while(result.next())
            {
                return result.getInt("User_option_id");
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in Search Option");
        }
        return -1;
    }
    
    
    
    
    
    //Emad
    //pre Path Type_OPTION_ID(text,int,....),and Name OF Type
    //post Add to Table user_option 
    public int add_user_option (int Type_ID,String Name)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name",Name);
        H.put("Type_id", Integer.toString(Type_ID));
        return Db.Insert("user_option", H);
    }
    
    
    
    
    
      //Emad
    public int Add_to_actor_Option (int user_type_id,int Option_ID)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
            HashMap<String,String> H=new HashMap<String,String>();
            H.put("User_Type_ID",Integer.toString(user_type_id));
            H.put("user_option_id",Integer.toString(Option_ID));
            int i=Db.Insert("User_Selected_Option", H);
        Db.Close();
        return i;
    }
    
    
    
    //Emad
    public ArrayList<Integer> All_Options_Available(int Type_ID)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ArrayList<Integer> A=new ArrayList<Integer>();
        ResultSet result = Db.Select("*", "user_selected_option","user_type_id="+Type_ID);
        try
        {
            while(result.next())
            {
                A.add(result.getInt("user_option_id"));
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in All Option Available");
        }
        Db.Close();
        return A;
    }
    
    
    //Emad
    public void Insert_Option_Values(User U,int User_ID)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        for(Map.Entry<Integer,String> entry:U.getAdditional_data().entrySet())
        {
            HashMap<String,String> H=new HashMap<String,String> ();
            H.put("User_ID",Integer.toString(User_ID));
            H.put("User_option_id",Integer.toString(entry.getKey()));
            H.put("value",entry.getValue());
            Db.Insert("user_selected_option_values",H);
        }
        Db.Close();
    } 
    
    
    
    
    
    //Emad
    public HashMap <Integer,String> Get_Option_Values_OF_USER(int  User_id)
    {
        HashMap <Integer,String> H=new HashMap<Integer,String> ();
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*","user_selected_option_values","User_ID="+User_id);
        try
        {
            while(result.next())
            {
                H.put((result.getInt("User_option_id")),result.getString("Value"));
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in GET OPTION VALUES");
        }
        return H;
    }
    
    
    
    //Emad
    public ArrayList<String> Get_Options_OF_TYPE(int  Type_ID)
    {
        ArrayList<String> A=new ArrayList<String>();
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result=Db.Select("*","user_option","Type_ID="+Type_ID);
        try
        {
            while(result.next())
            {
                A.add(result.getString("NAME"));
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in GET OPTION OF TYPES");
        }
        return A;
    }
    
    
    
    
    
    
    public boolean Upload_file(File file)
    {
        return false;
    }
    
    public boolean Dawnload_file(File file)
    {
        return true;
    }
    
    
    
    public String Decription (String Word)
    {
        return null;
    }
    
    
    public String Incription (String Word)
    {
        return null;
    }
    
    
    
    
    public int Check_type(String Username , String Password)
    {
        return 0;
    }
    
    
    
    public boolean Make_History(History history)
    {
        return true;
    };
    
    
}
