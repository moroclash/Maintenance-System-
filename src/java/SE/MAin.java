/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    public static void main(String[] args) {
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
       
	       System.err.println(dateFormat.format(date));
    }
}
