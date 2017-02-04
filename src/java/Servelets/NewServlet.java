/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.Bill;
import SE.Offer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SE.System_manage;
import SE.Validations;
import SE.Payment_Method;
import SE.Service_Management;
import SE.Spare_parts;
import java.util.HashMap;

/**
 *
 * @author moahmed A.Radwan
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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
            Validations valid=Validations.Get_Validations();
            RequestDispatcher des =null;
            if(!valid.Is_double(request.getParameter("cost")))
            {
                des = request.getRequestDispatcher("Add_bill.jsp");
                 des.forward(request, response);     
                 
            }
            else{
                double CostBill= Double.parseDouble(request.getParameter("cost"));
                System.err.println("COstrsansjb"+CostBill);
                //  int  orderId= Integer.parseInt(request.getParameter("orderId"));
                
                String  [] cost  =request.getParameterValues("costS");
                String [] Names=request.getParameterValues("someName");
                Bill bill=new Bill();
                bill.setDate_id(System_manage.Get_System_manage().Get_date_iD());
                bill.setTime(System_manage.Get_System_manage().Get_time());
                // bill.setMy_order(orderId);
                bill.setCost(CostBill);
                if(request.getParameter("Offer")!=null)
                {
                    int offer= Integer.parseInt(request.getParameter("Offer"));
                    System.err.println("COstrsansjb"+offer);
                    Offer off=new Offer(bill);
                    off.setOffer(offer);
                    
                   String payment=request.getParameter("Paymethod Type");
                   System.err.println("COstrsansjb"+payment);
                     if("cash".equals(payment))
                     {
                         Payment_Method paym=Service_Management.Get_Serive_Management().Add_Payment_Method_toBill(off, null, 1);
                         if(Names.length!=0)
                         {
                             Spare_parts spar=new Spare_parts();
                             HashMap<String,Double> hash=new HashMap<>();
                             for(int i=0;i<Names.length;i++)
                             {
                                 System.err.println(Double.parseDouble(cost[i]));
                                 System.err.println(Names[i]);
                                 hash.put(Names[i], Double.parseDouble(cost[i]));
                             }    
                             spar.setNAmeMony(hash);
                             spar=Service_Management.Get_Serive_Management().Add_SpareParts_toBill(paym, hash);
                             Service_Management.Get_Serive_Management().Save_bill_toDB(spar); 
                         }
                         else
                         {
                             Service_Management.Get_Serive_Management().Save_bill_toDB(paym); 
                         }
                    }
                else{
                         
                     }
           

            }
                else{
                     Payment_Method paym=Service_Management.Get_Serive_Management().Add_Payment_Method_toBill(bill, null, 1);
                         if(Names.length!=0)
                         {
                             Spare_parts spar=new Spare_parts();
                             HashMap<String,Double> hash=new HashMap<>();
                             for(int i=0;i<Names.length;i++)
                             {
                                 hash.put(Names[i], Double.parseDouble(cost[i]));
                             }    
                             spar.setNAmeMony(hash);
                             spar=Service_Management.Get_Serive_Management().Add_SpareParts_toBill(paym, hash);
                             Service_Management.Get_Serive_Management().Save_bill_toDB(spar); 
                         }
                         else
                         {
                             Service_Management.Get_Serive_Management().Save_bill_toDB(paym); 
                         }
                    }
                
                     des = request.getRequestDispatcher("HtmlGenerator?html=28");
                      des.forward(request, response);    
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
