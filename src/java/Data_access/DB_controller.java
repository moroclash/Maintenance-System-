/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Mohamed Salah
 */
public class DB_controller {
    
    private static Connection DB_controller;

    public void setDB_controller(Connection DB_controller) {
        this.DB_controller = DB_controller;
    }

    public Connection getDB_controller() {
        return DB_controller;
    }
    
    public static void Connect ()
    {
        
    }
    public static void Close ()
    {
        
    }
    public static ResultSet Select (String FieldName , String TableName , String Condetion)
    {
      return null;  
    }
    public static boolean Delete (String TableName , String condition)
{
  String  Query="DELETE FROM "+TableName+" WHERE "+condition;  
  try {
              PreparedStatement pre = DB_controller.prepareStatement(Query); 
              
              return true;
        } catch (SQLException ex){
            ex.getStackTrace();
            return false;
        }
}
    public static boolean Update (String TableName , String FieldName , String Condition)
    {
        return true;
    }
    public static boolean Insert(String TableName , HashMap<String,String> values)
    {
        return true;
    }
    
}
