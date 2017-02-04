/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.Customer;
import SE.Employee;
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
@WebServlet(name = "SearchUser", urlPatterns = {"/SearchUser"})
public class SearchUser extends HttpServlet {

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
            String Search_ID=request.getParameter("Search_ID");
            HttpSession session=request.getSession();            
            int id=Integer.parseInt(Search_ID);
            System.out.println(id);
            System_manage S=System_manage.Get_System_manage();
            ArrayList<String>HTML=new ArrayList<String>();
            ArrayList<String>Normal_Values=new ArrayList<String>();
            Object User=S.Search_user_by_id(id);
            String Alert1="";

            Employee E=new Employee();
            Customer C=new Customer();
            int block=-1;
            if(User==null)
            {
                Alert1="User Not Founded Maybe Deleted or Fucked";
                session.setAttribute("Alert1",Alert1);
                RequestDispatcher y=request.getRequestDispatcher("Alert.jsp");
                y.forward(request, response);                
            }
            else if(User instanceof Customer)
            {
                System.out.println("Customer");
                C=(Customer)User;
                HTML=S.Last_Shape_Of_HTML_Attributes(S.Get_HTML_Attributes(C.getAdditional_data()),C.getAdditional_data());
                session.setAttribute("HTML1",HTML);
                Normal_Values.add(Integer.toString(id));                
                Normal_Values.add(C.getF_name());
                Normal_Values.add(C.getL_name());
                Normal_Values.add(C.getEmail());
                Normal_Values.add(Integer.toString(C.getType_id()));
                Normal_Values.add(Integer.toString(C.getGander()));                                
                block=C.getBlock();
            }
            else
            {
                E=(Employee)User;
                HTML=S.Last_Shape_Of_HTML_Attributes(S.Get_HTML_Attributes(E.getAdditional_data()),E.getAdditional_data());
                Normal_Values.add(Integer.toString(id));                                
                Normal_Values.add(E.getF_name());
                Normal_Values.add(E.getL_name());
                Normal_Values.add(E.getEmail());
                Normal_Values.add(Integer.toString(E.getType_id()));                
                Normal_Values.add(Integer.toString(E.getGander()));
                block=E.getBlock();
            }
                if(block==0)
                {
                session.setAttribute("BlockTest","Block");
                }
                else
                {
                    session.setAttribute("BlockTest","Unblock");
                }
                session.setAttribute("Normal_Values",Normal_Values);                
                session.setAttribute("HTML1",HTML);
                RequestDispatcher y=request.getRequestDispatcher("Search2.jsp");
                y.forward(request, response);   
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
