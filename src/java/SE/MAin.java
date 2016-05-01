/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    public static void main(String[] args) {
           
        User s= new User();
        s.setID(1);
        s.Load_inbox();
        ArrayList<Massage> m = s.getInbox();
        for(Massage mm : m)
        {
            System.out.println(mm.getContent());
            System.out.println(mm.getId());
            if(mm.getMassage_type_id() == 1)
            {
                Complain cp = (Complain) mm;
                System.out.println("Recver : " + cp.getReciver());
            }
            else
            {
                General_massge gn = (General_massge) mm;
                System.out.println("Sender : " + gn.getSender_id());
            }
        
        }
            
            
            
            
        }
    }


