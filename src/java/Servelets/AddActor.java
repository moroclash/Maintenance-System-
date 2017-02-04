/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.Customer;
import SE.Employee;
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

/**
 *
 * @author emad
 */
@WebServlet(name = "AddActor", urlPatterns = {"/AddActor"})
public class AddActor extends HttpServlet {

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
            String Questions=request.getParameter("Questions");
            String FName=request.getParameter("FNAME");
            String Email=request.getParameter("Email");
            String LName=request.getParameter("LNAME");
            String Password=request.getParameter("Pass");
            String Gender=request.getParameter("gender");
            String dept=request.getParameter("depart");
            String country=request.getParameter("country");
            String state=request.getParameter("state");
            String area=request.getParameter("area");
            
            System.out.println(country);
            System.out.println(state);
            System.out.println(area);
            
            System_manage S=System_manage.Get_System_manage();
            
            int Address_ID;
            HttpSession session=request.getSession();
            ArrayList<String>Names=new ArrayList<String>();
            HashMap<String,String>Addotional=new HashMap<String,String>();
            HashMap<Integer,String> Add=new HashMap<Integer,String>();
            Names=(ArrayList<String>)session.getAttribute("Names");
            for(int i=0;i<Names.size();i++)
            {
                Add.put(S.Get_Option_ID(Names.get(i)),request.getParameter(Names.get(i)));
            }
            Add.put(S.Get_Question_ID(Questions),Questions);
            int Type_ID;
            int Sex_ID=2;
            User U=null;
            if(Gender.equals("Male"))
            {
                Sex_ID=1;
            }
            String Type=(String)session.getAttribute("Type");
            if(Type.equals("Customer"))
            {
                U=new Customer();
                Type_ID=5;
            }
            else
            {
                U=new Employee();
                Type_ID=S.Type_Actor(Type);
            }
            HashMap<Integer,String> Addresses=new HashMap<Integer,String>();
            U.setAddresses(Addresses);
            U.setF_name(FName);
            U.setL_name(LName);
            U.setEmail(Email);
            U.setPassword(Password);
            U.setBlock(0);
            U.setType_id(Type_ID);
            U.setGander(Sex_ID);
            U.setAdditional_data(Add);
            for(Map.Entry<Integer,String> entry:Add.entrySet())
            {
                System.out.println("Key:"+entry.getKey());
                System.out.println("Value:"+entry.getValue());
            }
            int i=S.Add_User(U);
            
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
