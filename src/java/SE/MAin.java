/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    
     
    
    public static void main(String[] args) {


          /* String username = "mohamed@yahoo.com";
           String pass = "123456789";
           int order_id = 2;
           int System_quality ;
           Customer customer = new Customer();
           Feedback feedback = new Feedback();
           Bill bill = new Bill();
           Bill_inf bill_inf = new Bill_inf();
           Payment_Method pay = new Payment_Method();
           System_manage s = System_manage.Get_System_manage();
           Service_Management se = Service_Management.Get_Serive_Management();
           Order order = new Order();
           Branch branch = new Branch();
           
          
           //searchbranch
           int num = s.Check_type(username, pass);
           //System.out.println(num);
           
          feedback = s.Search_feedback(order_id);
          
          */
          //System.out.println(feedback.getSystem_quality());
          
//          bill_inf = s.Search_bill(1);
//          System.out.println(bill_inf.getPayment_method_info()); 
         
//System.out.println(bill_inf.getMy_bill().getCost());
         
////        order = se.Search_order(1);
////        System.out.println(order.getMy_Technical_id());
        

//          ArrayList <Integer> t = se.Get_Technical(1);
//          System.out.println("all is"+ t);

      // HashMap <Integer , String > p = pay.Get_payment_type_in_bill(2);
       //System.out.println( p);
      
         
       //s.Search_user_by_id(1);
       
//        ArrayList <Bill_inf> ss = branch.Show_accounting();
//        
//        System.out.println(ss.get(0).getMy_bill().getCost());
//        System.out.println(ss.get(0).getPayment_method_info());
//        System.out.println(ss.get(0).getOffer());
         
//          customer.setID(8);
//          customer.Add_Subscribe(9);
          

         //ArrayList <Employee> ee = s.Show_all_employee(5);
         
         //System.out.println(ee.get(0).getEmail());
        
//        int offer = bill_inf.Get_offer(1);
//        System.out.println("offer is"+offer);


//         ArrayList <Spare_parts> we = s.Get_spare_parts(1);
//         System.out.println(we.get(0).getMony());
//         System.out.println(we.get(0).getName());
         

         
        //branch = s.Search_branch(2);
        //System.out.println(branch.getNotfy_message());
        
        //String content = branch.Get_notify(1);
       // System.out.println(content);
       
//       Employee em = new Employee();
//       
//       if(!em.Log_in("emad@yahoo.com", "medo1232"))
//       {
//           System.out.println("error");
//       }else{
//           System.out.println(em.getF_name());
//       as}
Customer C=new Customer();
/*DB_controller DB=DB_controller.Get_DB_controller();
DB.Connect();
                ResultSet result2=DB.Select("*","device_of_this_request","Request_id=1");*/
System_manage S=System_manage.Get_System_manage();
Service_Management Ser=Service_Management.Get_Serive_Management();
Request request =new Request() ;
request.setAddress_ID(16);
Time_chooser A=new Time_chooser();
A=Ser.Get_Three_Date(request);
System.out.println(A.getTime().size());
        }
 }

 


