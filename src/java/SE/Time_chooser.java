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

    public void setTime(ArrayList<String> Time) {
        this.Time = Time;
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
