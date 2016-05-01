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
            User s = new User();
            s.setID(1);
            ArrayList<General_massge> gg = s.Show_my_massage(5);
            for(General_massge g : gg)
            {
                System.out.println(g.getContent() +"   " + g.getSender_id()+"   "+g.getDate_id());
            }
            
        }
    }


