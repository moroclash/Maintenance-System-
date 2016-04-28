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

    private static Connection DB_controller;

    public static void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DB_controller = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_phase2?zeroDateTimeBehavior=convertToNull", "root", "");
            System.out.println("ConnectionDB Done");
              Class.forName("com.mysql.jdbc.Driver");

            DB_controller = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_phase2?zeroDateTimeBehavior=convertToNull", "root", "");
            System.out.println("Done");
        } catch (Exception x) {
            System.out.println("Eroro LL2sf fe el Coonection");
        }
    }

    public static void Close() {
        try {
            DB_controller.close();
            System.out.println("CloseDB Done");
        } catch (SQLException ex) {
            System.out.println("Eror in function close DB");
        }
    }

    public static ResultSet Select(String FieldName, String TableName, String Condetion) {
        String Query="SELECT" +FieldName+ "FROM"+ TableName+ "WHERE" +Condetion;
        try
        {
            PreparedStatement pre=DB_controller.prepareStatement(Query);
            ResultSet result=pre.executeQuery();
            return result;
        }
        catch(Exception e)
        {
            System.out.println("Error in select");
        }
        return null;
    }

    public static boolean Delete(String TableName, String condition) {
        String Query = "DELETE FROM " + TableName + " WHERE " + condition;
        try {
            PreparedStatement pre = DB_controller.prepareStatement(Query);
            pre.execute();
            return true;
        } catch (SQLException ex) {
            ex.getStackTrace();
            return false;
        }
    }

    public static boolean Update(String TableName, String FieldName, String Condition) {
        String Query = " UPDATE " + TableName + " set " + FieldName + " WHERE " + Condition;
        try {
            PreparedStatement pre = DB_controller.prepareStatement(Query);
            return true;
        } catch (SQLException ex) {
            ex.getStackTrace();
            return false;
        }
    }

    //Emad
    public static int Insert(String TableName, HashMap<String, String> values) {
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
    
    
    public static void main(String[] args) {
        
        try {
            Connect();
            String s = "INSERT INTO address ('Address','Parent_id') VALUES ('dasdasdas','2')";
            //Statement ss = DB_controller.createStatement();
            PreparedStatement ss = DB_controller.prepareStatement(s);
            ss.executeQuery();
//            int x = ss.executeUpdate(s, Statement.RETURN_GENERATED_KEYS);
            //System.out.println(x);
            Close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
