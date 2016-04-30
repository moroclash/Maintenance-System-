/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author mohamedsalah
 */
public class Spare_parts extends Component{
    private String  Name;
    private Double mony;
    HashMap<String,Double> s;

    Spare_parts() {

    }
    Spare_parts(Bill bill) {
       this.bill= bill;
    }
    @Override
    public double Get_Cost() {    
    return super.Get_Cost()+mony;
    }
    public void setMony(Double mony) {
        this.mony = mony;
    }

    public void setName(String Spare_part) {
        this.Name= Spare_part;
    }

    public Double getMony() {
        return mony;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return this.bill.toString()+Name+"             "+mony+"\n";
        
    }
    
    
  
    
}
