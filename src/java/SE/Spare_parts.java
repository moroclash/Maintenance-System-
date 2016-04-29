/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mohamedsalah
 */
public class Spare_parts extends Component{
    private int Spare_part_id;
    private Double mony;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    public void setMony(Double mony) {
        this.mony = mony;
    }

    public void setSpare_part_id(int Spare_part_id) {
        this.Spare_part_id = Spare_part_id;
    }

    public Double getMony() {
        return mony;
    }

    public int getSpare_part_id() {
        return Spare_part_id;
    }

  
    
}
