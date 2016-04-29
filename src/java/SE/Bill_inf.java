/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedsalah
 */
public class Bill_inf {
   private Bill my_bill;
   private HashMap <Integer , String > Payment_method_info; 
   private ArrayList <Spare_parts> Spare_part;
   private int Offer;

    public void setPayment_method_info(HashMap<Integer, String> Payment_method_info) {
        this.Payment_method_info = Payment_method_info;
    }

    public HashMap<Integer, String> getPayment_method_info() {
        return Payment_method_info;
    }
   //sala7
   public int Get_offer (int bill_id)
   {
       DB_controller DB = DB_controller.Get_DB_controller();
       DB.Connect();
       ResultSet result = null;
       result = DB.Select("Offer", "offer_bill", "Bill_id = " + bill_id);
      int offer = -1;
       try {
           while(result.next()) 
           {
             offer = result.getInt("Offer");
           }
           return offer;
       } catch (SQLException ex) {
           ex.printStackTrace();
           return 0;
       }
       
   }
  
   
    public void setMy_bill(Bill my_bill) {
        this.my_bill = my_bill;
    }

    public void setOffer(int Offer) {
        this.Offer = Offer;
    }

   

    public void setSpare_part(ArrayList<Spare_parts> Spare_part) {
        this.Spare_part = Spare_part;
    }

    public Bill getMy_bill() {
        return my_bill;
    }

    public int getOffer() {
        return Offer;
    }

 

    public ArrayList <Spare_parts> getSpare_part() {
        return Spare_part;
    }
     
    
}
