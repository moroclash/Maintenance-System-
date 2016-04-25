/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_access;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public static void Connect ()
    {
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DB_controller = DriverManager.getConnection("jdbc:mysql://localhost:3306/maintenenceWEB?zeroDateTimeBehavior=convertToNull","root", "");
            System.out.println("ConnectionDB Done");
        }
        catch(Exception x)
        {
            System.out.println("Eroro LL2sf fe el Coonection");
        } 
    }
    public static void Close ()
    {
       try {
            DB_controller.close();
            System.out.println("CloseDB Done");
        } catch (SQLException ex) {
            System.out.println("Eror in function close DB");
        }  
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
        String Query = " UPDATE " + TableName + " set " + FieldName + " WHERE " + Condition;
       try {
              PreparedStatement pre = DB_controller.prepareStatement(Query); 
              return true;
        } catch (SQLException ex){
            ex.getStackTrace();
            return false;
        }
    }
    public static boolean Insert(String TableName , HashMap<String,String> values)
    {
        return true;
    }
    
}
