/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    
     
    
    public static void main(String[] args) {
        
        Validations v =Validations.Get_Validations();
        System.out.println(v.Is_passord("dasd455asd5"));
    }

    }


