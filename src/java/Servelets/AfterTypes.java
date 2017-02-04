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
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "AfterTypes", urlPatterns = {"/AfterTypes"})
public class AfterTypes extends HttpServlet {

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
            HttpSession session =request.getSession();            
            String Button=request.getParameter("SELECT");
            System_manage s=System_manage.Get_System_manage();            
            if(Button.equals("SELECT"))
            {
            String Type=request.getParameter("Type");
            ArrayList<String>CountryHTML=new ArrayList<String>();
            ArrayList<String>Mo7fzaHTML=new ArrayList<String>(); 
            ArrayList<String>Mnat2HTML=new ArrayList<String>();                        
            CountryHTML=s.Country(0);
            Mo7fzaHTML=s.Country(1);
            System.out.println("CCCCC"+CountryHTML.size());
            CountryHTML=s.Get_All_HTML_Attributes(CountryHTML,2);
            Mo7fzaHTML=s.Get_All_HTML_Attributes(Mo7fzaHTML,2);  
            Mnat2HTML=s.Distnict();
            Mnat2HTML=s.Get_All_HTML_Attributes(Mnat2HTML,2);
            HashMap<String,String> H=new HashMap<String,String>();
            H=s.Load_HTML_Types(s.Type_Actor(Type));
            ArrayList<String> NamesofAdditional=new ArrayList<String>();
            for(Map.Entry<String,String> entry:H.entrySet())
            {
                NamesofAdditional.add(entry.getKey());
            }
            ArrayList<String> HtmlTypes=new ArrayList<String>();
            HtmlTypes=s.Last_Shape_Of_HTML_Attributes_Types(H);
            int flag=0;
            for(int i=0;i<HtmlTypes.size();i++)
            {
                    System.out.println(""+HtmlTypes.get(i));
                
                if(HtmlTypes.get(i).equals("<label style=\"font-size: 10px\" for=\"Sequrity_Question_id\" class=\"tops\"></label>Sequrity_Question_id:  <input name='Sequrity_Question_id' type=\"text\" id=\"Firstname\"  class=\"Inputs\"></input>"))
                {
                    flag=1;
                    HtmlTypes.remove(i);
                }
            }
            if(flag==1)
            {
                ArrayList<String> S=new ArrayList<String>();
                S=s.Get_Questions();
                S=s.Get_All_HTML_Attributes(S, 2);
                System.out.println(S.get(0));
                session.setAttribute("Questions", S);
            }
            session.setAttribute("Mnat2HTML",Mnat2HTML); 
            session.setAttribute("Mo7fzaHTML",Mo7fzaHTML);             
            session.setAttribute("CountryHTML",CountryHTML);                        
            session.setAttribute("HtmlTypes",HtmlTypes);
            session.setAttribute("Names",NamesofAdditional);
            session.setAttribute("Type",Type);
            RequestDispatcher re=request.getRequestDispatcher("AddUser.jsp");
            re.forward(request, response);                
            }
            else
            {
                ArrayList<String>S=new ArrayList<String>();
                ArrayList<String> H=new ArrayList<String>();
                H=s.Get_All_Links_Of_Actor();
                ArrayList<String>HTmlLinks=new ArrayList<String>();
                S=s.Get_All_Attributes_OF_ALL_ACTOR();
                ArrayList<String> HTMLAttributes=new ArrayList<String>();
                HTMLAttributes=s.Get_All_HTML_Attributes(S,3);
                HTmlLinks=s.Get_All_HTML_Attributes(H,4);
                session.setAttribute("HTMLLinkesAttribute",HTmlLinks);
                session.setAttribute("HTMLAttributes",HTMLAttributes);
                RequestDispatcher re=request.getRequestDispatcher("SelectUserAttribute.jsp");
                re.forward(request, response);    
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
