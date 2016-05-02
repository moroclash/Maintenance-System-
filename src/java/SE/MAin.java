/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    public static void main(String[] args) {
        System_manage s= null;
        Customer c = new Customer();
        HashMap <Integer , String > ph = null;
        HashMap <Integer , String > ad = null;
        HashMap<Integer, String> Additional_data = null;
       // ph.put(1, "01006977751");
        //ad.put(1, "cairo");
       
        int id = 1;
        c.setF_name("salah");
        c.setL_name("mohamed");
        c.setBlock(1);
        c.setEmail("medo@yahoo.com");
        c.setPassword("12345784");
        c.setType_id(5);
        c.setGander("male");
        c.setAddresses(ad);
        c.setPhones(ph);
        //s.add_address_to_customer(c ,id);
        s.Regist_customer(c);
    }
}
