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
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emad
 */
public class System_manage {

    private static System_manage system_manage = null;

    private System_manage() {
    }

    public static System_manage Get_System_manage() {
        if (system_manage == null) {
            system_manage = new System_manage();
        }
        return system_manage;
    }

    
    
    public Systemreport Get_System_Report()
    {
        return null;
    }
    
    
    
    public BranchReport Get_Branch_Report(Branch branch)
    {
        BranchReport b = new BranchReport(branch);
        return b;
    }

    


    //sala7
    public Branch Search_branch(int Branch_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        Branch branch = new Branch();
        ResultSet result = Db.Select(" * ", " branch ", " Branch_id = " + Branch_id);

        int location=-1;
        try {
            while(result.next())
            {
              branch.setId(result.getInt("Branch_id"));
              branch.setMnager_id(result.getInt("User_id"));
              branch.setPhones(get_branch_phones(Branch_id));
              branch.setAddress_id(result.getInt("Address_id"));
              ArrayList <Integer> sub = branch.Get_Subscriber(Branch_id);
              branch.setSubscriber(sub);
              branch.SetNotfy_message(branch.Get_notify(Branch_id));
              
            }
        } catch (SQLException ex) {
            Db.Close();
            return null;
        }
        Db.Close();
        return branch;
    }

    
    //sala7
    public ArrayList <Spare_parts> Get_spare_parts(int bill_id)
    {   
       DB_controller DB = DB_controller.Get_DB_controller();
       ArrayList <Spare_parts> spare = new ArrayList<>();
       DB.Connect();
       Spare_parts s = new Spare_parts();
       ResultSet result = null;
       
       result = DB.Select(" Spare_parts_id ", " details_bill ", " Bill_id = " + bill_id);
       int spare_id = -1;
       try {
           while(result.next())
           {
             spare_id = result.getInt("Spare_parts_id");
           }
          result = DB.Select(" * ", " spare_parts ", " Spare_parts_id = " + spare_id);
          while(result.next())
          {  
             s.setName(result.getString("Name"));
             s.setMony(result.getDouble("Cost"));
             spare.add(s);
          }
          
          return spare;
       } 
          
       catch (SQLException ex) {
          ex.printStackTrace();
         
          return null;
       }
       
    }
    


    //sala7
    public ArrayList<Employee> Show_all_employee(int Employee_type) {

        DB_controller DB = DB_controller.Get_DB_controller();

        ArrayList<Employee> em = new ArrayList<>();


        DB.Connect();
        Employee employee = new Employee();
        Service_Management serv = Service_Management.Get_Serive_Management();
        ResultSet result;
        result = DB.Select(" * ", " user ", " Type_id = " + Employee_type);
        try {
            while (result.next()) {
                employee.setF_name(result.getString("Fname"));
                employee.setL_name(result.getString("Lname"));
                employee.setEmail(result.getString("Email"));
                employee.setPassword(result.getString("Password"));
                employee.setType_id(result.getInt("Type_id"));
                employee.setGander(result.getString("gender"));
                employee.setBlock(result.getInt("Account_block"));
                employee.setAddresses(serv.Get_User_Phone(Employee_type));
                employee.setPhones(serv.Get_User_Phone(Employee_type));
              /*  switch (Employee_type) {
                    case 1:
                        employee.setAdditional_data(Get_Option_Values_OF_USER(Employee_type));
                        break;
                    case 2:
                        employee.setAdditional_data(Get_Option_Values_OF_USER(Employee_type));
                        break;
                    case 3:
                        employee.setAdditional_data(Get_Option_Values_OF_USER(Employee_type));
                        break;
                    case 4:
                        employee.setAdditional_data(Get_Option_Values_OF_USER(Employee_type));
                        break;
                    default:
                        break;
                }*/
                em.add(employee);
            }

            return em;

        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.Close();
        }

        return null;
    }

