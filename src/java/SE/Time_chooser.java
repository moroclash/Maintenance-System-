/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author Mohamed Salah
 */
class Time_chooser {
   private ArrayList <String> Time;
   private String Selected_time;
   private int Request_ID; 

   
   
    public void add (String S)
    {
        this.Time.add(S);
    }
    public void setTime(ArrayList<String> Time) {
        this.Time = Time;
    }

    public void setRequest_ID(int Request_ID) {
        this.Request_ID = Request_ID;
    }

    public int getRequest_ID() {
        return Request_ID;
    }
    
    public void setSelected_time(String Selected_time) {
        this.Selected_time = Selected_time;
    }

    public ArrayList<String> getTime() {
        return Time;
    }

    public String getSelected_time() {
        return Selected_time;
    }
    
    
}
