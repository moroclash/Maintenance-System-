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
    private double Offer_precentage=40;

    public void setOffer(double Offer_precentage) {
        this.Offer_precentage = Offer_precentage;
    }


    public double getOffer() {
        return Offer_precentage;
    }
    
    
    public Offer(Bill bill) {
    this.bill=bill;
    
    }

    double calc()
    {
        return  super.Get_Cost()*(Offer_precentage/100);
    }
    @Override
    public double Get_Cost() {   
    
    return super.Get_Cost()-calc();
    }

    @Override
    public String toString() {
        return this.bill.toString()+"Discount :        "+calc()+"\n";
    }
    
    
}
