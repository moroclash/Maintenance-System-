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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedsalah
 */
public class Bill_inf {
   private Bill my_bill;
   private Payment_Method payment_Method_id;
   private ArrayList <Spare_parts> Spare_part;
   private int Offer;

   
  
   
    public void setMy_bill(Bill my_bill) {
        this.my_bill = my_bill;
    }

    public void setOffer(int Offer) {
        this.Offer = Offer;
    }

    public void setPayment_Method_id(Payment_Method payment_Method_id) {
        this.payment_Method_id = payment_Method_id;
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

    public Payment_Method getPayment_Method_id() {
        return payment_Method_id;
    }

    public ArrayList <Spare_parts> getSpare_part() {
        return Spare_part;
    }
     
    //sala7
    public ArrayList <Spare_parts> Get_spare_parts(int bill_id)
    {   
       DB_controller DB = DB_controller.Get_DB_controller();
       ArrayList <Spare_parts> spare = null;
       DB.Connect();
       Spare_parts s = new Spare_parts();
       ResultSet result = null;
       
       result = DB.Select(" Spare_parts_id ", " details_bill ", " Bill_id = " + bill_id);
       int spare_id = -1;
       try {
           while(result.next())
           {
             spare_id = result.getInt("Spare_parts_id");
           }
          result = DB.Select(" * ", " spare_parts ", " Spare_parts_id = " + spare_id);
          while(result.next())
          {
             s.setSpare_part_id(Integer.parseInt(result.getString("Name")));
             s.setSpare_part_id(result.getInt("Cost"));
             spare.add(s);
          }
          DB.Close();
          return spare;
       } 
          
       catch (SQLException ex) {
          ex.printStackTrace();
          DB.Close();
          return null;
       }
       
    }
}
