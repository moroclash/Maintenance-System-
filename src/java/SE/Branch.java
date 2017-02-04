
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Branch {
    private int Id;


    private int Address_id;

    private int Manager_id;
    private ArrayList<String> phones;
    private ArrayList <Integer> Subscriber;
    private String notfy_message;

    public int getManager_id() {
        return Manager_id;
    }

    public void setNotfy_message(String notfy_message) {
        this.notfy_message = notfy_message;
    }

    public String getNotfy_message() {
        return notfy_message;
    }
    
    
      public boolean Add_Phone (ArrayList<String> phone)
    {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       HashMap<String,String> M;
      
       
        for (String s:phone) {
          M=new HashMap<>();
          M.put("Branch_id", Integer.toString(Id));
          M.put("phone",s );
          DB.Insert("branch_phone", M);
        }
       return true;
    }
    
    
    //sala7
    public String Get_notify (int branch_id)
    {
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = null;
        result = DB.Select("Content", "message", "sender_id = " + branch_id + " and " + "Type_id = 3");
        String notify = "";
        try {
            while(result.next())
            {
               notify = result.getString("Content");
            }
            return notify;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "";
        }
        
    }
    
   
    //sala7
    public ArrayList <Integer> Get_Subscriber(int branch_id)
    {
        ArrayList <Integer> sub = new ArrayList<>();
        
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = null;
        result = DB.Select("User_id", "Subscriber", "Branch_id = " + branch_id);
        try {
            while(result.next())
            {
              int subscribe = result.getInt("User_id");
              sub.add(subscribe);
            }
            return sub;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
      
    }

    public void setSubscriber(ArrayList<Integer> Subscriber) {
        this.Subscriber = Subscriber;
    }

    public ArrayList<Integer> getSubscriber() {
        return Subscriber;
    }
    
    
    public void setMnager_id(int Mnager_id){
        this.Manager_id = Mnager_id;
    }

    public int getAddress_id() {
        return Address_id;
    }

    public void setAddress_id(int Address_id) {
        this.Address_id = Address_id;
    }

    public int getMnager_id() {
        return Manager_id;
    }

    
    //sala7
    public  void push (String value)
    {
       this.phones.add(value); 
    }
    public int getId() {
        return Id;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

   

    public void setId(int Id) {
        this.Id = Id;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }
    
    
    
     //Emad D
   public double Show_salaris()
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       ArrayList<Integer> EmployeesSalaries=new ArrayList<Integer>();
       DB.Connect();
       int Total_Salary=0;
       int ID_SALARY=-1;
       int Branch_ID=-1;       
       try
       {
           ResultSet result =DB.Select("*", "User_OPTION","Name='Salary'");
           while(result.next())
           {
               ID_SALARY=result.getInt("User_Option_ID");
           }
            result =DB.Select("*", "user_selected_option","Name='Branch_ID'");
           while(result.next())
           {
               Branch_ID=result.getInt("User_Option_ID");
           }           
           result=DB.Select("*", "user_option", "User_Option_ID="+Branch_ID);
           while(result.next())
           {
               EmployeesSalaries.add(result.getInt("User_Type_ID"));
           }
           System_manage S=System_manage.Get_System_manage();
           for(int i=0;i<EmployeesSalaries.size();i++)
           {
               result=DB.Select("*", "user_selected_option_values", " User_ID="+EmployeesSalaries.get(i)+" User_Option_ID="+ID_SALARY);
               while(result.next())
               {
                   Total_Salary +=Integer.getInteger(result.getString("Value"));
               }
           }
       }
       catch(Exception E)
       {
           System.out.println("Error in Show Salaries");
       }
       DB.Close();
       return Total_Salary;
   }
   //Emad T
    public double Get_quality() {
        DB_controller.Get_DB_controller().Connect();
        double NumberOfRows = 0;
        double Summtion = 0;
        double Persatage = 0;
        try {
            ResultSet result = DB_controller.Get_DB_controller().Select("*", "Feedback", "Branch_ID=" + Id);
            while (result.next()) {
                Summtion = Summtion+result.getInt("System_quality");
                NumberOfRows++;
            }
        } catch (Exception e) {
            System.out.println("Error in GET Quality");
        }
        Persatage = (Summtion / (NumberOfRows*100))*100;
        DB_controller.Get_DB_controller().Close();
        return Persatage;
    }
    //Emad T
   public double Service_guality()
   {
        DB_controller.Get_DB_controller().Connect();
        int NumberOfRows = 0;
        int Summtion = 0;
        double Persatage = 0;
        DB_controller DB=DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result=DB.Select("System_quality", "feedback","1");
        try
        {
            while(result.next())
            {
                Summtion = Summtion+result.getInt("Service_quality");
                NumberOfRows++;                
            }
        }
        catch(Exception E)
        {
            System.out.println("Error in Service Quality");
        }
        Persatage = (Summtion / (NumberOfRows*100))*100;
        DB.Close();
        return Persatage;
   }
   
   //Sala7
   public ArrayList <Bill_inf> Show_accounting()
   {   
       ArrayList <Bill_inf> b = new ArrayList <>();
       Bill bill = new Bill();
       System_manage syst = System_manage.Get_System_manage();
       Bill_inf bi_inf = new Bill_inf();
       Payment_Method pay = new Payment_Method();
       DB_controller DB = DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result;
       int bill_id = -1;
    
       result = DB.Select(" * ", " bill ", " 1 ");
       
       try {
            while (result.next())
            {
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
             b.add(bi_inf);
            }
            return b;
        } catch (SQLException ex) {
                ex.printStackTrace();
                DB.Close();
                return null;
        }
   }
   
   
   //Emad T
   public ArrayList<Employee> Show_employee()
   {
       System_manage S=System_manage.Get_System_manage();
       Service_Management Ser=Service_Management.Get_Serive_Management();
       ArrayList <Employee> E=new ArrayList<Employee>();
    DB_controller DB=DB_controller.Get_DB_controller();
    DB.Connect();
    int Gender_ID;
    ResultSet result=DB.Select("*","user","Type_ID=1 Or Type_ID=2 Or Type_ID=3 Or Type_ID=4");
       
    int USer_ID=-1;
        try 
        {
            while(result.next())
            {  
                Employee Em=new Employee();
                USer_ID=result.getInt("User_ID");
                Em.setID(USer_ID);
                Em.setAdditional_data(S.Get_Option_Values_OF_USER("user_selected_option_values","User_id="+USer_ID));
                Gender_ID=result.getInt("Gender");
                Em.setF_name(result.getString("Fname"));
                Em.SetMyBranchID(getId());
                Em.setL_name(result.getString("Lname"));
                Em.setEmail(result.getString("Email"));
                Em.setPassword(result.getString("Password"));
                Em.setType_id(result.getInt("Type_ID"));
                // Em.setBlock(result.getInt("Block"));
                Em.setPhones(Ser.Get_User_Phone(USer_ID));
                Em.setAddresses(Ser.Get_User_Address(USer_ID));
                Em.setGander(Gender_ID);
                E.add(Em);
            }
         return E;
        }
        catch(Exception Er)
        {
            System.out.println("Error in Show Employee");
            Er.printStackTrace();
        }
        return null;
   }
   

   public void SetNotfy_message(String notfy) {
        this.notfy_message = notfy;
        notify();
   }

   public String GetNotfy_message() {
       return "";
   }
   
   //omar 0_0
   public void Subcribe( int user_id)
   {
        DB_controller Db = DB_controller.Get_DB_controller();
        Db.Connect();
        HashMap<String, String> A = new HashMap<>();
        A.put("User_id", Integer.toString(user_id));
        A.put("Branch_id", Integer.toString(getId()));
        try{
           Db.Insert("Subscriber", A);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }        
   }
   //Emad
   public void Desubcribe( int user_id)
   {
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       DB.Delete("subscribe","User_id="+user_id);
   }
   
   //Emad
   public void Load_Subscribe()
   {
       this.Subscriber=new ArrayList<Integer>();
       DB_controller DB=DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result=DB.Select("*","subscribe","1");
        try 
        {
            while(result.next())
            {
                this.Subscriber.add(result.getInt("Subscribe_id"));
            }
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   //Emad
   public void Notify()
   {
       int DateId;
      Notify N=new Notify();       
       String Time="";
      DB_controller DB=DB_controller.Get_DB_controller();
      System_manage S=System_manage.Get_System_manage();
      HashMap <String,String> H=new HashMap<String,String>();
      H.put("Sender_ID",Integer.toString(Id));
      Time=S.Get_time();
      H.put("Time",Time);
      DateId=S.Get_date_iD();
      H.put("Date_id",Integer.toString(DateId));
      H.put("Content",this.GetNotfy_message());
      H.put("Type_id","4");
      H.put("Parent_id","0");
      DB.Insert("message", H);
      N.setBranch_id(this.Id);
      N.setContent(this.notfy_message);
      N.setDate_id(DateId);
      N.setMassage_type_id(4);
      N.setState(5);
      N.setTime(Time);
      for(int i=0;i<this.Subscriber.size();i++)
      {
          Object C=S.Search_user_by_id(this.Subscriber.get(Id));
          Customer Cus=(Customer) C;
          Cus.Add_notify(N);
      }
   }
   
   //omar 0_0
   public double earning_branch()
   {
        Double earning = 0.0 ;
        try {
            DB_controller Db = DB_controller.Get_DB_controller();
            System_manage sy =System_manage.Get_System_manage();
            Db.Connect();
            ResultSet res = Db.Select( "*", "order_fixable", "State_id=2");
            ResultSet res2 = null;
            ArrayList<Integer> Orders_ids = new ArrayList<>();
            int id = 0;
            boolean flage = false;
            while(res.next()) // get all order that done
            {
                flage= false;
                res2= Db.Select("Device_of_this_request_id", "device_of_this_request", "Request_id="+res.getInt("Requist_id"));
                while(res2.next()) //get all Device_of_this_request_id of this order to get his technical 
                {
                   ResultSet res3 = Db.Select("Technical_id", "order_fixer", "Device_of_this_request_id="+res2.getInt("Device_of_this_request_id"));
                   while(res3.next()) //to get tecnicals that do this 
                   {
                       Employee e =(Employee) sy.Search_user_by_id(res3.getInt("Technical_id"));
                       System.out.println(e.GetMyBranchID());
                       if(e.GetMyBranchID() == this.getId() && !flage)
                       {
                           Orders_ids.add(res.getInt("Order_fixable_id"));
                           flage=true;
                       }
                   }
                }
     
            }
            for(int i : Orders_ids)
            {
                res = Db.Select("Cost", "bill", "Order_id="+i);
                while(res.next())
                {
                    earning += res.getDouble("Cost");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return earning;
   }
   
   
   
   
   //Mohamed RAdwan 
   public boolean Send_Message_to_all_employee(General_massge message)
   {
        try
       {
            System_manage s =System_manage.Get_System_manage();
            DB_controller.Get_DB_controller().Connect();
            HashMap<String,String> Mass=new HashMap<>(10);
            int id=s.Get_date_iD();
            String time=s.Get_time();
            Mass.put("Content",message.getContent());
            Mass.put("sender_id",String.valueOf(message.getSender_id()));
            Mass.put("Type_id", Integer.toString(message.getMassage_type_id()));
            Mass.put("Date_id", String.valueOf(id));
            Mass.put("Time", time);
            Mass.put("Parent_id", "0");
            int idmass= DB_controller.Get_DB_controller().Insert("message",Mass);
            ArrayList<Employee> Employee_ID=Show_employee();// error hena !! we  menf34 close fee kol function
            for(Employee emp:Employee_ID)
            {    
                if(emp.getType_id()!=0||emp.getType_id()!=1)
                {
                    Mass=new  HashMap<String, String>(5);
                    Mass.put("Reciever_id", String.valueOf(emp.getID()));
                    Mass.put("Message_id", String.valueOf(idmass));
                    Mass.put("State_id", "5");
                    DB_controller.Get_DB_controller().Insert("recieved", Mass);
                  emp.Add_massage(message,2);
                }
            }
        }//END Try
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return true;
    
    }//End Send_Message
   
   
   
}
