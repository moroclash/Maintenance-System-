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
public class User {
    
    private int ID;
    private String F_name;
    private String L_name;
    private String Email;
    private String Password;
    private int Type_id;
    private String Gander;
<<<<<<< HEAD
    private HashMap<Integer, String> Additional_data=new HashMap<Integer,String>();
    private ArrayList<String> Phones=new ArrayList<String>();
    private ArrayList<String> Addresses;
    private ArrayList<Massage> Inbox;
    private int Block;
=======
    private HashMap<String, String> Additional_data;
    private HashMap<Integer,String> Phones;
    private HashMap<Integer,String> Addresses;
    private boolean Block;
>>>>>>> d51e86ad1738792236d30a513ebd40b2cdf56f8d

    public void setBlock(boolean Block) {
        this.Block = Block;
    }
    
    public boolean getBlock()
    {
        return this.Block;
    }
 
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    //omar
    public boolean setF_name(String F_name) {
        if(!Validations.Is_alpha(F_name))
            return false;
        this.F_name = F_name;
        return true;
    }

    public String getF_name() {
        return F_name;
    }

    
    //omar
    public boolean setEmail(String Email) {
        if(!Validations.Is_email(Email))
            return false;
        this.Email = Email;
        return true;
    }

    public String getEmail() {
        return Email;
    }
    //omar
    public boolean setGander(String Gander) {
        if(!Validations.Is_gender(Gander))
            return false;
        this.Gander = Gander;
        return true;
    }

    public String getGander() {
        return Gander;
    }
    //omar
    public boolean setL_name(String L_name) {
        if(!Validations.Is_alpha(L_name))
            return false;
        this.L_name = L_name;
        return true;
    }

    public String getL_name() {
        return L_name;
    }
    
