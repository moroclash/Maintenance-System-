/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;

/**
 *
 * @author Mohamed Salah
 */
public class Bill implements Decoration{
    private static int Id;
    private static int Date_id;
    private static Double Cost;
    private static int My_order;
    private static String Time;
    private static int payment_method_id;
    private static int Techincal_id;

    public  void setTechincal_id(int Techincal_id) {
        Bill.Techincal_id = Techincal_id;
    }

    public  int getTechincal_id() {
        return Techincal_id;
    }

    
    public void setPayment_method_id(int payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public int getPayment_method_id() {
        return payment_method_id;
    }
    
   
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDate_id(int Date_id) {
        this.Date_id = Date_id;
    }

    public void setCost(Double Cost) {
        this.Cost = Cost;
    }

    public  void  setMy_order(int My_order) {
        this.My_order = My_order;
    }

    public void setTime(String Time) {
         this.Time = Time;
    }

    public int getId() {
        return Id;
    }

    public int getDate_id() {
        return Date_id;
    }

    public Double getCost() {
        return Cost;
    }

   
    public String getTime() {
        return Time;
    }

    public int getMy_order() {
        return My_order;
    }


    @Override
    public double Get_Cost() {
    
        return Cost;
    }
 public String toString() {
     
      return "HEllo bill  :)  \n Date       :" +System_manage.Get_System_manage().Get_this_date(Date_id)+"\n Team    :"+Time+"\n OrederID : "+My_order+"\n Cost:      "+Cost+"\n";
    }
}
