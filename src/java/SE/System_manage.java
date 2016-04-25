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
    public ArrayList<String> Empty_time(int x,int y)
    {
        return null;
    }
    public ArrayList<Complain> All_complains(String State)
    {
        return null
    }
    public ArrayList<Employee> Show_empty_technicals()
    {
        return null;
    }
    public ArrayList<Order> Show_empty_Order()
    {
        return null;
    }
    public ArrayList<Employee> Show_all_employee(int Branch_id)
    {
        return null;
    }
    public Branch Search_branch (int Branch_id)
    {
        return null;
    }
    public ArrayList<Employee> Show_all_employee(String Employee_type)
    {
        return null;
    }
    public Object Log_in (String User_Name,String Password)
    {
        return null;
    }
    public ArrayList <Requist> Show_my_requist()
    {
        return null;
    }
    public boolean Delete_requist(int Requist_id)
    {
       return true; 
    }
    public Requist Search_requist(int Requist_id)
    {
        return null;
    }
    public boolean Reply_message(int Message_id,Comment comment)
    {
        return true;
    }
    public boolean Give_order(Order order)
    {
        return true;
    }
     public Bill Search_bill(int Branch_id)
    {
        return null;
    }
    public Feedback Search_feedback(int Order_id)
    {
        return null;
    }
    public Device Search_device(int Device_id)
    {
        return null;
    }
    public boolean Up_complain_to_manager(Complain complain)
    {
        return true;
    }
    public Order Search_order(int Order_id)
    {
        return null;
    }
    public boolean Send_Message(General_message message,int Sender_id,int Reciver_id)
    {
        return true;
    }
    public boolean Add_User(User user)
    {
        return true;
    }
    public User Search_user_by_id(int User_id)
    {
        return null;
    }
    public User Search_user_by_name(String Name)
    {
        return null;
    }
    public boolean Update_user(int User_id)
    {
        return true;
    }
    public boolean Delete_user(int User_id)
    {
        return true;
    }
    public int Branch_quality(int Branch_id)
    {
        return 1;
    }
    public boolean Block_user(int User_id)
    {
        return true;
    }
    public boolean Unblock_user(int User_id)
    {
        return true;
    }
    public boolean Accept_order(int Order_id)
    {
        return true;
    }
    public boolean Is_fixed(Bill bill)
    {
        return true;
    }
    public boolean Return_order(int Order_id,String Technical_description)
    {
        return true;
    }
    public ArrayList<Order> Show_my_order()
    {
        return null;
    }
}
