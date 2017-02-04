/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.System_manage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emad
 */
@WebServlet(name = "NewDevice", urlPatterns = {"/NewDevice"})
public class NewDevice extends HttpServlet {

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
            System_manage S=System_manage.Get_System_manage();
            ArrayList<String> Name_OF_Main=new ArrayList<String>();
            ArrayList<String> Main_HTML=new ArrayList<String>();
            ArrayList<String> Device_Attribute=new ArrayList<String>();  
            ArrayList<String> Attributes_HTML=new ArrayList<String>();                      
            Name_OF_Main=S.MainFactor();
            Device_Attribute=S.Get_All_Device_Option();
            Main_HTML=S.Get_All_HTML_Attributes(Name_OF_Main,2);
            Attributes_HTML=S.Get_All_HTML_Attributes(Device_Attribute,4);
            System.out.println(Attributes_HTML.get(0));
            HttpSession se=request.getSession();
            se.setAttribute("MainHTML",Main_HTML);
            se.setAttribute("Attributes_HTML",Attributes_HTML);
                RequestDispatcher re=request.getRequestDispatcher("AddNewDevice.jsp");
                re.forward(request, response);  
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
