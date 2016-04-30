/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moahmed A.Radwan
 */
public class Message_Controller {
    public  Message_Controller message_control=null;
    public static boolean is_object=false;
    private Message_Controller()
    {
        
    }
    
    public void MAke_object_from_Message_controller(){
        if(is_object==false)
            message_control=new Message_Controller();
    }
    

      //Emad
    public ArrayList<Complain> Show_complains(int State) {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "Message_type", "Name='Complain'");
        ArrayList<Complain> C = new ArrayList<Complain>();
        int ID = 0;
        try {
            while (result.next()) {
                ID = result.getInt("Message_type_id");
            }
            result = DB_controller.Select("*", "recieved", "Message_id=" + ID + " and State_id=" + State);
            while (result.next()) {
                
                Complain complain = new Complain();
                complain.setId(ID);
                complain.setReciver(result.getInt("Reciever_id"));
                complain.setState(State);
                C.add(complain);
            }
            return C;
        } catch (Exception E) {
            System.out.println("Error in Complains");
        }
        return null;
    }
     //Mohamed RAdwan    
    public boolean Send_Message(General_massge message) {
       
        try
       {
            DB_controller.Connect();
            HashMap<String,String> Mass=new HashMap<>(10);
            int id=System_manage.Get_date_iD();
            String time=System_manage.Get_time();
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
    
    
    //Emad
    public boolean Up_complain_to_manager(Complain complain, int Branch_ID) {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "branch", "Branch_id=" + Branch_ID);
        int Manager_id = -1;
        int MessageID = -1;
        try {
            while (result.next()) {
                Manager_id = result.getInt("Manager_ID");
            }
            result = DB_controller.Select("*", "recieved", "Message_ID=" + complain.getId());
            while (result.next()) {
                MessageID = result.getInt("Message_ID");
            }
            HashMap<String, String> H = new HashMap();
            H.put("Reciever_id", Integer.toString(Manager_id));
            H.put("Message_ID", Integer.toString(MessageID));

            DB_controller.Insert("recieved", H);
            DB_controller.Close();
            return true;
        } catch (Exception E) {
            System.out.println("Error in UP Complain To manager");
        }
        return false;
    }
    
    
    //omar
    public boolean Update_massage_state(int Old_massage_id ,int reciver_id ,int New_state)
    {
        Data_access.DB_controller.Connect();
        boolean b = Data_access.DB_controller.Update("recieved", "State_id="+New_state , "Message_id ="+Old_massage_id+" and Reciever_id="+reciver_id);
        Data_access.DB_controller.Close();
        return b;
    }
    //omar
    public Object Search_Massage(int Massage_id)
    {
        try {
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("*", "message", "Message_id="+Massage_id);
            int type=0;
            while (res.next()) {
                type = res.getInt("Type_id");
                if(type == 1)
                    {
                        Complain c = new Complain();
                        c.setContent(res.getString("Content"));
                        ResultSet res2 = Data_access.DB_controller.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                        while (res2.next()) {                        
                            c.setDate(res2.getString("Date"));
                        }
                        c.setId(Massage_id);
                        c.setMassage_type(type);
                        res2 = Data_access.DB_controller.Select("*","recieved", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                            c.setReciver(res2.getInt("Reciever_id"));
                            c.setState(res2.getInt("State_id"));
                        }
                        c.setTime(res.getString("Time"));
                        res2 = Data_access.DB_controller.Select("Order_id","complains_order", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                            c.setOrder_id(res2.getInt("Order_id"));
                        }
                        c.setMy_Commint(get_massage_commintes(Massage_id));
                        Data_access.DB_controller.Close();
                        return c;
                    }
                    else
                    {
                        General_massge c = new General_massge();
                        c.setContent(res.getString("Content"));
                        ResultSet res2 = Data_access.DB_controller.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                        while (res2.next()) {                        
                            c.setDate(res2.getString("Date"));
                        }
                        c.setId(Massage_id);
                        c.setMassage_type(type);
                        res2 = Data_access.DB_controller.Select("*","recieved", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                            c.setReciver(res2.getInt("Reciever_id"));
                            c.setState(res2.getInt("State_id"));
                        }
                        c.setTime(res.getString("Time"));
                        c.setSender_id(res.getInt("sender_id"));
                        c.setMy_Commint(get_massage_commintes(Massage_id));
                        return c;
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     //omar
    public ArrayList<Comment> get_massage_commintes (int Massage_id)
    {
        try {
            ArrayList<Comment> commints = new ArrayList<>();
            Data_access.DB_controller.Connect();
            ResultSet res = Data_access.DB_controller.Select("*", "message", "Parent_id="+Massage_id);
            while (res.next()) {
                Comment m = new Comment();
                m.setContent(res.getString("Content"));
                ResultSet res2 = Data_access.DB_controller.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                   while (res2.next()) {                        
                   m.setDate(res2.getString("Date"));
                   }
                m.setId(res.getInt("Message_id"));
                m.setMassage_type(res.getInt("Type_id"));
                m.setSender_id(res.getInt("sender_id"));
                m.setTime(res.getString("Time"));
                commints.add(m);
            }
            Data_access.DB_controller.Close();
            return commints;
        } catch (SQLException ex) {
            Logger.getLogger(System_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean Send_Email(int User_ID){
    return false;
    }
    
         public boolean Reply_message(int Message_id, Comment comment) {
        return true;
    }
    
}
