/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mohamedsalah
 */
public class Payment_Method extends Component{
    
    private HashMap <String , String > Payment_method_option;
    private int method_id;
    
    //sala7
    public HashMap <String,String> Get_payment_type_in_bill(int bill_id)
    {
        int Method_ID = -1;
         DB_controller DB = DB_controller.Get_DB_controller();

        HashMap <String,String> H=new HashMap<String,String> ();
        DB.Connect();
        ResultSet result=DB.Select(" Payment_method_id " ," bill "," BILL_id = "+ bill_id );
        try
        {
            while(result.next())
            {
              Method_ID=result.getInt("Payment_method_id") ; 
            }
            
            result=DB.Select("Methode", "Payment_methode " , "Payment_methode_id = " + Method_ID);
               
            while(result.next())
               {
                 H.put(result.getString("Payment_methode_id"),result.getString("Methode"));
                 
               }
        }
        catch(Exception E)
        {
            E.printStackTrace();
            DB.Close();
        }
        DB.Close();
        return H;
    }
   //sala7 
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
