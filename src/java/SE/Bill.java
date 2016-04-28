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
    private int Id;
    private int Date_id;
    private Double Cost;
    private int My_order;
    private String Time;
   
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDate_id(int Date_id) {
        this.Date_id = Date_id;
    }

    public void setCost(Double Cost) {
        this.Cost = Cost;
    }

    public void setMy_order(int My_order) {
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
    public void Get_Cost() {
    
    }

}