    //sala7
    public Bill_inf Search_bill(int Order_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        Bill bill = new Bill();
        Bill_inf bill_inf = new Bill_inf();
        Payment_Method P = new Payment_Method();
        HashMap<String, String> H = new HashMap<String, String>();
        int bill_ID = -1;
        ResultSet result = Db.Select("*", " bill ", " Order_id = " + Order_id);
        try {

            while(result.next()){
               bill.setId(result.getInt("BILL_id"));
               bill.setDate_id(result.getInt("Date_id"));
               bill.setCost(result.getDouble("Cost"));
               bill.setMy_order(result.getInt("Order_id"));
               bill.setTime(result.getString("Time"));
               bill_inf.setMy_bill(bill);
               bill_ID = result.getInt("BILL_id");
               HashMap <Integer , String > contain = P.Get_payment_type_in_bill(bill_ID);
               bill_inf.setPayment_method_info(contain);
       
            }
         

            while (result.next()) {
                bill.setId(result.getInt("BILL_id"));
                bill.setDate_id(result.getInt("Date_id"));
                bill.setCost(result.getDouble("Cost"));
                bill.setMy_order(result.getInt("Order_id"));
                bill.setTime(result.getString("Time"));
                bill_ID = result.getInt("BILL_id");
                P.Get_payment_type_in_bill(bill_ID);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
       return bill_inf;
    }

    
    
    
    


    //sala7

    public Feedback Search_feedback(int Order_id) {
        Feedback feedback = new Feedback();
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*", "feedback", " Order_id = " + Order_id);
        try {
            while (result.next()) {
                feedback.setId(result.getInt("Feedback_id"));
                feedback.setMy_order(result.getInt("Order_id"));
                feedback.setService_quality(result.getInt("System_quality"));
                feedback.setSystem_quality(result.getInt("Service_quality"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Db.Close();
            return null;
        }
        Db.Close();
        return feedback;
    }

    //Emad Done
    public void Add_User(User user) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> U = new HashMap<>();
        U.put("Fname", user.getF_name());
        U.put("Lname", user.getL_name());
        U.put("Email", user.getEmail());
        U.put("Password", user.getPassword());
        U.put("Gender", user.getGander());
        U.put("Block", "" + user.getBlock());
        Db.Insert("user", U);
        Insert_Option_Values(user, user.getID());
        HashMap<Integer, String> H = new HashMap<Integer, String>();
        H = user.getPhones();
        for (Map.Entry<Integer, String> entry : H.entrySet()) {
            HashMap<String, String> In = new HashMap<String, String>();
            In.put("User_ID", Integer.toString(user.getID()));
            In.put("phone", entry.getValue());
            Db.Insert("phone", In);
        }
    }




    //Emad Done
    public Object Search_user_by_id(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Service_Management s = Service_Management.Get_Serive_Management();
        Db.Connect();
        String S;
        int Type_ID = -1;
        User U = null;
        try {
            ResultSet result = Db.Select("*", "user", "User_id=" + User_id);
            while (result.next()) {
                Type_ID = result.getInt("Type_ID");
                if (Type_ID == 5) {
                    U = new Customer();
                } else {
                    U = new Employee();
                }
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getString("GENDER"));
                U.setPassword(result.getString("Password"));
                U.setType_id(Type_ID);                
            }
           U.setAdditional_data(Get_Option_Values_OF_USER("user_selected_option_values","User_id-"+User_id));;
           U.setPhones(s.Get_User_Phone(User_id));
           U.setAddresses(s.Get_User_Address(User_id));
                return U;
            }catch (Exception e) {

           System.out.println("Error in Search User By ID"+e);
       }
            return null;
        }
    
        //Emad Done
    public User Search_user_by_name(String Name) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Service_Management s = Service_Management.Get_Serive_Management();
        Db.Connect();
        String S;
        int Type_ID = -1;
        User U = null;
        int id=-1;
        try {
            ResultSet result = Db.Select_BY_Like_Statement("*", "user","FNAME",Name);
            while (result.next()) {
                id=result.getInt("USER_ID");
                Type_ID = result.getInt("Type_ID");
                if (Type_ID == 5) {
                    U = new Customer();
                } else {
                    U = new Employee();
                }
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getString("GENDER"));
                U.setPassword(result.getString("Password"));
                U.setType_id(Type_ID);
                
            }

           U.setAdditional_data(Get_Option_Values_OF_USER("user_selected_option_values","User_id-"+id));
           U.setPhones(s.Get_User_Phone(id));
           U.setAddresses(s.Get_User_Address(id));
                return U;
            }catch (Exception e) {
           System.out.println("Error in Search User By Name"+e);
       }
       return null;
   }
    
    
    
    //Emad   Done
    public boolean Delete_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Delete("user", "User_ID=" + User_id);
        Db.Delete("user_selected_option_values", "User_ID=" + User_id);
        Db.Delete("phone", "User_ID=" + User_id);
        Db.Delete("user_address", "User_ID=" + User_id);
        return check;
    }

