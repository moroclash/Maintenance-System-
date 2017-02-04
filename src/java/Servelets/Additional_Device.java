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
@WebServlet(name = "Additional_Device", urlPatterns = {"/Additional_Device"})
public class Additional_Device extends HttpServlet {

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
            String Model=request.getParameter("Model");
            HttpSession session=request.getSession();
            int Device_ID=(Integer)session.getAttribute("Device_ID");
            System_manage s=System_manage.Get_System_manage();
            ArrayList<Integer> Ids=new ArrayList<Integer>();
            ArrayList<String> name=new ArrayList<String>();            
            Ids=s.Device_Options_ID(Device_ID);
            for(int i=0;i<Ids.size();i++)
            {
             name.add(s.name_device_option(Ids.get(i)));
            }
            System.out.println("name:"+name.get(0));
            ArrayList<String>HTML=new ArrayList<String>();
            HTML=s.Get_All_HTML_Attributes(name);
            System.out.println("aaaaaaaa"+HTML.get(0));
            session.setAttribute("Model", Model);
            session.setAttribute("Additional_Device",HTML);
            session.setAttribute("Additional_Att",name);            
            RequestDispatcher re=request.getRequestDispatcher("DeviceAccess.jsp");
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
