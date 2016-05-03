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
import java.sql.*;
/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    
     
    
    public static void main(String[] args) {

            Service_Management s = Service_Management.Get_Serive_Management();
            ArrayList<Integer> a = new ArrayList<>();
            a.add(1);
            a.add(3);
            System.out.println(s.Employee_order_numper(a, 2));
            
            
                 
        
        }

        
    

    }


