/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import Data_access.DB_controller;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author moahmed A.Radwan
 */
public class MAin {
    public static void main(String[] args) {

        try {
            Message_Controller me =Message_Controller.Get_Message_Controller();
            me.Send_Email(1, "heloww", "ylaa ylyy bttnaak");
        } catch (MessagingException ex) {
            Logger.getLogger(MAin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MAin.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        }

    }


