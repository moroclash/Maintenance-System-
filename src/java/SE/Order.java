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
    private int My_requist_id;
    private int Date_start_id;
    private String Tecnical_description;
    private int My_service_id ;
    private ArrayList<Integer> My_Technical_id ;
    private int State;
    private int Date_end_id;
    
    public void setDate_start_id(int Date_start_id) {
        this.Date_start_id = Date_start_id;
    }

    public int getDate_start_id() {
        return Date_start_id;
    }

    
    
    

    public ArrayList<Integer> getMy_Technical_id() {
        return My_Technical_id;
    }

    public void setMy_Technical_id(ArrayList<Integer> My_Technical_id) {
        this.My_Technical_id = My_Technical_id;
    }
    


    public void setDate_end_id(int Date_end_id) {
        this.Date_end_id = Date_end_id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setMy_service_id(int My_service_id) {
        this.My_service_id = My_service_id;
    }

    public void setMy_requist_id(int My_requist_id) {
        this.My_requist_id = My_requist_id;
    }

    public void setState(int State) {
        this.State = State;
    }

    public void setTecnical_description(String Tecnical_description) {
        this.Tecnical_description = Tecnical_description;
    }

   
    public int getDate_end_id() {
        return Date_end_id;
    }

    public int getId() {
        return Id;
    }

    public int getMy_service_id() {
        return My_service_id;
    }

    public int getMy_requist_id() {
        return My_requist_id;
    }

    public int getState() {
        return State;
    }

    public String getTecnical_description() {
        return Tecnical_description;
    }
    
    
}
