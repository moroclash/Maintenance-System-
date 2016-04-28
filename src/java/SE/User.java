package SE;

import Data_access.DB_controller;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author moroclash
 */
public class User {

    private String F_name;
    private String L_name;
    private String Email;
    private String Password;
    private int Type_id;
    private String Gander;
    private HashMap<String, String> Additional_data;
    private ArrayList<String> Phones=new ArrayList<String>();
    private ArrayList<String> Addresses;
    private ArrayList<Massage> Inbox;
    private int Block;

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public String getF_name() {
        return F_name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setGander(String Gander) {
        this.Gander = Gander;
    }

    public String getGander() {
        return Gander;
    }

    public void setL_name(String L_name) {
        this.L_name = L_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setType_id(int Type_id) {
        this.Type_id = Type_id;
    }

    public int getType_id() {
        return Type_id;
    }
    public void setBlock(int Block) {
        this.Block= Block;
    }
    public int getBlock() {
        return this.Block;
    }    
    public void setAddress(String Address) {
        this.Addresses.add(Address);
    }
    public ArrayList<String> getAddresses() {
        return Addresses;
    }

    public void Add_address(String Cuntry, String Area, String Street, String Num_of_home) {

    }

    public boolean Dellet_address(int Address_id) {
        return false;
    }

    public boolean Update_address(int Old_address_id, String Cuntry, String Area, String Street, String Num_of_home) {
        return false;
    }

    public ArrayList<Massage> Show_all_my_massage() {
        return Inbox;
    }

    public ArrayList<Massage> Show_my_massage(int State_id) {
        return new ArrayList<>();
    }

    public void Add_massage(Massage New_massage) {

    }

    public boolean DeleteMassge(int Massage_id) {
        return false;
    }

    public void setPhones(String Phone) {
        this.Phones.add(Phone);
    }

    public ArrayList<String> getPhones() {
        return Phones;
    }

    public void Add_new_phone(String New_phone) {

    }

    public boolean Delete_phone(int phone_id) {
        return false;
    }

    public boolean Update_phone(int Old_phone_id, String New_phone) {
        return false;
    }

    public HashMap<String, String> getAdditional_data() {
        return Additional_data;
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
    public boolean add_new_user(String Name,int Parent_id)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name", Name);
        H.put("parent_id",Integer.toString(Parent_id));
        boolean Check=DB_controller.Insert("type_user", H);
        DB_controller.Close();
        return Check;
    }
    //Emad
    public String Search_Option(int Option_ID)
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
    public boolean add_option (int Type_ID,String Name)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Name",Name);
        H.put("Type_id", Integer.toString(Type_ID));
        boolean check=DB_controller.Insert("user_option", H);
        return check;
    }
    //Emad
    public void Add_User_Option (int user_type_id,int []Options_id)
    {
        DB_controller.Connect();
        for(int i=0;i<Options_id.length;i++)
        {
            HashMap<String,String> H=new HashMap<String,String>();
            H.put("User_Type_ID",Integer.toString(user_type_id));
            H.put("user_option_id",Integer.toString(Options_id[i]));
            DB_controller.Insert("User_Selected_Option", H);
        }
        DB_controller.Close();
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
        return A;
    }
}
