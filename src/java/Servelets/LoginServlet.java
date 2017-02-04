/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Data_access.DB_controller;
import SE.Customer;
import SE.Employee;
import SE.HtmlGner;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            String Email=request.getParameter("Email");
            String Password=request.getParameter("Password");
            DB_controller Db =DB_controller.Get_DB_controller();
            Db.Connect();
            int flage = Db.Login(Email, Password);
            if(flage==-1)
            {
                response.sendRedirect("Login.jsp");
            }
            System.out.println(Email);
            System.out.println(Password);
            boolean Check;   
            SE.System_manage sys = System_manage.Get_System_manage();
            int i = sys.Check_type(Email, Password);
            RequestDispatcher des =null;
            if(i==0)
            {
                des = request.getRequestDispatcher("Login.jsp");
                des.forward(request, response);
            }
            System.err.println("sad");
            HttpSession session=request.getSession();
            String listhtml = "";
            SE.HtmlGner gen = HtmlGner.Get_HtmGner();
            if(i == 1)
            {     
                Customer C=new Customer();
                System.err.println("yes");
                if(C.Log_in(Email, Password)==true)
                {
                    if(sys.Check_Block(Email)==true)
                    {
                        session.setAttribute("Alert1","Blocked");
                        RequestDispatcher y=request.getRequestDispatcher("Alert.jsp");
                        y.forward(request, response);                    
                    }
                    session.setAttribute("User", C);
                    listhtml= gen.DrawListHtml(C);
                }
                else
                {
                    des = request.getRequestDispatcher("Login.jsp");
                    des.forward(request, response);
                }
            }
            else
            {
                Employee E=new Employee(); 
                
                if(E.Log_in(Email, Password)==true)
                {
                    if(sys.Check_Block(Email)==true)
                    {
                        session.setAttribute("Alert1","Blocked");
                        RequestDispatcher y=request.getRequestDispatcher("Alert.jsp");
                        y.forward(request, response);                    
                    }
                    session.setAttribute("User", E);
                    listhtml= gen.DrawListHtml(E);
                }
                 else
                 {
                    des = request.getRequestDispatcher("Login.jsp");
                    des.forward(request, response);
                }
            }
             String nav= gen.Get_filed_Html(13);
             String notitionList= gen.Get_filed_Html(15);
             String footer = gen.Get_filed_Html(18);
             String head = gen.Get_filed_Html(23);
             String afterlist = gen.Get_filed_Html(24);
             session.setAttribute("listhtml", listhtml);
             session.setAttribute("footer", footer);
             session.setAttribute("nav", nav);
             session.setAttribute("head", head);
             session.setAttribute("afterlist", afterlist);
             session.setAttribute("NotificationList", notitionList);
             des = request.getRequestDispatcher("Show_my_profile.jsp");
             des.forward(request, response);               
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