    //omar
    public boolean setPassword(String Password) {
        if(!Validations.Is_passord(Password))
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
    public ArrayList<General_massge> Show_all_my_rescived_massage() {
        try {
            ArrayList<General_massge> m = new ArrayList<>();
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("Message_id", "recieved", "Reciever_id="+getID());
            int x=0;
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =(General_massge) new System_manage().Search_Massage(x);
                m.add(ms);
            }
            Data_access.DB_controller.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    //omar
    public ArrayList<General_massge> Show_my_massage_send() {
        try {
            ArrayList<General_massge> m = new ArrayList<>();
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("Message_id", "message", "sender_id="+getID());
            int x=0;
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =(General_massge) new System_manage().Search_Massage(x);
                m.add(ms);
            }
            Data_access.DB_controller.Close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //omar
    public ArrayList<General_massge> Show_my_massage(int State_id) {
        try {
            ArrayList<General_massge> m = new ArrayList<>();
            ResultSet res = Data_access.DB_controller.Select("Message_id", "recieved", "Reciever_id="+getID()+",State_id="+State_id);
            int x=0;
            while(res.next())
            {
                x = res.getInt("Message_id");
                General_massge ms =(General_massge) new System_manage().Search_Massage(x);
                m.add(ms);
            }
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    //omar
    public void Add_massage(General_massge New_massage) {
        new System_manage().Send_Message(New_massage);
    }
    
    

    //omar
    public boolean DeleteMassge_that_send(int Massage_id) {
            boolean z = false;
        try {
            Data_access.DB_controller.Connect();
            ResultSet res2 = Data_access.DB_controller.Select("Reciever_id","recieved", "Message_id="+Massage_id);
            int x = 0;
            while (res2.next()) {
               x = res2.getInt("Reciever_id");
            }
            z = new System_manage().Update_massage_state(Massage_id, x, 6);
            Data_access.DB_controller.Close();
            } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        return z;
    }
    
    //omar
    public boolean Delete_Massge_that_resived(int Massage_id) {
            Data_access.DB_controller.Connect();
            boolean z = new System_manage().Update_massage_state(Massage_id, getID(), 7);
            Data_access.DB_controller.Close();
            return z;
    }

    public void setPhones(HashMap<Integer, String> Phones) {
        this.Phones = Phones;
    }

    public HashMap<Integer, String> getPhones() {
        return Phones;
    }

<<<<<<< HEAD
    public void Add_new_phone(String New_phone) {

    }

    public boolean Delete_phone(int phone_id) {
        return false;
    }

    public boolean Update_phone(int Old_phone_id, String New_phone) {
        return false;
    }

    public HashMap<Integer, String> getAdditional_data() {
=======
    
    //////////////////////////////
    
    public HashMap<String, String> getAdditional_data() {
>>>>>>> d51e86ad1738792236d30a513ebd40b2cdf56f8d
        return Additional_data;
    }
    public void setAdditional_data(HashMap  <Integer, String>Additional_data) {
        this.Additional_data= Additional_data;
    }    

    public boolean Add_new_additional_info(String Key, String Value) {
        return false;
    }

    public boolean Delete_additional_info(String Key) {
        return false;
    }

    public boolean Update_additional_info(String Old_key, String New_key, String New_value) {
        return false;
    }
    
    
    
 
    
    

    //Emad
    //pre Path the name of new user and the parent id 
    //post add to table type user
    public int add_new_user(String Name,int Parent_id)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name", Name);
        H.put("parent_id",Integer.toString(Parent_id));
        return DB_controller.Insert("type_user", H);
    }
    
    //Emad
    public String Search_OptionByID(int Option_ID)
    {
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user_option","User_Option_ID="+Option_ID);
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
    public int Search_OptionByName(String Option_Name)
    {
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user_option","Name='"+Option_Name+"'");
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
    public int add_option (int Type_ID,String Name)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name",Name);
        H.put("Type_id", Integer.toString(Type_ID));
        return DB_controller.Insert("user_option", H);
    }
    //Emad
    public int Add_User_Option (int user_type_id,int Option_ID)
    {
        DB_controller.Connect();
            HashMap<String,String> H=new HashMap<String,String>();
            H.put("User_Type_ID",Integer.toString(user_type_id));
            H.put("user_option_id",Integer.toString(Option_ID));
            int i=DB_controller.Insert("User_Selected_Option", H);
        DB_controller.Close();
        return i;
    }
    //Emad
    public ArrayList<Integer> All_Options_Available(int Type_ID)
    {
        DB_controller.Connect();
        ArrayList<Integer> A=new ArrayList<Integer>();
        ResultSet result=DB_controller.Select("*", "user_selected_option","user_type_id="+Type_ID);
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
        DB_controller.Close();
        return A;
    }
    //Emad
    public void Insert_Option_Values(User U,int User_ID)
    {
        DB_controller.Connect();
        for(Map.Entry<Integer,String> entry:U.getAdditional_data().entrySet())
        {
            HashMap<String,String> H=new HashMap<String,String> ();
            H.put("User_ID",Integer.toString(User_ID));
            H.put("User_option_id",Integer.toString(entry.getKey()));
            H.put("value",entry.getValue());
            DB_controller.Insert("user_selected_option_values",H);
        }
        DB_controller.Close();
    } 
    //Emad
    public HashMap <Integer,String> Get_Option_Values_OF_USER(int  User_id)
    {
        HashMap <Integer,String> H=new HashMap<Integer,String> ();
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user_selected_option_values","User_ID="+id);
        try
        {
<<<<<<< HEAD
            while(result.next())
            {
                H.put((result.getInt("User_option_id")),result.getString("Value"));
            }
=======
        HashMap <String,String> H=new HashMap<String,String>();
            H.put("User_ID",Integer.toString(U.getID()));
            H.put("User_option_id", Integer.toString(IDs_Of_Options.get(i)));
            H.put("value",entry.getValue());
            DB_controller.Insert("user_selected_option_values", H);
            i++;
>>>>>>> d51e86ad1738792236d30a513ebd40b2cdf56f8d
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
        DB_controller.Connect();
        ResultSet result=DB_controller.Select("*","user_option","Type_ID="+Type_ID);
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
}
