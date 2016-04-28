/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.ArrayList;

/**
 *
 * @author moroclash
 */
public class Order {
    private int Id;
    private int My_requist;
    private int Date;

    public void setDate(int Date) {
        this.Date = Date;
    }

    public int getDate() {
        return Date;
    }

    
    
    private String Tecnical_description;
    private int My_Service ;
    private ArrayList<Integer> My_Technical_id ;
    private int State;
    private int Date_requist;

    public ArrayList<Integer> getMy_Technical_id() {
        return My_Technical_id;
    }

    public void setMy_Technical_id(ArrayList<Integer> My_Technical_id) {
        this.My_Technical_id = My_Technical_id;
    }
    


    public void setDate_requist(int Date_requist) {
        this.Date_requist = Date_requist;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setMy_Service(int My_Service) {
        this.My_Service = My_Service;
    }

    public void setMy_requist(int My_requist) {
        this.My_requist = My_requist;
    }

    public void setState(int State) {
        this.State = State;
    }

    public void setTecnical_description(String Tecnical_description) {
        this.Tecnical_description = Tecnical_description;
    }

   
    public int getDate_requist() {
        return Date_requist;
    }

    public int getId() {
        return Id;
    }

    public int getMy_Service() {
        return My_Service;
    }

    public int getMy_requist() {
        return My_requist;
    }

    public int getState() {
        return State;
    }

    public String getTecnical_description() {
        return Tecnical_description;
    }
    
    
}