    //Emad Done
    public boolean Block_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Update("user", "Block=1", "User_ID=" + User_id);
        Db.Close();
        return check;
    }

    //Emad Done
    public boolean Unblock_user(int User_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        boolean check = Db.Update("user", "Block=0", "User_ID=" + User_id);
        Db.Close();
        return check;
    }

    //Mohamed RAdwan  
    public int Get_date_iD() {
        DB_controller Db = DB_controller.Get_DB_controller();
        //Table date   
        Db.Connect();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        String strDate = sdf.format(cal.getTime());
        try {
            ResultSet isDate = Db.Select("Date_id", "date", "Date='" + strDate + "'");
            while (isDate.next()) {
                return isDate.getInt("Date_id");
            }
            HashMap<String, String> Date = new HashMap<>(1);
            Date.put("Date", strDate);
            return Db.Insert("date", Date);
        }//END Try
        catch (Exception s) {
            s.printStackTrace();
        }
        return -1;
    }//END Get_date_iD

    //Mohamed RAdwan
    public String Get_this_date(int ID) {
        try {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ResultSet res = Db.Select("Date", "date", "Date_id=" + ID);
            return res.getString("Date");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }//END //Mohamed RAdwan

    //Mohamed RAdwan 
    public String Get_time() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdf.format(cal.getTime());
        return strDate;
    }//END Get_time

    
    
    //Emad D
    //pre Path Type_OPTION_ID(text,int,....),and Name OF Type
    //post Add to Table user_option 
    public int add_option(int Type_ID, String Name) {
        DB_controller DB = DB_controller.Get_DB_controller();

        DB.Connect();
        HashMap<String, String> H = new HashMap<String, String>();
        H.put("Name", Name);
        H.put("Type_id", Integer.toString(Type_ID));
        return DB.Insert("user_option", H);
    }

    public boolean Add_New_phone_to_branch(String New_phone, int Branch_id) {
        return false;
    }
    
    
    //sala7
     public ArrayList<String> get_branch_phones( int branch_id ) {
         
         ArrayList <String> phone = null;
         DB_controller DB = DB_controller.Get_DB_controller();
         DB.Connect();
         
         ResultSet result = null;
         result = DB.Select(" phone ", " branch_phone ", " Branch_id = " + branch_id);
         String Phone = "";
         try {
            while(result.next())
            {
               phone.add(result.getString("phone"));
            }
            return phone;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.Close();
        }
        DB.Close();
        return null;
     }
    
    


    public boolean Delete_branch_phone(int phone_id, int Branch_id) {
        return false;
    }

    public boolean Update_branch_phone(int Old_phone_id, int Branch_id, String New_phone) {
        return false;
    }

    //Emad Done
    //pre Path the name of new user and the parent id 
    //post add to table type user
    private int add_new_actor(String Name, int Parent_id) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();

        HashMap<String,String> H=new HashMap<>();
        H.put("Name", Name);
        H.put("parent_id", Integer.toString(Parent_id));
        return Db.Insert("type_user", H);
    }

    //Emad Done
    public String Search_User_OptionByID(int Option_ID)
    {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*", "user_option", "User_Option_ID=" + Option_ID);
        try {
            while (result.next()) {
                return result.getString("Name");
            }
        } catch (Exception E) {
            System.out.println("Error in Search Option");
        }
        return null;
    }
    //Emad  
    public int Search_User_OptionByName(String Option_Name) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ResultSet result = Db.Select("*", "user_option", "Name='" + Option_Name + "'");
        try {
            while (result.next()) {
                return result.getInt("User_option_id");
            }
        } catch (Exception E) {
            System.out.println("Error in Search Option");
        }
        return -1;
    }

    //Emad  Done
    //pre Path Type_OPTION_ID(text,int,....),and Name OF Type
    //post Add to Table user_option 
    public int add_user_option(int Type_ID, String Name) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> H = new HashMap<String, String>();
        H.put("Name", Name);
        H.put("Type_id", Integer.toString(Type_ID));
        return Db.Insert("user_option", H);
    }

    //Emad  Done
    public int Add_to_actor_Option(int user_type_id, int Option_ID) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> H = new HashMap<String, String>();
        H.put("User_Type_ID", Integer.toString(user_type_id));
        H.put("user_option_id", Integer.toString(Option_ID));
        int i = Db.Insert("User_Selected_Option", H);
        Db.Close();
        return i;
    }

    //Emad  Done
    public ArrayList<Integer> All_Options_Available(int Type_ID) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ResultSet result = Db.Select("*", "user_selected_option", "user_type_id=" + Type_ID);
        try {
            while (result.next()) {
                A.add(result.getInt("user_option_id"));
            }
        } catch (Exception E) {
            System.out.println("Error in All Option Available");
        }
        Db.Close();
        return A;
    }

    //Emad  Done
    public void Insert_Option_Values(User U, int User_ID) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        for (Map.Entry<Integer, String> entry : U.getAdditional_data().entrySet()) {
            HashMap<String, String> H = new HashMap<String, String>();
            H.put("User_ID", Integer.toString(User_ID));
            H.put("User_option_id", Integer.toString(entry.getKey()));
            H.put("value", entry.getValue());
            Db.Insert("user_selected_option_values", H);
        }
        Db.Close();
    }

    //Emad  Done
    public HashMap<Integer, String> Get_Option_Values_OF_USER(String TableName,String Condition) {
        HashMap<Integer, String> H = new HashMap<Integer, String>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*",TableName,Condition);
        try {
            String Column=null;
            if(TableName.equals("user_selected_option_values"))
            {
                Column="User_selected_option_id";
            }
            else if(TableName.equals("selected_device_option_values"))
            {
                Column="Model_id";
            }
            else
            {
                Column="Log_on_select_id";
            }
            while (result.next())
            {
                System.out.println("HERE");
                H.put((result.getInt(Column)), result.getString("Value"));
            }                
            }
        catch (Exception E)
        {
            System.out.println("Error in GET OPTION VALUES+ " + E);
        }
        return H;
    }
    
    //Emad Done
    public String Get_Option_Value(int User_ID , int Option_Value) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("Value", "user_selected_option_values", "User_ID=" + User_ID +" and User_selected_option_id="+Option_Value);
        try {
            while (result.next()) {
                return result.getString("Value");
            }
        } catch (Exception E) {
            System.out.println("Error in Option Value");
        }
        return null;
    }

    //Emad  Done
    public ArrayList<String> Get_Options_OF_TYPE(int Type_ID) {
        ArrayList<String> A = new ArrayList<String>();
        ArrayList<Integer> Ids = new ArrayList<Integer>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*", "user_selected_option", "User_type_id=" + Type_ID);
        try {
            while (result.next()) {
                Ids.add(result.getInt("User_option_id"));
            }
            for (int i = 0; i < Ids.size(); i++) {
                result = DB.Select("*", "user_option", "User_option_id=" + Ids.get(i));
                while (result.next()) {
                    A.add(result.getString("Name"));
                }
            }
        } catch (Exception E) {
            System.out.println("Error in GET OPTION OF TYPES");
        }
        return A;
    }

    public boolean Upload_file(File file) {
        return false;
    }

    public boolean Dawnload_file(File file) {
        return true;
    }

    public String Decription(String Word) {
        return null;
    }

    public String Incription(String Word) {
        return null;
    }

    //Sala7
    //return 1 -> this is Customer
    //returb 2 -> this is Employee
    public int Check_type(String Username, String Password) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result;
        result = DB.Select("Type_id", " user ", " Email =  '" + Username + "'" + " and " + "Password = '" + Password + "'");
        int type_id = -1;
        try {
            while (result.next()) {
                type_id = result.getInt("Type_id");
            }
            if (type_id == 5) {
                return 1;
            } else {
                return 2;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.Close();
        }

        return 0;
    }

 
    public boolean Make_History(History history) 
    {
        return true;
    }
 
}
