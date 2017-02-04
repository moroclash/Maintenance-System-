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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin{
    
     

    public static void main(String[] args) throws SQLException {
       DB_controller Db =DB_controller.Get_DB_controller();
       Db.Connect();
       System.err.println(Db.Login("mmoroclash@gmail.com", "moro12345"));
      
    }

 }

 


