/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author Mohamed Salah
 */
class Request {
    private int ID;
    private int Date_id;
    private int State_id;
    private Device My_device;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setState_id(int State_id) {
        this.State_id = State_id;
    }

    public void setMy_device(Device My_device) {
        this.My_device = My_device;
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

    public Device getMy_device() {
        return My_device;
    }
    
    
}
