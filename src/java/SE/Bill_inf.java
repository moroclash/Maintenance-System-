/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author mohamedsalah
 */
public class Bill_inf {
   private Bill my_bill;
   private String Payment_method_name; 
   private String BILL_St;

    public void setBILL_St(String BILL_St) {
        this.BILL_St = BILL_St;
    }

    public String getBILL_St() {
        return BILL_St;
    }
   
    public void setPayment_method_info(String Payment_method_name) {
        this.Payment_method_name = Payment_method_name;
    }

    public String getPayment_method_info() {
        return Payment_method_name;
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

    
    public Bill getMy_bill() {
        return my_bill;
    }
}
