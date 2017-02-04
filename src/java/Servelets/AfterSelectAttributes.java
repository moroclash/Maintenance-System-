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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emad
 */
@WebServlet(name = "AfterSelectAttributes", urlPatterns = {"/AfterSelectAttributes"})
public class AfterSelectAttributes extends HttpServlet {

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
            String Button=request.getParameter("Button");
            if(Button.equals("Submit"))
            {
            System_manage S=System_manage.Get_System_manage();
            String Name=request.getParameter("Name");
            String Selected []=request.getParameterValues("Check");
            String Links []=request.getParameterValues("Links");
            int Actor_ID=S.add_new_actor(Name,0);
            System.out.println(Links.length);
            for(int i=0;i<Links.length;i++)
            {
                S.Insert_Type_Links(Actor_ID,S.Get_Link_ID(Links[i]));
            }
            ArrayList<Integer> A=new ArrayList<Integer>();
            for(int i=0;i<Selected.length;i++)
            {
                S.Insert_Into_User_option(Actor_ID,(S.Get_Option__Attribute_ID(Selected[i])));
            }
            
            response.sendRedirect("AllTypes");                
            }
            else
            {
            response.sendRedirect("NewAttribute.jsp");
            }
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
