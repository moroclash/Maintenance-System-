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

    
    public int Get_ModeL_ID(String Name)
    {
        int id=-1;
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("*", "model", "Name="+"'"+Name+"'");
        try
        {
            while(result.next())
            {
                id=result.getInt("Model_id");
            }
        }
            catch(Exception E)
            {
                
            }
        return id;
    }
    
    public int Insert_Device(int Model_ID)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Model_Id",Integer.toString(Model_ID));
        H.put("State_id","5");
        return DB.Insert("device", H);
    }
    
    
    
     public int Get_Option_Device_ID(String Name)
    {
        int id=-1;
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("","","name="+"'"+Name+"'");
        try
        {
            while(result.next())
            {
                id=result.getInt("Device_option_id");
            }
        }
        catch(Exception E)
        {
            
        }
        return id;
    }
     
      public void Insert_Additional_Info_Dev(int model,int Option_ID,String value)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Model_id",Integer.toString(model));
        H.put("Selected_device_id",Integer.toString(Option_ID));
        H.put("Value",value);
        DB.Insert("selected_device_option_values", H);
    }
     
     
     public  void Insert_requist(int User_ID,int Date_ID,int Address_ID)
     {
         DB_controller Db= DB_controller.Get_DB_controller();
         Db.Connect();
         HashMap<String,String> H = new HashMap<>();
         H.put("User_id", Integer.toString(User_ID));
         H.put("Date_id", Integer.toString(Date_ID));
         H.put("State_id", "4");
         H.put("Address_id", Integer.toString(Address_ID));
         Db.Insert("request", H);
     }
    
    
    
    //omar
    public Systemreport Get_System_Report()
    {
        Systemreport report = new Systemreport();
        try {
            ArrayList<Branch> Branches = new ArrayList<>();
            int ComplainNumper = 0;
            int Employeenum = 0;
            double presentage = 0;
            double Salaries = 0;
            int EmployeeComplainNum = 0;
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ResultSet res = Db.Select("Branch_id", "branch", "1");
            int branch_id = 0;
            Branch branch = null;
            BranchReport B_report = null;
            while(res.next())
            {
                branch_id = res.getInt("Branch_id");
                branch=Search_branch(branch_id);
                Branches.add(branch);
                B_report = new BranchReport(branch);
                ComplainNumper += B_report.getCustomer_ComplainNumper();
                Employeenum += B_report.getEmployeNum();
                presentage += B_report.getPresantage();
                Salaries += B_report.getSalaries();
                EmployeeComplainNum += B_report.getEmployee_ComplainNumper();
            }
            res = Db.Select("User_id", "user", "Type_id=5");
            int customernumper = 0;
            while(res.next())
            {
                customernumper++;
            }
            report.setBrach_Quality(Branches);
            report.setCustomer_ComplainNumper(ComplainNumper);
            report.setCustomernumber(customernumper);
            report.setEmployeNum(Employeenum);
            report.setPresantage(((presentage/(Branches.size()*100))*100));
            report.setSalaries(Salaries);
            report.setEmployee_ComplainNumper(EmployeeComplainNum);
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report;
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
    public Spare_parts Get_spare_parts(int bill_id)
    {   
       DB_controller DB = DB_controller.Get_DB_controller();
       HashMap<String,Double>spare=new HashMap<>(5);
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
             spare.put(result.getString("Name"),result.getDouble("Cost"));
          }
          s.setNAmeMony(spare);
          
          return s;
       } 
          
       catch (SQLException ex) {
          ex.printStackTrace();
         
          return null;
       }
       
    }
    
    
    public int Get_ID_OF_Device_Option(String Name) 
        {
            DB_controller DB = DB_controller.Get_DB_controller();
            DB.Connect();
            int ID = -1;
            ResultSet result = DB.Select("Device_option_id", "device_option", "name=" + Name);
            try {
                while (result.next()) {
                    ID = result.getInt("Device_option_id");
                }
            } catch (Exception E) {

            }
            return ID;
        }
    
    
    public ArrayList<String> Get_All_Device_Option() {
        DB_controller DB = DB_controller.Get_DB_controller();
        ArrayList<String> S = new ArrayList<String>();
        ResultSet result = DB.Select("*", "device_option", "1");
        try {
            while (result.next()) {
                S.add(result.getString("name"));
            }
        } catch (Exception E) {

        }
        return S;
    }
    
     public void Insert_New_Att_Device(String Name) 
    {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("name", Name);
        S.put("type_id",""+0);
         DB.Insert("device_option", S);
    }
     
     
     
     
   

    public int Insert_New_Device_Type(String Name) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("name", Name);
        return DB.Insert("device_type", S);
    }

    public int Search_Factor(String NAme) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        int ID = -1;
        ResultSet result = DB.Select("Main_factor_id", "main_factor", "name=" + NAme);
        try {
            while (result.next()) {
                ID = result.getInt("Main_factor_id");
            }
        } catch (Exception E) {

        }
        return ID;
    }

    public int Insert_New_Factor(String Name) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("name", Name);
        return DB.Insert("main_factor", S);
    }

    public int Insert_Into_Company_Device(int CID, int DID) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("Main_factor_id", Integer.toString(CID));
        S.put("Device_type_id", Integer.toString(DID));
        return DB.Insert("company_have_device", S);
    }

   
    
    public void select_device_option(int TID, int OID) 
    {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("Device_type_id", Integer.toString(TID));
        S.put("device_option_id", Integer.toString(OID));
         DB.Insert("select_device_option", S);
    }
  
    public void Insert_new_Factor(String Name) 
    {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> S = new HashMap<String, String>();
        S.put("name", Name);
         DB.Insert("main_factor", S);
    } 
    public Feedback Get_Sta (int Branch_ID)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        Feedback F=new Feedback();
        ResultSet re=DB.Select("*","feedback", "Branch_id="+Branch_ID);
        try {
            while(re.next())
            {
                F.setBranch_id(Branch_ID);
                F.setService_quality(re.getInt("Service_quality"));
                F.setSystem_quality(re.getInt("System_quality"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return F;
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
                employee.setGander(result.getInt("gender"));
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
        Bill_inf bi_inf = new Bill_inf();
        Payment_Method P = new Payment_Method();
        int bill_id = -1;
        ResultSet result = Db.Select("*", " bill ", " Order_id = " + Order_id);
        try {

            while(result.next()){
                bill_id = result.getInt("BILL_id");        
             bill.setId(result.getInt("BILL_id"));
             bill.setCost(result.getDouble("Cost"));
             bill.setDate_id(result.getInt("Date_id"));
             bill.setMy_order(result.getInt("Order_id"));
             bill.setTime(result.getString("Time"));
             bill.setTechincal_id(result.getInt("Technical_id"));
             bi_inf.setMy_bill(bill);
             bi_inf.setBILL_St(result.getString("TEXT_BIll"));
             int Pa=result.getInt("Payment_method_id");
             bi_inf.setPayment_method_info(Service_Management.Get_Serive_Management().Get_NAme_PaymentMethode(Pa));
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
       return bi_inf;
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
    public int Add_User(User user) {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> U = new HashMap<String, String>();
        U.put("Fname", user.getF_name());
        U.put("Lname", user.getL_name());
        U.put("Email", user.getEmail());
        U.put("Password", user.getPassword());
        U.put("Gender", Integer.toString(user.getGander()));
        U.put("Block", "" + user.getBlock());
        U.put("Type_ID", "" + user.getType_id());
        int ID = Db.Insert("user", U);
            Insert_Option_Values(user, ID);
            
            HashMap<Integer, String> H = new HashMap<Integer, String>();
            H = user.getPhones();

            if (H != null) {
                for (Map.Entry<Integer, String> entry : H.entrySet()) {
                    HashMap<String, String> In = new HashMap<String, String>();
                    In.put("User_ID", Integer.toString(ID));
                    In.put("phone", entry.getValue());
                    Db.Insert("phone", In);

                }
                
            }
            return ID;
    }



    public int Get_Question_ID(String Name)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("*","security_question","Question="+"'"+Name+"'");
        int id=-1;
        try
        {
            while(result.next())
            id=result.getInt("Security_question_id");
        }
        catch(Exception E)
        {
         
        }
        return id;
    }    

    
    public ArrayList<String> Get_All_HTML_Attributes(ArrayList<String> Names) {
        ArrayList<String> Html = new ArrayList<String>();
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        String Temp = "";
        String Temp2 = "";
        String Temp3 = "";
                String Temp4 = "";

        try {
            for (int j = 0; j < Names.size(); j++) {
                ResultSet result = DB.Select("*", "filed_html", "Filed_html_id=1" );
                while (result.next()) {
                    Temp = result.getString("Html");
            Temp2 = Temp.replace("for=\"\"", "for=\"" + Names.get(j) + "\"");
            Temp3 = Temp2.replace("</label>", "</label>" + Names.get(j) + ":");
            Temp4 = Temp3.replace("<input", "<input name=" + "'" + Names.get(j) + "'");
            Html.add(Temp4);
                }
            }
        } catch (Exception E) {
            System.out.println(E);
        }
        return Html;
        
    }
    
    
    public String name_device_option(int id)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        String name="";
        ResultSet result=DB.Select("*","device_option","Device_option_id="+id);
        try
        {
            while(result.next())
            {
                name=result.getString("name");
            }
        }
        catch(Exception E)
        {
            
        }
        System.out.println("fffff"+name);
        return name; 
    }
    
    
    
    public ArrayList<Integer> Device_Options_ID(int Device_type)
    {
        ArrayList<Integer> A=new ArrayList<Integer>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("*","select_device_option","Device_type_id="+Device_type);
        try
        {
            while(result.next())
            {
                A.add(result.getInt("device_option_id"));
            }
        }
        catch(Exception E)
        {
            
        }
        return A;
    }
    
    
     //Emad

    public ArrayList<String> Get_Company_Device_Names(int Company_ID) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<String> Names = new ArrayList<String>();

        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*", "company_have_device", "Main_factor_id=" + Company_ID);
        try {
            while (result.next()) {
                A.add(result.getInt("Device_type_id"));
            }
            for (int i = 0; i < A.size(); i++) {
                result = DB.Select("name", "device_type", "Device_type_id=" + A.get(i));
                while (result.next()) {
                    Names.add(result.getString("name"));
                }
            }
        } catch (Exception E) {

        }
        return Names;
    }
    
    public ArrayList<String> Get(int Device_Type, int Company_ID) {
        DB_controller DB = DB_controller.Get_DB_controller();
        ArrayList<String> S = new ArrayList<String>();
        DB.Connect();
        ResultSet result = DB.Select("Name", "model join company_have_device on Main_factor_id=Comp_device_id", "Device_type_id=" + Device_Type + " and " + "Main_factor_id=" + Company_ID);
        try {
            while (result.next()) {
                S.add(result.getString("Name"));
            }
        } catch (Exception E) {

        }
        return S;
    }
    
    public ArrayList<String> Country(int ID)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ArrayList<String>S=new ArrayList<String>();
        ResultSet re=DB.Select("Address","address","Parent_id="+ID);
        try
        {
            while(re.next())
            {
                S.add(re.getString("Address"));
            }
        }
        catch(Exception E)
        {
            
        }
        return S;
    }
    
    
    public ArrayList<String> Distnict()
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ArrayList<String>S=new ArrayList<String>();
        ResultSet re=DB.Select("Address","address","Parent_id <> 0 and Parent_id <>1");
        try
        {
            while(re.next())
            {
                S.add(re.getString("Address"));
            }
        }
        catch(Exception E)
        {
            
        }
        return S;
    }
    
     //Emad
    public HashMap<String, String> Load_HTML_Types(int ID) {
        HashMap<String, String> H = new HashMap<String, String>();
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<String> St = new ArrayList<String>();
        ResultSet result = DB.Select("*", "user_selected_option", "User_type_id=" + ID);
        try {
            while (result.next()) {
                A.add(result.getInt("User_option_id"));
            }
            for (int i = 0; i < A.size(); i++) {
                result = DB.Select("*", "user_option", "User_option_id=" + A.get(i));
                while (result.next()) {
                    St.add(result.getString("Name"));
                }
            }
            for (int i = 0; i < St.size(); i++) {
                result = DB.Select("*", "filed_html", "Filed_html_id=1");
                while (result.next()) {
                    H.put(St.get(i), result.getString("Html"));
                }
            }
        } catch (Exception E) {

        }
        return H;
    }
    
     //Emad
    public ArrayList<String> Last_Shape_Of_HTML_Attributes_Types(HashMap<String, String> H) {
        ArrayList<String> S = new ArrayList<String>();
        String HTML = "";
        String Value = "";
        String Key = "";
        String Temp = "";
        String Temp2 = "";
        String Temp3 = "";
        String Temp4 = "";
        int i = 1;
        for (Map.Entry<String, String> entry : H.entrySet()) {
            Key = entry.getKey();
            Value = entry.getValue();
            Temp = Value.replace("for=\"\"", "for=\"" + Key + "\"");
            Temp2 = Temp.replace("</label>", "</label>" + Key + ":");
            Temp3 = Temp2.replace("<input", "<input name=" + "'" + Key + "'");
            i++;
            S.add(Temp3);
        }
        return S;
    }
    
    public ArrayList<String> Get_Questions()
    {
        ArrayList<String> S=new ArrayList<String>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("*","security_question","1");
        try
        {
            while(result.next())
            S.add(result.getString("Question"));
        }
        catch(Exception E)
        {
         
        }
        System.out.println(S.size());
        return S;
    }
    
    
    public ArrayList<String> HTMLTypes(HashMap<Integer, String> Types) {
        ArrayList<String> HTML = new ArrayList<String>();
        String Text = "";
        String Key = "";
        String Value = "";
        DB_controller DB = DB_controller.Get_DB_controller();
        String Temp = "";
        String Temp2 = "";
        ResultSet result = DB.Select("*", "filed_html", "Filed_html_id=2");
        try {
            while (result.next()) {
                Text = result.getString("Html");
            }
            for (Map.Entry<Integer, String> entry : Types.entrySet()) {
                Temp = Text.replace("value=\"\"", "value=\"" + entry.getValue() + "\"" + "  ");
                Temp2 = Temp.replace("  >", ">" + entry.getValue() + "");
                HTML.add(Temp2);
            }
        } catch (Exception E) {
            System.out.println("Error " + E);
        }
        return HTML;
    }
    
    
     //Emad
    public ArrayList<String> MainFactor() {
        ArrayList<String> A = new ArrayList<String>();
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*", "main_factor", "1");
        try {
            while (result.next()) {
                A.add(result.getString("name"));
            }
        } catch (Exception E) {

        }
        return A;
    }
    
    
     public boolean Check_Block(String Email)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet re=DB.Select("Block","user","Email="+"'"+Email+"'");
        try
        {
          while(re.next())
          {
              if(re.getInt("Block")==1)
                  return true;
          }
        }
        catch(Exception E)
        {
            
        }
        return false;
    }
     
     
     
     //Emad
    public HashMap<String, String> Get_HTML_Attributes(HashMap<Integer, String> V) {
        HashMap<String, String> H = new HashMap<String, String>();
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        String Name = "";
        String HTML = "";
        int Temp = -1;
        ResultSet result = null;
        for (Map.Entry<Integer, String> entry : V.entrySet()) {
            result = DB.Select("*", "user_option", "User_option_id=" + entry.getKey());
            try {
                while (result.next()) {
                    Name = result.getString("Name");
                }
                result = DB.Select("*", "type_filed_html", "Type= 'text'");
                while (result.next()) {
                    Temp = result.getInt("Filed_html_id");
                }
                result = DB.Select("*", "filed_html", "Filed_html_id=" + Temp);
                while (result.next()) {
                    H.put(Name, result.getString("HTML"));
                }
            } catch (Exception E) {

            }
        }
        return H;
    }
    
    
      //Emad
    public ArrayList<String> Last_Shape_Of_HTML_Attributes(HashMap<String, String> H, HashMap<Integer, String> Values) {
        ArrayList<String> S = new ArrayList<String>();
        String HTML = "";
        String Value = "";
        String Key = "";
        String Temp = "";
        String Temp2 = "";
        String Temp3 = "";
        String Temp4 = "";
        int i = 1;
        for (Map.Entry<String, String> entry : H.entrySet()) {
            Key = entry.getKey();
            Value = entry.getValue();
            Temp = Value.replace("for=\"\"", "for=\"" + Key + "\"");
            Temp2 = Temp.replace("</label>", "</label>" + Key + ":");
            Temp3 = Temp2.replace("<input", "<input name=" + "'" + Key + "'");
            Temp4 = Temp3.replace("type=\"text\"", "type=\"text\" Value=" + "'" + Values.get(i) + "'");
            i++;
            S.add(Temp4);
        }
        return S;
    }
    
    
    
    //Emad
    public int Type_ID(String Name) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        int id = -1;
        ResultSet result = DB.Select("*", "device_type", "name=" + "'" + Name + "'");
        try {
            while (result.next()) {
                id = result.getInt("Device_type_id");
            }
        } catch (Exception E) {

        }
        return id;
    }

    
    
    //Emad
    public int Company_ID(String Name) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        int id = -1;
        ResultSet result = DB.Select("Main_factor_id", "main_factor", "name=" + "'" + Name + "'");
        try {
            while (result.next()) {
                id = result.getInt("Main_factor_id");
            }
        } catch (Exception E) {

        }
        return id;
    }
    
    
    
    
    
     public ArrayList<String> Get_All_HTML_Attributes(ArrayList<String> Names, int ID) {
        ArrayList<String> Html = new ArrayList<String>();
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        String Temp = "";
        String Temp2 = "";
        String Temp3 = "";
        int i = 0;
        try {
            for (int j = 0; j < Names.size(); j++) {
                ResultSet result = DB.Select("*", "filed_html", "Filed_html_id=" + ID);
                while (result.next()) {
                    Temp = result.getString("Html");
                    Temp2 = Temp.replace("value=\"\"", "value=\"" + Names.get(i) + "\"" + "  ");
                    Temp3 = Temp2.replace("  >", ">" + Names.get(i));
                    Html.add(Temp3);
                    i++;
                }
            }
        } catch (Exception E) {
            System.out.println(E);
        }
        return Html;
    }




    //Emad
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
                U.setID(User_id);
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getInt("GENDER"));
                U.setPassword(result.getString("Password"));
                U.setType_id(Type_ID);                
            }
           U.setAdditional_data(Get_Option_Values_OF_USER("user_selected_option_values","User_id="+User_id));
           U.setPhones(s.Get_User_Phone(User_id));
           U.setAddresses(s.Get_User_Address(User_id));
                return U;
            }catch (Exception e) {
                return null;
            }
        }
    

    
        //Emad Done
      public ArrayList<User> Search_user_by_name(String Name) {
        DB_controller Db = DB_controller.Get_DB_controller();
        ArrayList<User> A = new ArrayList<User>();
        Service_Management s = Service_Management.Get_Serive_Management();
        Db.Connect();
        String S;
        int Type_ID = -1;
        int id = -1;
        try {
            ResultSet result = Db.Select_BY_Like_Statement("*", "user","FNAME LIKE '%"+Name+"%' OR Lname LIKE '%"+Name+"%'");
            while (result.next()) {
                User U = null;
                Type_ID = result.getInt("Type_ID");
                if (Type_ID == 5) {
                    U = new Customer();
                } else {
                    U = new Employee();
                }
                id = result.getInt("USER_ID");
                U.setID(id);
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getInt("GENDER"));
                U.setBlock(result.getInt("Block"));
                U.setPassword(result.getString("Password"));
                U.setType_id(Type_ID);

                U.setAdditional_data(Get_Option_Values_OF_USER("user_selected_option_values", "User_id=" + id));
                U.setPhones(s.Get_User_Phone(id));
                U.setAddresses(s.Get_User_Address(id));
                A.add(U);
            }
            return A;
        } catch (Exception e) {
            System.out.println("Error in Search User By Name" + e);
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
            String data = "";
            while(res.next())
            {
                data = res.getString("Date");
            }
             return data;
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

    //omar 0_0
    public int Add_New_phone_to_branch(String New_phone, int Branch_id) {
        Validations v = Validations.Get_Validations();
        if (!v.Is_digit(New_phone)) {
            return 0;
        }
        DB_controller.Get_DB_controller().Connect();
        HashMap<String, String> m = new HashMap<>();
        m.put("Branch_id", Integer.toString(Branch_id));
        m.put("phone", New_phone);
        int x = DB_controller.Get_DB_controller().Insert("branch_phone", m);
        DB_controller.Get_DB_controller().Close();
        return x;
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
    
    

    //omar 0_0
    public boolean Delete_branch_phone(int phone_id, int Branch_id) {
        DB_controller.Get_DB_controller().Connect();
        boolean z = DB_controller.Get_DB_controller().Delete("branch_phone", "Branch_phone_id=" + phone_id + " and Branch_id="+Branch_id);
        DB_controller.Get_DB_controller().Close();
        return z;
    }

    
    //omar 0_0
    public boolean Update_branch_phone(int Old_phone_id, int Branch_id, String New_phone) {
        if (!Validations.Get_Validations().Is_digit(New_phone)) {
            return false;
        }
        DB_controller.Get_DB_controller().Connect();
        boolean z = DB_controller.Get_DB_controller().Update("branch_phone", "phone=" + New_phone, "Branch_phone_id=" + Old_phone_id+" and Branch_id="+Branch_id);
        DB_controller.Get_DB_controller().Close();
        return z;
    }

    //Emad Done
    //pre Path the name of new user and the parent id 
    //post add to table type user
    public int add_new_actor(String Name, int Parent_id) {
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
       char s = Word.charAt(0);
       String ss = "";
       ss+=s;
       for(int i=1;i<Word.length();i++)
       {
           ss +=(char) (((int) s)-((int) Word.charAt(i))); 
       }
       return ss;
    }

    public String Incription(String Word) {
       char s = Word.charAt(0);
       String ss = "";
       ss+=s;
       for(int i=1;i<Word.length();i++)
       {
           ss += (char) (((int) s)+((int) Word.charAt(i))); 
       }
       return ss;
    }
    
    
    
     //sala7
    public ArrayList<String> Request_Details(int R_ID)
    {
        ArrayList<String> S=new ArrayList<>();
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("Address","address join request on address.Address_id = request.Address_id "," Request_id = " + R_ID);
        try
        {
            while(result.next())
            {
                S.add(result.getString("Address"));
            }
        result=DB.Select("State","state join request on state.State_id = request.State_id","Request_id = " + R_ID);
        while(result.next())
        {
                S.add(result.getString("State"));
        }
        result=DB.Select("Date","date join request on date.Date_id = request.Date_id ","Request_id = " + R_ID);
        while(result.next())
        {
                S.add(result.getString("Date"));            
        }
        result=DB.Select("Email","user join request on user.User_id = request.User_id ","Request_id = " + R_ID);
        while(result.next())
        {
            S.add(result.getString("Email"));
        }
        }
        catch(Exception E)
        {
            
        }
        return S;
    }
    
    public int Get_id_Question(String Sequirty_question) {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("Security_question_id", "security_question", "Question = '" + Sequirty_question +"'");
       int id = 0;
        try {
            while(result.next())
            {
             id = result.getInt("Security_question_id");
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
           return 0;
        }
        return id;
    }
    
    
    
     public ArrayList<String> get_All_question() {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*", "security_question", "1");
        ArrayList <String> A = new ArrayList<>();
        try {
            while(result.next())
            {
              A.add(result.getString("Question"));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
           return null;
        }
        return A;
    }
     
     
      public boolean Add_new_Branch(Branch branch) {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        HashMap<String,String>H=new HashMap<String,String>();
        H.put("Branch_id",Integer.toString(branch.getId()));
        H.put("User_id",Integer.toString(branch.getManager_id())); 
        H.put("Address_id",Integer.toString(branch.getAddress_id())); 
        branch.Add_Phone(branch.getPhones());
        DB.Insert("branch", H);
        return true;
    }

    
    
    
    
    public void insert_description(int id , String s)
    {
        DB_controller Db =DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String,String> H = new HashMap<>();
        H.put("Device_id", Integer.toString(id));
        H.put("Description", s);
        Db.Insert("description", H);
    }
    

    //Sala7
    //return 1 -> this is Customer
    //returb 2 -> this is Employee
    public int Check_type(String Username, String Password) {
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result;
        result = DB.Select("Type_id", " user ", " Email =  '" + Username + "'" + " and " + "Password = '" + Password + "'");
        int type_id = 0;
        try {
            while (result.next()) {
                type_id = result.getInt("Type_id");
                if (type_id == 5) {
                    return 1;
                 } else {
                    return 2;
                 }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.Close();
        }
        return 0;
    }


    public ArrayList<String> get_All_history()
    {
        try {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ArrayList<String> H = new ArrayList<>();
            String his = "";
            ResultSet res =Db.Select("*", "Log_on", "1");
            while(res.next())
            {
               his = res.getInt("User_id") + "    " + res.getString("Link_id") + "   " + Get_this_date(res.getInt("Date_id")) +  "     " + res.getString("Time");
               H.add(his);
            }
            return H;
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
    
    //omar 
    public boolean Make_History(History history) 
    {
            DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            HashMap<String,String> H = new HashMap<>();
            H.put("Link_id", history.getLink_id());
            H.put("Date_id", Integer.toString(Get_date_iD()));
            H.put("User_id", Integer.toString(history.getUser_id()));
            H.put("Time", Get_time());
            int x = Db.Insert("Log_on", H);
           return true;
    }
    
    
    
      //Emad
   public void Insert_Type_Links(int Type_ID,int Linkid)
   {
       HashMap<String,String> H=new HashMap<String,String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       H.put("User_type_id",Integer.toString(Type_ID));
       H.put("Link_id",Integer.toString(Linkid));
       DB.Insert("user_type_links",H);
   }
   
   
   //Emad
   public int Get_Link_ID(String Name)
   {
       int id=-1;
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","links","Function_name="+"'"+Name+"'");
       try
       {
           while(result.next())
           {
               id=result.getInt("Links_id");
           }
       }
       catch(Exception E)
       {
           
       }
       return id;
   }
   
   
   
   
   //Emad
    public ArrayList<String> Get_All_Links_Of_Actor()
   {
       ArrayList<String> S=new ArrayList<String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","links","1");
       try
       {
           while(result.next())
           {
               S.add(result.getString("Function_name"));
           }
       }
       catch(Exception E)
       {
           
       }
       return S;
   }
    
    
    
    
    //Emad
    public void Insert_Into_User_Option(String Name,int Type_ID)
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       HashMap<String,String> H=new HashMap<String,String>();
       H.put("Name",Name);
       H.put("Type_id",Integer.toString(Type_ID));
       DB.Insert("user_option", H); 
   }
   
   
    
    
    //Emad
    public void Insert_Into_User_option(int Type_ID,int Option_ID)
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       HashMap<String,String> H=new HashMap<String,String>();
       H.put("User_type_id",Integer.toString(Type_ID));
       H.put("User_option_id",Integer.toString(Option_ID));
       DB.Insert("user_selected_option", H);
   }
   public int Get_ID_Type(String Name)
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","type","Name="+"'"+Name+"'");
       int id=-1;
       try {
           while(result.next())
           {
               id=result.getInt("Type_id");
           }
       } catch (SQLException ex) {
           Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
       }
       return id; 
   }
   
   
   
   //Emad
    public int Get_Option__Attribute_ID(String Name)
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","user_option","Name="+"'"+Name+"'");
       int id=-1;
       try {
           while(result.next())
           {
               id=result.getInt("User_option_id");
           }
       } catch (SQLException ex) {
           Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
       }
       return id;
   }

    
    //Emad
    public ArrayList<String> Get_All_Attributes_OF_ALL_ACTOR()
   {
       ArrayList<String> S=new ArrayList<String>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","user_option","1");
       try
       {
           while(result.next())
           {
               S.add(result.getString("Name"));
           }
       }
       catch(Exception E)
       {
           System.out.println(E);
       }
       return S;
   }
        
        
    
     //Emad
   public int Get_Option_ID(String Name)
   {
       int id=-1;
       DB_controller DB=DB_controller.Get_DB_controller();
       ResultSet result =DB.Select("*","user_option","Name="+"'"+Name+"'");
       try
       {
           while(result.next())
           {
               id=result.getInt("User_option_id");
           }
       }
       catch(Exception E)
       {
           
       }
       return id;
   }   
    
   
   //Emad
    public int Type_Actor(String Name)
   {
       int ID=-1;
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","type_user","Name="+"'"+Name+"'");
       try {
           while(result.next())
           {
               ID=result.getInt("Type_user_id");
           }
       } catch (SQLException ex) {
           Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
       }
       return ID;
   }
    
    
    //Emad
    public HashMap<Integer,String> User_Types()
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       HashMap<Integer,String> Types=new HashMap<Integer,String>();
       ResultSet result=DB.Select("*","type_user","1");
       try 
       {
           while(result.next())
           {
               Types.put(result.getInt("Type_user_id"),result.getString("name"));
           }
       } catch (SQLException ex) {
           System.out.println("User_Types"+ex);
       }
       return Types;
   }
    
   
}
    
    
    
    
    
