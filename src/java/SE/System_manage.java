/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author emad
 */
public class System_manage {

    private ArrayList<Request> Request_buffer;
    private ArrayList<Order> Order_buffer=new ArrayList<Order>();
    private ArrayList<Complain> Comblain_buffer;

    public boolean Regist_customer(Customer customer) {
        return true;
    }

    //Emad
    public ArrayList<Request> Show_requists(int State) {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "request", "State_id=" + State);
        ArrayList<Request> R = new ArrayList<Request>();
        try {
            while (result.next()) {
                Request re = new Request();
                re.setID(result.getInt("Request_id"));
                re.setState_id(result.getInt("State_id"));
                re.setDate_id(result.getInt("Date_id"));
                R.add(re);
            }
            return R;
        } catch (Exception E) {
            System.out.println("Error");
        }
        return null;
    }

    public ArrayList<String> Empty_time(int x, int y) {
        return null;
    }

    //Emad
    public ArrayList<Complain> All_complains(int State) {
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
                complain.Id = ID;
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

    public ArrayList<Employee> Show_empty_technicals() {
        return null;
    }

    public ArrayList<Order> Show_empty_Order() {
        return null;
    }

    public ArrayList<Employee> Show_all_employee(int Branch_id) {
        return null;
    }

    public Branch Search_branch(int Branch_id) {
        return null;
    }

    public ArrayList<Employee> Show_all_employee(String Employee_type) {
        return null;
    }

    public Object Log_in(String User_Name, String Password) {
        return null;
    }

    public ArrayList<Request> Show_my_requist() {
        return null;
    }

    public boolean Delete_requist(int Requist_id) {
        return true;
    }

    public Request Search_requist(int Requist_id) {
        return null;
    }

    public boolean Reply_message(int Message_id, Comment comment) {
        return true;
    }

    public boolean Give_order(Order order) {
        return true;
    }

    public Bill Search_bill(int Branch_id) {
        return null;
    }

    public Feedback Search_feedback(int Order_id) {
        return null;
    }
//Emad

    public Device Search_device(int Device_id) {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "Device", "Device_ID=" + Device_id);
        int Model = -1;
        int companyID = -1;
        int Type_id = -1;
        Device D = new Device();
        try {
            while (result.next()) {
                D.setId(result.getInt("Device_id"));
                D.setState(result.getInt("state_id"));
                Model = result.getInt("Model_id");
            }
            result = DB_controller.Select("*", "model", "Model_id=" + Model);
            while (result.next()) {
                D.push("Model", result.getString("Name"));
                companyID = result.getInt("Comp_device_id");
            }
            result = DB_controller.Select("*", "main_factor", "Main_factor_id=" + companyID);
            while (result.next()) {
                D.push("Copmany", result.getString("Name"));
            }
            result = DB_controller.Select("*", "company_have_device", "Main_factor_id=" + companyID);
            while (result.next()) {
                Type_id = result.getInt("Device_type_id");
            }
            result = DB_controller.Select("*", "Device_type", "Device_Type_id=" + Type_id);
            while (result.next()) {
                D.push("Type", result.getString("name"));
            }
            return D;
        } catch (Exception E) {
            System.out.println("Error in Search_DEVICE");
        }
        return null;
    }

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
            result = DB_controller.Select("*", "recieved", "Message_ID=" + complain.Id);
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

    public Order Search_order(int Order_id) {
        return null;
    }

    public int getDateID() {
        DB_controller.Connect();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        HashMap<String, String> Date = new HashMap<>(1);
        Date.put("Date", date.toString());
        DB_controller.Insert("date", Date);
        ResultSet isDate = DB_controller.Select("Date_id", "date", "Date=" + date.toString());
        try {
            return isDate.getInt("Date_id");

        } catch (Exception s) {
            s.printStackTrace();
            return -1;
        }
    }

    public boolean Send_Message(General_massge message) {
        DB_controller.Connect();
        HashMap<String, String> Mass = new HashMap<>(1);

        Mass.put("Content", message.getContent());
        Mass.put("sender_id", String.valueOf(message.getSender_id()));
        Mass.put("Type_id", message.getMassage_type());
        DB_controller.Insert(null, Mass);
        DB_controller.Insert("message", Mass);
        DB_controller.Select(null, null, null);

        return true;
    }
    //Emad

    public void Add_User(User user) {
        DB_controller.Connect();
        HashMap<String, String> U = new HashMap<String, String>();
        U.put("Fname", user.getF_name());
        U.put("Lname", user.getL_name());
        U.put("Email", user.getEmail());
        U.put("Password", user.getPassword());
        U.put("Gender", user.getGander());
        U.put("Block", ""+user.getBlock());
        user.Insert_Option_Values(user);
    }

    //Emad
    public User Search_user_by_id(int User_id) {
        DB_controller.Connect();
        String S;
        ResultSet result = DB_controller.Select("*", "user", "User_ID=" + User_id);
        User U = new User();
        try {
            while (result.next()) {
                U.setF_name(result.getString("FNAME"));
                U.setL_name(result.getString("LNAME"));
                U.setEmail(result.getString("Email"));
                U.setGander(result.getString("GENDER"));
                U.setPassword(result.getString("Password"));
            }
            ResultSet result2 = DB_controller.Select("*", "phone", "User_ID=" + User_id);
            while (result2.next()) {
                U.setPhones(result2.getString("Phone"));
            }
            return U;
        } catch (Exception e) {
            System.out.println("Error in Search User By ID"+e);
        }
        return null;
    }

    //Emad
    public User Search_user_by_name(String Name) {
        return null;
    }

    //Sala7
    public boolean Update_user(int User_id) {
        System_manage m = new System_manage();
        DB_controller.Connect();
        if (m.Search_user_by_id(User_id) == null) {
            return false;
        } else {
            Employee emp = new Employee();
            DB_controller.Update(" user ", " Fname =" + emp.getF_name() + " Lname = " + emp.getL_name() + " Password = " + emp.getPassword()
                    + " Email = " + emp.getEmail() + " gender = " + emp.getGander(), " User_id = " + User_id);
            DB_controller.Update("  ", "  ", "  ");
        }
        DB_controller.Close();
        return true;
    }

    //Emad
    public boolean Delete_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Delete("user", "User_ID=" + User_id);
        return check;
    }

    //Emad
    public double Branch_quality(int Branch_id) {
        DB_controller.Connect();
        int NumberOfRows = 0;
        int Summtion = 0;
        double Persatage = 0;
        try {
            ResultSet result = DB_controller.Select("*", "Feedback", "Branch_ID=" + Branch_id);
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

    //Emad
    public boolean Block_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Update("user", "Block=1", "User_ID=" + User_id);
        DB_controller.Close();
        return check;
    }

    //Emad
    public boolean Unblock_user(int User_id) {
        DB_controller.Connect();
        boolean check = DB_controller.Update("user", "Block=0", "User_ID=" + User_id);
        DB_controller.Close();
        return check;
    }
    //Sala7

    public boolean Accept_order(int Order_id) {
        DB_controller.Connect();
        System_manage m = new System_manage();
        if (m.Search_order(Order_id) == null) {
            DB_controller.Close();
            return false;
        } else {
            DB_controller.Update("order_fixable ", " State_id = " + 4, " Order_fixable_id = " + Order_id);
        }
        DB_controller.Close();
        return true;
    }
    //Sala7

    public boolean Is_fixed(Bill bill, String Technical_description, int order_id, int device_id) {
        DB_controller.Connect();
        DB_controller.Update("order_fixable ", " State_id = " + 2 + " Technical_description = " + Technical_description, " Order_fixable_id = " + order_id);
        DB_controller.Update("device ", " State_id = " + 2, " Device_id = " + device_id);

        DB_controller.Close();
        return true;
    }
    //Sala7

    public void Return_order(int Order_id, String Technical_description) {
        DB_controller.Connect();
        DB_controller.Update("order_fixable ", " State_id = " + 3 + " Technical_description = " + Technical_description, " Order_fixable_id = " + Order_id);
        DB_controller.Close();
    }

    //Emad
    public ArrayList<Order> Show_my_order() {
        DB_controller.Connect();
        ResultSet result = DB_controller.Select("*", "order_fixable", "1");
        try {            
            while (result.next()) {
                Order order = new Order();
                order.setId(result.getInt("Order_fixable_id"));
                order.setDate(result.getInt("Date_start_id"));
                order.setDate_requist(result.getInt("recept_date_id"));
                order.setState(result.getInt("state_id"));
                order.setTecnical_description(result.getString("Technical_description"));
                order.setMy_Service(result.getInt("Service_id"));
                order.setMy_requist(result.getInt("Requist_id"));
                this.Order_buffer.add(order);
            }
        } catch (Exception e) {
            System.out.println("Error in Show_ALL_ORDER");
        }
        DB_controller.Close();
        return this.Order_buffer;
    }
}
