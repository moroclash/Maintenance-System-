package SE;

import Data_access.DB_controller;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moroclash
 */

  

public abstract class User {

    
    private int ID;
    private String F_name;
    private String L_name;
    private String Email;
    private String Password;
    private int Type_id;
    private String Gander;
    private HashMap<Integer, String> Additional_data;
    private HashMap<Integer,String> Phones;
    private HashMap<Integer,String> Addresses;
    private ArrayList <Object> Inbox;
    private int Block;

    public void setAddresses(HashMap<Integer, String> Addresses) {
        this.Addresses = Addresses;
    }

    public ArrayList<Object> getInbox() {
        return Inbox;
    }

    
    
    public void push(int Key,String Value)
   {
    this.Phones.put(Key, Value);
   }


    public void setBlock(int Block) {
    }
   


    public int getBlock() {
        return Block;
    }
   
    
 
    public void setID(int ID) {
        this.ID = ID;
    }
    public HashMap<Integer, String> getAdditional_data() {
        return Additional_data;
    }

    public void setAdditional_data(HashMap<Integer, String> Additional_data) {
        this.Additional_data = Additional_data;
    }

    public int getID() {
        return ID;
    }
    
//omar
    public boolean setEmail(String Email) {
        Validations e = Validations.Get_Validations();
        if(!e.Is_email(Email))
            return false;
        this.Email = Email;
        return true;
    }
    
 public void setPhones(HashMap<Integer, String> Phones) {
        this.Phones = Phones;
    }

    public HashMap<Integer, String> getPhones() {
        return Phones;
    }
    public String getEmail() {
        return Email;
    }
    //omar
    public boolean setGander(String Gander) {
                Validations e = Validations.Get_Validations();

        if(!e.Is_gender(Gander))
            return false;
        this.Gander = Gander;
        return true;
    }

    public String getGander() {
        return Gander;
    }
    //omar
    public boolean setL_name(String L_name) {
                Validations e = Validations.Get_Validations();

        if(!e.Is_alpha(L_name))
            return false;
        this.L_name = L_name;
        return true;
    }

    public String getL_name() {
        return L_name;
    }
    
    //omar
    public boolean setPassword(String Password) {
                Validations e = Validations.Get_Validations();

        if(!e.Is_passord(Password))
            return false;
        this.Password = Password;
        return true;
    }

    public String getPassword() {
        return Password;
    }
    
    //omar
    public void setType_id(int Type_id) {
        this.Type_id = Type_id;
    }

    public int getType_id() {
        return Type_id;
    }


    public HashMap<Integer, String> getAddresses() {
        return Addresses;
    }    
    //omar
    public boolean setF_name(String F_name) {
                Validations e = Validations.Get_Validations();

        if(!e.Is_alpha(F_name))
            return false;
        this.F_name = F_name;
        return true;
    }

