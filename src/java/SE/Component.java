/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author mohamedsalah
 */
class Component extends Bill {
    
    protected Bill bill;
    @Override
    public double Get_Cost() {
          return bill.Get_Cost();
    }
    public void SEt_Bill(Bill bil)
    {
       this.bill=bil;
    }
    
   
    
    

    
}
