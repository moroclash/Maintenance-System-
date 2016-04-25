
package SE;

import java.util.ArrayList;

public class Branch {
    private int Id;
    private String Location;
    private ArrayList<String> phones;

    public int getId() {
        return Id;
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
