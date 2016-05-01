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
class Request {
    private int ID;
    private int Date_id;
    private int State_id;
    private int User_id;
    private ArrayList<Integer> Device_id;

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public int getUser_id() {
        return User_id;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setState_id(int State_id) {
        this.State_id = State_id;
    }

    public void setDevice_id(ArrayList<Integer> Device_id) {
        this.Device_id = Device_id;
    }

    public void setDate_id(int Date_id) {
        this.Date_id = Date_id;
    }

    public int getID() {
        return ID;
    }

    public int getState_id() {
        return State_id;
    }

    public int getDate_id() {
        return Date_id;
    }

    public ArrayList<Integer> getDevice_id() {
        return Device_id;
    }
    
    
}
