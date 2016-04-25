/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author emad
 */
public class System_manage {
    private ArrayList<Requist>Request_buffer;
    private ArrayList<Order> Order_buffer;
    private ArrayList<Complain> Comblain_buffer;
    public boolean Regist_customer(Customer customer)
    {
        return true;
    }
    public ArrayList<Requist> Show_requists(String State)
    {
        return null;
    }
    ArrayList<String> Empty_time(int x,int y)
    {
        return null;
    }
    ArrayList<Complain> All_complains(String State)
    {
        return null
    }
    ArrayList<Employee> Show_empty_technicals()
    {
        return null;
    }
    ArrayList<Order> Show_empty_Order()
    {
        return null;
    }
    ArrayList<Employee> Show_all_employee(int Branch_id)
    {
        return null;
    }
    Branch Search_branch (int Branch_id)
    {
        return null;
    }
    ArrayList<Employee> Show_all_employee(String Employee_type)
    {
        return null;
    }
    Object Log_in (String User_Name,String Password)
    {
        return null;
    }
    ArrayList <Requist> Show_my_requist()
    {
        return null;
    }
    boolean Delete_requist(int Requist_id)
    {
        
    }
    Requist Search_requist(int Requist_id)
    {
        return null;
    }
    boolean Reply_message(int Message_id,Comment comment)
    {
        return true;
    }
    boolean Give_order(Order order)
    {
        return true;
    }
    Bill Search_bill(int Branch_id)
    {
        return null;
    }
    Feedback Search_feedback(int Order_id)
    {
        return null;
    }
    Device Search_device(int Device_id)
    {
        return null;
    }
    boolean Up_complain_to_manager(Complain complain)
    {
        return true;
    }
    Order Search_order(int Order_id)
    {
        return null;
    }
    boolean Send_Message(General_message message,int Sender_id,int Reciver_id)
    {
        return true;
    }
    boolean Add_User(User user)
    {
        return true;
    }
    User Search_user_by_id(int User_id)
    {
        return null;
    }
    User Search_user_by_name(String Name)
    {
        return null;
    }
    boolean Update_user(int User_id)
    {
        return true;
    }
    boolean Delete_user(int User_id)
    {
        return true;
    }
    int Branch_quality(int Branch_id)
    {
        return 1;
    }
    boolean Block_user(int User_id)
    {
        return true;
    }
    boolean Unblock_user(int User_id)
    {
        return true;
    }
    boolean Accept_order(int Order_id)
    {
        return true;
    }
    boolean Is_fixed(Bill bill)
    {
        return true;
    }
    boolean Return_order(int Order_id,String Technical_description)
    {
        return true;
    }
    ArrayList<Order> Show_my_order()
    {
        return null;
    }
}
