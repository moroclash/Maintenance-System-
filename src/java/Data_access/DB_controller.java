/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_access;

import SE.General_massge;
import SE.Massage;
import SE.System_manage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed Salah
 */
public class DB_controller {

    private Connection DB_controller;
    private static DB_controller Controller = null;
    
    
    private DB_controller()
    {
    }
    
    public static DB_controller Get_DB_controller()
    {
        if(Controller == null)
            Controller = new DB_controller();
        return Controller;
    }

    public void Connect() {
        try {
              if(DB_controller == null || DB_controller.isClosed())
              {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                DB_controller = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_phase2?zeroDateTimeBehavior=convertToNull", "root", "");
                System.out.println("Done");
              }
         } catch (Exception x) {
             System.err.println(x.getMessage());
         }
    }

    public  void Close() {
        try {
            if(!DB_controller.isClosed())
            {
                DB_controller.close();
                System.out.println("CloseDB Done");
            }
        } catch (SQLException ex) {
            System.out.println("Eror in function close DB");
        }
    }

    public  ResultSet Select(String FieldName, String TableName, String Condetion) {
        String Query="SELECT " +FieldName+ " FROM "+ TableName+ " WHERE " +Condetion;
        try
        {
            PreparedStatement pre=DB_controller.prepareStatement(Query);
            ResultSet result=pre.executeQuery();
            return result;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public  boolean Delete(String TableName, String condition) {
        String Query = "DELETE FROM " + TableName + " WHERE " + condition;
        try {
            PreparedStatement pre = DB_controller.prepareStatement(Query);
            pre.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public  boolean Update(String TableName, String FieldName, String Condition) {
        String Query = "UPDATE " + TableName + " set " + FieldName + " WHERE " + Condition;
        try {
            PreparedStatement pre = DB_controller.prepareStatement(Query);
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    //Emad
    public int Insert(String TableName, HashMap<String, String> values) {
        String key = "";
        String value = "";
        ResultSet rs=null;
        for (Map.Entry<String, String> entry : values.entrySet())
        {
            key +=entry.getKey() + ",";
            value +="'"+ entry.getValue()+"'" + ",";
        }
        String Attributes = "";
        String Values = "";
        for (int i = 0; i < key.length() - 1; i++) {
            Attributes += key.charAt(i);
        }
        for (int i = 0; i < value.length() - 1; i++) {
            Values += value.charAt(i);
        }
        Attributes = "(" + Attributes + ")";
        Values = "(" + Values + ")";
        String Query = "INSERT INTO " + TableName + " " + Attributes + " VALUES " + Values + " ";
        try {
            PreparedStatement pre = DB_controller.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
            pre.executeUpdate();
            rs=pre.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);                    
        } catch (SQLException ex)
        {
            System.out.println("Error in Insert Function"+ex);
        }
        return -1;
    }
}
