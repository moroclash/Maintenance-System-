/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author ME
 */
public class Systemreport extends Report {
    
    private int Customernumber;
    private ArrayList<Branch> Brach_Quality;
    
    public void setCustomernumber(int Customernumber) {
        this.Customernumber = Customernumber;
    }

    public int getCustomernumber() {
        return Customernumber;
    }
    
    public void setBrach_Quality(ArrayList<Branch> Brach_Quality) {
        this.Brach_Quality = Brach_Quality;
    }

    public ArrayList<Branch> getBrach_Quality() {
        return Brach_Quality;
    }

}
