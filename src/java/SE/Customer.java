/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Mohamed Salah
 */
public class Customer extends User{
    private int Sequrity_question_id;
    private String Sequrity_question_answer;
    
    //omar
    public void Set_sequrity_question (int Sequrity_question_id)
    {
       this.Sequrity_question_id = Sequrity_question_id;
    }
    
    //omar
    public int Get_sequrity_question_id()
    {
        return this.Sequrity_question_id;
    }
    
    //omar
    public void Set_sequrity_question_answer (String Sequrity_question_answer)
    {
       this.Sequrity_question_answer = Sequrity_question_answer;
    }
      
    //omar
    public String Get_sequrity_question_answer ()
    {
        return this.Sequrity_question_answer;
    }
    
    //Emad
    public boolean Make_request (Device Device,int User_ID)
    {
      DB_controller.Connect();
      HashMap <String,String> H=new HashMap();
      H.put("User_ID",Integer.toString(User_ID));
      H.put("Device_ID",Integer.toString(Device.getId()));
      H.put("State_ID","1");      
      int check=DB_controller.Insert("Request", H);
      DB_controller.Close();
      if(check==-1)
          return false;
      return true;
    }
    
    
    public boolean Select_time (Time_chooser My_chooser)
    {
        
        return true;
    }
    
    //Emad
    public String Trace_my_device (int Device_id)
    {
        int State_ID=-100;
        String State=null;
       DB_controller.Connect();
       ResultSet result=DB_controller.Select("*", "DEVICE","DEVICE_ID="+Device_id);
       try
       {
           while(result.next())
           {
               State_ID=result.getInt("State_id");
           }
        result=DB_controller.Select("*", "STATE","STATE_ID="+State_ID);
        while(result.next())
        {
            State=result.getString("State");
        }
        return State;        
       }
       catch(Exception E)
       {
           System.out.println("Error in Trace_My_Device");
       }
       return null;
    }
    
    //Emad
    public boolean Make_complain (Complain complain , int Order_id)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Message_ID",Integer.toString(complain.Id));
        H.put("Order_ID",Integer.toString(Order_id));
        int check=DB_controller.Insert("Complain’s_order", H);
        DB_controller.Close();
        if(check==-1)
            return false;
        return true;
    }
    
    //Emad
    public boolean Make_feedback (Feedback feedback , int Order_id)
    {
        DB_controller.Connect();
        HashMap<String,String> H=new HashMap<String,String>();
        H.put("Order_id",Integer.toString(Order_id));
        H.put("Feedback_id",Integer.toString(feedback.getId()));
        H.put("System_quality",Integer.toString(feedback.getSystem_quality()));
        H.put("Service_quality",Integer.toString(feedback.getService_quality()));
        int check=DB_controller.Insert("FEEDBACK", H);
        DB_controller.Close();
        if(check==-1)
            return false;
        return true;
    }
    
}
