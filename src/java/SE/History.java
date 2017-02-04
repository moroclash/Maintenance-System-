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
    private String Link_id;
    private int Date_id;
    private String Time;
    private int User_id;
    private HashMap<Integer , String> additional_info ;

  

    public void setAdditional_info(HashMap<Integer, String> additional_info) {
        this.additional_info = additional_info;
    }


    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public void setLink_id(String Link_id) {
        this.Link_id = Link_id;
    }

    public String getLink_id() {
        return Link_id;
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
