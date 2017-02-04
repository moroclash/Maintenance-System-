/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mohamedsalah
 */
public class Spare_parts extends Component{
    HashMap<String,Double> NAmeMony;

    public Spare_parts() {
       }
    

    public void setNAmeMony(HashMap<String, Double> NAmeMony) {
        this.NAmeMony = NAmeMony;
    }

    public HashMap<String, Double> getNAmeMony() {
        return NAmeMony;
    }
    

    Spare_parts(Bill bill) {
       this.bill= bill;
    }

    @Override
    public double Get_Cost() {
        Double value=0.0;
        for (Map.Entry<String, Double> entrySet : NAmeMony.entrySet()) {
             value += entrySet.getValue();
            
        }
        return this.bill.Get_Cost() +value;//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        String total="";
        for (Map.Entry<String, Double> entrySet : NAmeMony.entrySet()) {
            String key = entrySet.getKey();
            Double value = entrySet.getValue();
        total+=key+"             "+value+"\n";
        }
      return this.bill.toString()+total;   
    }
   
    
  
    
}
