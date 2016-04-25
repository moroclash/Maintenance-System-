/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author moroclash
 */
public class Complain extends Massage{
    
    private Order Order_id ;

    public void setOrder_id(Order Order_id) {
        this.Order_id = Order_id;
    }

    public Order getOrder_id() {
        return Order_id;
    }
    
}
