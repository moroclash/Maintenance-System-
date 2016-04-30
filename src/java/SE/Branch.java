
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Branch {
    private int Id;
    private String Location;
    private ArrayList<String> phones;
    private ArrayList <Integer> Subscriber;
    private String notfy_message;

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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }
    
   public double Show_salaris()
   {
       return 0.0;
   }
   //Emad
    public double Get_quality() {
        DB_controller.Connect();
        int NumberOfRows = 0;
        int Summtion = 0;
        double Persatage = 0;
        try {
            ResultSet result = DB_controller.Select("*", "Feedback", "Branch_ID=" + Id);
            while (result.next()) {
                Summtion = Summtion+result.getInt("Service_quality");
                NumberOfRows++;
            }
        } catch (Exception e) {
            System.out.println("Error in Branch Quality");
        }
        Persatage = (Summtion / (NumberOfRows*100))*100;
        DB_controller.Close();
        return Persatage;
    }
   public int Service_guality()
   {
       return 0;
   }
   public ArrayList <Bill> Show_accounting()
   {
       return null;
   }
   public ArrayList <Employee> Show_employee()
   {
    return null;   
   }

    public void SetNotfy_message(Notify notfy) {
        
    }

    public String GetNotfy_message() {
        return "";
    }
   public void Subcribe( int user_id)
   {
       
   }
   public void Desubcribe( int user_id)
   {
       
   }
   public void Notify()
   {
       
   }
   //Mohamed RAdwan 
   public boolean Send_Message_to_all_employee(General_massge message)
   {
        try
       {
           System_manage s = new System_manage();
            DB_controller.Connect();
            HashMap<String,String> Mass=new HashMap<>(10);
            int id=s.Get_date_iD();
            String time=s.Get_time();
            Mass.put("Content",message.getContent());
            Mass.put("sender_id",String.valueOf(message.getSender_id()));
            Mass.put("Type_id", Integer.toString(message.getMassage_type()));
            Mass.put("Date_id", String.valueOf(id));
            Mass.put("Time", time);
            Mass.put("Parent_id", "0");
            int idmass= DB_controller.Insert("message",Mass);
            Mass=new  HashMap<String, String>(5);
            Mass.put("Reciever_id", String.valueOf(message.getReciver()));
            Mass.put("Message_id", String.valueOf(idmass));
            Mass.put("State_id", "5");
            DB_controller.Insert("recieved", Mass);
       }//END Try
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return true;
    
    }//End Send_Message
   
   
   
}
