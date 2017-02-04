/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.System_manage;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "NewDevice2", urlPatterns = {"/NewDevice2"})
public class NewDevice2 extends HttpServlet {

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
            String Button=request.getParameter("SUBMIT");
            HttpSession se=request.getSession();
            System_manage S=System_manage.Get_System_manage();
            if(Button.equals("Submit"))
            {
                String Device_Type=request.getParameter("Device_Type");
                String Factor=request.getParameter("Factor"); //company have device
                String Att[]=request.getParameterValues("Links");                
                int Type_ID=S.Insert_New_Device_Type(Device_Type);
                int Factor_ID=S.Search_Factor(Factor);
                S.Insert_Into_Company_Device(Factor_ID, Type_ID);
                for(int i=0;i<Att.length;i++)
                {
                    S.select_device_option(Type_ID,S.Get_ID_OF_Device_Option(Att[i]));
                }
                RequestDispatcher y=request.getRequestDispatcher("NewDevice");
                y.forward(request, response);   
            }
            else if(Button.equals("NewAttribute"))
            {
                String new_Att=request.getParameter("New_Att");
                S.Insert_New_Att_Device(new_Att);
                RequestDispatcher y=request.getRequestDispatcher("NewDevice");
                y.forward(request, response);                   
            }
            else
            {
                String Company=request.getParameter("New_Att");
                S.Insert_new_Factor(Company);
                RequestDispatcher y=request.getRequestDispatcher("NewDevice");
                y.forward(request, response);                 
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
