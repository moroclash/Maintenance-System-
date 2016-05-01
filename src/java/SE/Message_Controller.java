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
    private static  Message_Controller message_control=null;
    private Message_Controller()
    {    
    }
    
    
    public static Message_Controller Get_Message_Controller()
    {
        if(message_control==null)
            message_control = new Message_Controller();
        return message_control;
    }
    
    
    

      //Emad
    public ArrayList<Complain> Show_complains(int State) {
                   DB_controller DB = DB_controller.Get_DB_controller();

        DB.Connect();
        ResultSet result = DB.Select("*", "Message_type", "Name='Complain'");
        ArrayList<Complain> C = new ArrayList<Complain>();
        int ID = 0;
        try {
            while (result.next()) {
                ID = result.getInt("Message_type_id");
            }
            result = DB.Select("*", "recieved", "Message_id=" + ID + " and State_id=" + State);
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
           System_manage gt = System_manage.Get_System_manage();
           DB_controller DB = DB_controller.Get_DB_controller();
            DB.Connect();
            HashMap<String,String> Mass=new HashMap<>(10);
            int id=gt.Get_date_iD();
            String time=gt.Get_time();
            Mass.put("Content",message.getContent());
            Mass.put("sender_id",String.valueOf(message.getSender_id()));
            Mass.put("Type_id", Integer.toString(message.getMassage_type_id()));
            Mass.put("Date_id", String.valueOf(id));
            Mass.put("Time", time);
            Mass.put("Parent_id", "0");
            int idmass= DB.Insert("message",Mass);
            Mass=new  HashMap<String, String>(5);
            Mass.put("Reciever_id", String.valueOf(message.getReciver()));
            Mass.put("Message_id", String.valueOf(idmass));
            Mass.put("State_id", "5");
            DB.Insert("recieved", Mass);
       }//END Try
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return true;
    
    }//End Send_Message
    
    
    //Emad
    public boolean Up_complain_to_manager(Complain complain, int Branch_ID) {
         DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        ResultSet result = DB.Select("*", "branch", "Branch_id=" + Branch_ID);
        int Manager_id = -1;
        int MessageID = -1;
        try {
            while (result.next()) {
                Manager_id = result.getInt("Manager_ID");
            }
            result = DB.Select("*", "recieved", "Message_ID=" + complain.getId());
            while (result.next()) {
                MessageID = result.getInt("Message_ID");
            }
            HashMap<String, String> H = new HashMap();
            H.put("Reciever_id", Integer.toString(Manager_id));
            H.put("Message_ID", Integer.toString(MessageID));

            DB.Insert("recieved", H);
            DB.Close();
            return true;
        } catch (Exception E) {
            System.out.println("Error in UP Complain To manager");
        }
        return false;
    }
    
    
    //omar 0_0
    public boolean Update_massage_state(int Old_massage_id ,int reciver_id ,int New_state)
    { 
        DB_controller DB = DB_controller.Get_DB_controller();
        DB.Connect();
        boolean b = DB.Update("recieved", "State_id="+New_state , "Message_id ="+Old_massage_id+" and Reciever_id="+reciver_id);
        DB.Close();
        return b;
    }
    
    //omar 0_0
    public Object Search_Massage(int Massage_id)
    {
        try {
            DB_controller DB = DB_controller.Get_DB_controller();
            DB.Connect();
            ResultSet res = DB.Select("*", "message", "Message_id="+Massage_id);
            int type=0;
            while (res.next()) {
                type = res.getInt("Type_id");
                if(type == 1)
                    {
                        Complain c = new Complain();
                        c.setContent(res.getString("Content"));
                        ResultSet res2 = DB.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                        while (res2.next()) {                        
                            c.setDate_id(res2.getInt("Date"));
                        }
                        c.setId(Massage_id);
                        c.setMassage_type_id(type);
                        res2 = DB.Select("*","recieved", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                            c.setReciver(res2.getInt("Reciever_id"));
                            c.setState(res2.getInt("State_id"));
                        }
                        c.setTime(res.getString("Time"));
                        res2 = DB.Select("Order_id","complains_order", "Message_id="+Massage_id);
                        while (res2.next()) {                        
                            c.setMy_order_id(res2.getInt("Order_id"));
                        }
                        c.setMy_Commint(get_massage_commintes(Massage_id));
                        return c;
                    }
                    else
                    {
                        General_massge c = new General_massge();
                        c.setContent(res.getString("Content"));
                        ResultSet res2 = DB.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                        while (res2.next()) {                        
                            c.setDate_id(res2.getInt("Date"));
                        }
                        c.setId(Massage_id);
                        c.setMassage_type_id(type);
                        res2 = DB.Select("*","recieved", "Message_id="+Massage_id);
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
    
     //omar 0_0
    public ArrayList<Comment> get_massage_commintes (int Massage_id)
    {
        try {
                                DB_controller DB = DB_controller.Get_DB_controller();
            ArrayList<Comment> commints = new ArrayList<>();
            DB.Connect();
            ResultSet res = DB.Select("*", "message", "Parent_id="+Massage_id);
            while (res.next()) {
                Comment m = new Comment();
                m.setContent(res.getString("Content"));
                ResultSet res2 = DB.Select("Date","date", "Date_id="+res.getInt("Date_id"));
                   while (res2.next()) {                        
                   m.setDate_id(res2.getInt("Date"));
                   }
                m.setId(res.getInt("Message_id"));
                m.setMassage_type_id(res.getInt("Type_id"));
                m.setSender_id(res.getInt("sender_id"));
                m.setTime(res.getString("Time"));
                commints.add(m);
            }
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