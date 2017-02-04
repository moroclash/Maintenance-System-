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
public class Offer extends Component{
    private int  Offer_precentage;
    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
    
    Offer() {
       
    }

    public void setOffer(int  Offer_precentage) {
        this.Offer_precentage = Offer_precentage;
    }


    public int  getOffer() {
        return Offer_precentage;
    }

    public Offer(int Offer_precentage) {
        this.Offer_precentage = Offer_precentage;
    }
    
    public Offer(Bill bill) {
    this.bill=bill;
    
    }

    double calc()
    {
        return  this.bill.Get_Cost()*((double)Offer_precentage/100.0);
    }
    @Override
    public double Get_Cost() {   
    return this.bill.Get_Cost()-calc();
    
    }

    @Override
    public String toString() {
        return this.bill.toString()+"Discount :        "+calc()+"\n";
    }
    
    
}
