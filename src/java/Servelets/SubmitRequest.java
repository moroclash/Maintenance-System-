/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.System_manage;
import SE.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author emad
 */
@WebServlet(name = "SubmitRequest", urlPatterns = {"/SubmitRequest"})
public class SubmitRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Des=request.getParameter("Des");
            HttpSession se=request.getSession();
            String Model=(String)se.getAttribute("Model");
            ArrayList<String> Add=new ArrayList<String>();
            Add=(ArrayList<String>)se.getAttribute("Additional_Att");
            HashMap<String,String> H=new HashMap<String,String>();
            for(int i=0;i<Add.size();i++)
            {
                H.put(Add.get(i),request.getParameter(Add.get(i)));
            }

            System_manage s=System_manage.Get_System_manage();
            User user= (User) se.getAttribute("User");
            HashMap<Integer,String> Addresses=new HashMap<Integer,String>();
            Addresses=user.getAddresses();
            int Address_ID = 0;
            for(Map.Entry<Integer,String> entry:Addresses.entrySet())
            {
                 Address_ID=entry.getKey();
            }
            int Device_ID;
            int Model_ID=s.Get_ModeL_ID(Model);
            Device_ID=s.Insert_Device(Model_ID);
            int User_ID=user.getID();
            int Date_ID=s.Get_date_iD();
            s.insert_description(Device_ID, Des);
            s.Insert_requist(User_ID,Date_ID, Address_ID);
            for(Map.Entry<String,String> entry:H.entrySet())
            {
                s.Insert_Additional_Info_Dev(Model_ID,s.Get_Option_Device_ID(entry.getKey()),entry.getValue());
            }
            response.sendRedirect("Login.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
