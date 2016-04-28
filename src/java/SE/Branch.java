
package SE;

import java.util.ArrayList;

public class Branch {
    private int Id;
    private String Location;
    private ArrayList<String> phones;
    private int user_id;

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

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
 
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }
    
    public boolean Add_new_phone (String New_phone)
    {
        return false;
    }
    
    public boolean Delete_phone (int phone_id)
    {
        return false;
    } 
}
