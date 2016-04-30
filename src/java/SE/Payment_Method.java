/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;

/**
 *
 * @author mohamedsalah
 */
public class Payment_Method extends Component{
    
    private HashMap <String , String > Payment_method_option;
    private int method_id;
    
   public void push(String Key,String Value)
   {
    this.Payment_method_option.put(Key, Value);
   }

    public void setMethod_id(int method_id) {
        this.method_id = method_id;
    }

    public int getMethod_id() {
        return method_id;
    }

    public void setPayment_method_option(HashMap<String, String> Payment_method_option) {
        this.Payment_method_option = Payment_method_option;
    }

    public HashMap<String, String> getPayment_method_option() {
        return Payment_method_option;
    }
   
}
