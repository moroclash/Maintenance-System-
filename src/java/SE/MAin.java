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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    
     

    public static void main(String[] args) {


     
        
        
        
       // System.out.println(b.earning_branch());
System_manage s = System_manage.Get_System_manage();   
        //System.err.println(s.Get_Option_Value(3, 19));




   Branch b = new Branch();
   b.setId(1);
        System.err.println(b.earning_branch());
        
            
            
            
            /*Service_Management s = Service_Management.Get_Serive_Management();
            Request r = s.Search_requist(1);
            System.err.println(r.getUser_id());*/
            //Object o = ma.Search_User_OptionByID(2);
            ///Customer s = (Customer) o;
            
            /*Customer cu = new Customer();
            cu.Log_in("mohasem@gmail.com", "8sa9d1d9");
            System.out.println(cu.getF_name()); 
            ArrayList<String> name = ma.Get_Options_OF_TYPE(cu.getType_id());
            int x =0;
            HashMap<Integer , String> ss = cu.getAdditional_data();
            for (Map.Entry<Integer, String> entry : ss.entrySet()) {
            System.err.println(name.get(x));
            x++;
            System.err.println(entry.getValue());
            }*/
            
            /*System_manage s = System_manage.Get_System_manage();
            s.Delete_branch_phone(3, 3);*/
    
                    
      
       

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

/*Customer C=new Customer();
C.setID(19);
DB_controller DB=DB_controller.Get_DB_controller();
DB.Connect();
                ResultSet result2=DB.Select("*","device_of_this_request","Request_id=1");*/
/*System.out.println(C.forget_My_Password("mohamedelnagm211@gmail.com",1,"football"));
    */
      /*  Bill n=new Bill();
        
        n.setCost(2500.0);
    
        Offer ss =  Service_Management.Get_Serive_Management().Add_offer_toBill(n, 10);
        Spare_parts v= Service_Management.Get_Serive_Management().Add_SpareParts_toBill(ss,"wa7ed amplyha" ,2500);
        Spare_parts c= Service_Management.Get_Serive_Management().Add_SpareParts_toBill(v,"wa7ed amplyha m3 3omer   :" ,200);
         Offer sa=new Offer(n);
        sa.setOffer(10.0);
        Spare_parts v=new Spare_parts(sa);
        v.setMony(2500.0);
        v.setName("Kahasa");
        System.out.println(c+"final Cost           :"+c.Get_Cost());*/
    }
    
//Customer C=new Customer();
//C.setID(19);
///*DB_controller DB=DB_controller.Get_DB_controller();
//DB.Connect();
//                ResultSet result2=DB.Select("*","device_of_this_request","Request_id=1");*/
//System_manage S=System_manage.Get_System_manage();
//S.Get_Option_Values_OF_USER("user_selected_option_values","User_id=1");


 }

 


