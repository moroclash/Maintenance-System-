/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.Branch;
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
 * @author mohamedsalah
 */
@WebServlet(name = "AddBranch", urlPatterns = {"/AddBranch"})
public class AddBranch extends HttpServlet {

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
            
            int User_id =Integer.parseInt(request.getParameter("User_id"));
            int Address_id = Integer.parseInt(request.getParameter("Address_id"));
            String[] Phone =request.getParameterValues("Phone");
            ArrayList<String> phon=new ArrayList<>();
            for (int i = 0; i < Phone.length; i++) {
                phon.add(Phone[i]);
            }
            System_manage S=System_manage.Get_System_manage();
            HttpSession session=request.getSession();
            Branch branch = new Branch();
           
            branch.setMnager_id(User_id);
            branch.setAddress_id(Address_id);
            branch.setPhones(phon);
            String Alert1 = "";
            if(S.Add_new_Branch(branch)==true)
            {
                Alert1 = "Add Branch Succeded";
            }
            session.setAttribute("Alert1",Alert1);
            RequestDispatcher re=request.getRequestDispatcher("Alert.jsp");
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
