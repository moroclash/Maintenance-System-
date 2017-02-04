/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mohamedsalah
 */
public class Payment_Method extends Component{
    
    private HashMap <Integer , String > Payment_method_option;
    private int method_id;

    Payment_Method(Bill bill) {

       this.bill=bill;
    }

    Payment_Method() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //sala7
    public HashMap <Integer,String> Get_payment_type_in_bill(int bill_id)
    {
        int Method_ID = -1;
         DB_controller DB = DB_controller.Get_DB_controller();
         ResultSet result = null;
         ResultSet result2 = null;
        HashMap <Integer,String> H=new HashMap<Integer,String> ();
        DB.Connect();
       result=DB.Select("Payment_method_id" ,"bill","BILL_id = " + bill_id );
        try
        {
            while(result.next())
            {
              Method_ID=result.getInt("Payment_method_id") ;
                
            }
            
            result2=DB.Select(" Methode ", " payment_methode " , " Payment_methode_id = " + Method_ID);
               
            while(result2.next())
               {
                String s =result2.getString("Methode");
                H.put(Method_ID, s);
                
               }
        }
        catch(Exception E)
        {
            E.printStackTrace();
            
        }
     
        return H;
    }
   //sala7 
   public void push(int Key,String Value)
   {
    this.Payment_method_option.put(Key, Value);
   }

    public void setMethod_id(int method_id) {
        this.method_id = method_id;
    }

    public int getMethod_id() {
        return method_id;
    }

    public void setPayment_method_option(HashMap<Integer, String> Payment_method_option) {
        this.Payment_method_option = Payment_method_option;
    }

    public HashMap<Integer, String> getPayment_method_option() {
        return Payment_method_option;
    }

    @Override
    public String toString() {
        String s = "";
        if(Payment_method_option!=null)
        {
        for (Map.Entry<Integer, String> entry : Payment_method_option.entrySet()) {
            s =  entry.getKey() +  "     " +  entry.getValue() + "  \n ";
        }
        return bill.toString()+s;
        }
        else{return bill.toString();
            
        }
    }

    

   
   
}
