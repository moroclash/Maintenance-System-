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
        
        
        Branch b = new Branch();
        b.setId(1);
        
        
        
        
       // System.out.println(b.earning_branch());
System_manage s = System_manage.Get_System_manage();   
        System.err.println(s.Get_Option_Value(3, 19));




Employee e = (Employee) s.Search_user_by_id(3);
        HashMap<Integer , String> a = e.getAdditional_data();
        for (Map.Entry<Integer, String> entry : a.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            
        }
        
            
            
            
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
    
                    
      
       
        }
 }

 


