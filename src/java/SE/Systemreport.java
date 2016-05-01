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
    private Employee Best_technical;
    private Employee Best_manager;
    private Employee Best_service;
    
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
    
    public void setBest_technical(Employee Best_technical) {
        this.Best_technical = Best_technical;
    }

    public Employee getBest_technical() {
        return Best_technical;
    }
    
    public void setBest_manager(Employee Best_manager) {
        this.Best_manager = Best_manager;
    }

    public Employee getBest_manager() {
        return Best_manager;
}
    public void setBest_service(Employee Best_service) {
        this.Best_service = Best_service;
    }

    public Employee getBest_service() {
        return Best_service;
    }
}
