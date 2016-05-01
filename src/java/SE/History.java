/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;

/**
 *
 * @author moroclash
 */
class History {
    private int Account_id;
    private int Date_id;
    private String Time;
    private int User_id;
    private HashMap<Integer , String> additional_info ;

    public void setAccount_id(int Account_id) {
        this.Account_id = Account_id;
    }

    public void setAdditional_info(HashMap<Integer, String> additional_info) {
        this.additional_info = additional_info;
    }

    public void setDate_id(int Date_id) {
        this.Date_id = Date_id;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public int getAccount_id() {
        return Account_id;
    }

    public HashMap<Integer, String> getAdditional_info() {
        return additional_info;
    }

    public int getDate_id() {
        return Date_id;
    }

    public String getTime() {
        return Time;
    }

    public int getUser_id() {
        return User_id;
    }
    
    
}
