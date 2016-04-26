package SE;

import java.lang.reflect.Array;
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
    private ArrayList<String> Phones;
    private ArrayList<String> Addresses;
    private ArrayList<Massage> Inbox;

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

}
