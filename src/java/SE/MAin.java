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
            
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(2);
        aa.add(3);
        
        System.out.println(Service_Management.Get_Serive_Management().Employee_order_numper(aa, 1));
       
            

        }

    }


