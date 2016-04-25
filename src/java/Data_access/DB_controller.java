/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Mohamed Salah
 */
public class DB_controller {
    
    private Connection DB_controller;

    public void setDB_controller(Connection DB_controller) {
        this.DB_controller = DB_controller;
    }

    public Connection getDB_controller() {
        return DB_controller;
    }
    
    public void Connect ()
    {
        
    }
    public void Close ()
    {
        
    }
    public ResultSet Select (String FieldName , String TableName , String Condetion)
    {
      return null;  
    }
    public boolean Delete (String TableName , String Condition)
    {
        return true;
    }
    public boolean Update (String TableName , String FieldName , String Condition)
    {
        return true;
    }
    public boolean Insert(String TableName , HashMap<String,String> values)
    {
        return true;
    }
    
}
