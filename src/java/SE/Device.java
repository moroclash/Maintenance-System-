/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;

/**
 *
 * @author Mohamed Salah
 */
class Device {
    private int Id;
    private int state;
    private HashMap <String , String > My_info;

    
    public void push(String key,String Value)
    {
        
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setMy_info(HashMap<String, String> My_info) {
        this.My_info = My_info;
    }

    public int getId() {
        return Id;
    }

    public int getState() {
        return state;
    }

    public HashMap<String, String> getMy_info() {
        return My_info;
    }
    
    
    
}
