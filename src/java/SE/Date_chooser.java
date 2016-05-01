/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author Ayman
 */
public class Date_chooser {
    
    private ArrayList<String> Times;
    private String Selected_time;
    private int Request_id;
    
    public void setTimes(ArrayList<String> Times) {
        this.Times = Times;
    }
    
    public ArrayList<String> getTimes() {
        return Times;
    }
    
     public void setSelected_time(String Selected_time) {
        this.Selected_time = Selected_time;
    }

    public String getSelected_time() {
        return Selected_time;
    }
    
     public void setRequest_id(int Request_id) {
        this.Request_id = Request_id;
    }

    public int getRequest_id() {
        return Request_id;
    }
}