    public String getF_name() {
        return F_name;
    }

 
    //omar 0_0
    public ArrayList<General_massge> Show_all_my_rescived_massage() {
        try {
            DB_controller DB = DB_controller.Get_DB_controller();
            ArrayList<General_massge> m = new ArrayList<>();
            DB.Connect();
            ResultSet res = DB.Select("Message_id", "recieved", "Reciever_id="+getID());
            int x=0;
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =  (General_massge)  Ct.Search_Massage(x);  
                m.add(ms);
            }
            DB.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
   
    //omar 0_0
    public Object Show_this_massage(int Massage_id)
    {
        Object ob = getInbox().get(Massage_id);
        if(ob instanceof Massage)
        {
          Massage mm = (Massage) ob;
          getInbox().remove(Massage_id);
          Message_Controller mc = Message_Controller.Get_Message_Controller();
          mc.Update_massage_state(mm.getDate_id(), mm.getReciver(), 4);
          return mm;
        }
        else
        {
            Notify no = (Notify) ob ;
            getInbox().remove(Massage_id);
            return no;
        }
    }
    
    
   
    
    
    //omar 0_0

    // num = 1 if you need to save in DB and inbox
    // num = any numper to add in inbux
    public void Add_massage(General_massge New_massage ,int num) {
        if(num == 1)
        {
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            Ct.Send_Message(New_massage);
        }
       
       
        Inbox.add(New_massage);
    }
    
    

    
    
   
    //omar 0_0
    public void Add_new_phone(String New_phone) {
        Service_Management Sv = Service_Management.Get_Serive_Management();
        int x = Sv.Add_New_Phone_To_User(New_phone, getID());
        this.Phones.put(x, New_phone);
        
    }
    
    //omar 0_0
    public boolean Delete_phone(int phone_id) {
        this.Phones.remove(phone_id);
        Service_Management Sv =Service_Management.Get_Serive_Management();
        return Sv.Delete_User_Phone(phone_id);
    }

    //omar 0_0
    /*public boolean Update_phone(int Old_phone_id, String New_phone) {
        this.Phones.replace(Old_phone_id, New_phone);
        Service_Management Sv = Service_Management.Get_Serive_Management();
        return Sv.Update_User_Phone(Old_phone_id, New_phone);
    }*/



    

    //////////////////////////////////////////////////////
    
   
    //omar 0_0
    public void Load_inbox()
    {
        try {
            Data_access.DB_controller Db = DB_controller.Get_DB_controller();
            Db.Connect();
            ArrayList<Object> m = new ArrayList<>();
            Message_Controller MC = Message_Controller.Get_Message_Controller();
            ResultSet res = Db.Select("Message_id", "recieved", "Reciever_id="+ getID() + " and State_id=5");
            int x = 0;
            while (res.next()) {
                x = res.getInt("Message_id");
                m.add((Massage) MC.Search_Massage(x));
            }
            Db.Close();
            this.Inbox = m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    public abstract boolean Log_in(String User_Name, String Password);
    
    
     //sala7
    /*public Object Log_in(String User_Name, String Password) {
        Validations E = Validations.Get_Validations();
        if(E.Is_email(User_Name) && E.Is_passord(Password))
        {
            DB_controller DB = DB_controller.Get_DB_controller();
            DB.Connect();
            System_manage system = System_manage.Get_System_manage();
            Employee employee ;
            Customer customer ;
            
            ResultSet result = DB.Select(" name ", " type_user ", " Type_user_id = 5 ");
            String name = "";
            try {
                while(result.next())
                {
                    name = result.getString("name");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            result =DB.Select("User_id", " user ", " Email =  '" + User_Name + "'" + " and " + "Password = '" + Password +"'");
            try {
                while(result.next())
                {
                    if(name.equals("customer"))
                    {
                        customer = (Customer) system.Search_user_by_id(result.getInt("User_id"));
                        return customer;
                    }
                    else{
                        employee = (Employee) system.Search_user_by_id(result.getInt("User_id"));
                        return employee;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            System.err.println("ll2saf el username and password is incorrect");
        }
        return null;
    }*/

    
    //omar 0_0
    public boolean DeleteMassge_that_send(int Massage_id) {
            boolean z = false;
        try {
                            DB_controller DB = DB_controller.Get_DB_controller();

            DB.Connect();
            ResultSet res2 = DB.Select("Reciever_id","recieved", "Message_id="+Massage_id);
            int x = 0;
            while (res2.next()) {
               x = res2.getInt("Reciever_id");
            }
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            z =  Ct.Update_massage_state(Massage_id, x, 6);
            DB.Close();
            } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        return z;
    }
   
     //omar 0_0
    public ArrayList<General_massge> Show_my_massage_send() {
        try {
                            DB_controller DB = DB_controller.Get_DB_controller();

            ArrayList<General_massge> m = new ArrayList<>();
            DB.Connect();
            ResultSet res = DB.Select("Message_id", "message", "sender_id="+getID() + " and Type_id = 2");
            int x=0;
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =(General_massge)  Ct.Search_Massage(x);
                m.add(ms);
            }
            DB.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    //omar 0_0
    public boolean Delete_Massge_that_resived(int Massage_id) {
            DB_controller DB = DB_controller.Get_DB_controller();
            DB.Connect();
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            boolean z =  Ct.Update_massage_state(Massage_id, getID(), 7);
            DB.Close();
            return z;
    }
    
    //omar 0_0
    public ArrayList<General_massge> Show_my_massage(int State_id) {
        try {
             DB_controller DB = DB_controller.Get_DB_controller();
             DB.Connect();
            ArrayList<General_massge> m = new ArrayList<>();
            ResultSet res = DB.Select("Message_id", "recieved", "Reciever_id="+getID()+" and State_id="+State_id);
            int x=0;
            Message_Controller Ct = Message_Controller.Get_Message_Controller();
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =(General_massge)Ct.Search_Massage(x);
                m.add(ms);
            }
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
