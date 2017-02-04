/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import SE.Comment;
import SE.Commints;
import SE.Customer;
import SE.Employee;
import SE.General_massge;
import SE.Message_Controller;
import SE.Order;
import SE.Service_Management;
import SE.System_manage;
import SE.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author moroclash
 */
@WebServlet(name = "ShowAll", urlPatterns = {"/ShowAll"})
public class ShowAll extends HttpServlet {

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
            int num = Integer.parseInt(request.getParameter("num"));
            SE.System_manage sys = System_manage.Get_System_manage();
            if(num ==1)  //search Employee
            {
                String chars = request.getParameter("chars");
                ArrayList<User> users = sys.Search_user_by_name(chars);
                JSONObject jsonobj = null;
                JSONArray array = new JSONArray();
                for(User u : users)
                {
                    if(u.getType_id()!=5)
                    {
                        jsonobj = new JSONObject();
                        jsonobj.put("name", u.getF_name()+" "+u.getL_name());
                        jsonobj.put("email", u.getEmail());
                        jsonobj.put("id",u.getID());
                        if(u.getGander() == 1)
                            jsonobj.put("gander","Mall");
                        else
                            jsonobj.put("gander","femal");
                        jsonobj.put("type",sys.User_Types().get(u.getType_id()));
                        jsonobj.put("Block",u.getBlock());
                        array.add(jsonobj);
                    }
                }            
                response.getWriter().write(array.toString());
            }
            else if(num==2) //search Customer
            {
                String chars = request.getParameter("chars");
                ArrayList<User> users = sys.Search_user_by_name(chars);
                JSONObject jsonobj = null;
                JSONArray array = new JSONArray();
                for(User u : users)
                {
                    if(u.getType_id()==5)
                    {
                        jsonobj = new JSONObject();
                        jsonobj.put("name", u.getF_name()+" "+u.getL_name());
                        jsonobj.put("email", u.getEmail());
                        jsonobj.put("id",u.getID());
                        
                        HashMap<Integer,String> aa = u.getAddresses();
                        if(aa.size()!=0)
                        {
                            Map.Entry<Integer,String> oo = aa.entrySet().iterator().next();
                            jsonobj.put("address",oo.getValue());
                        }
                        else
                        {
                            jsonobj.put("address","Nonsdadse");
                        }
                        aa = u.getPhones();
                        if(aa.size()!=0)
                        {
                            Map.Entry<Integer,String> oo = aa.entrySet().iterator().next();
                            jsonobj.put("phone",oo.getValue());
                        }
                        else
                        {
                            jsonobj.put("phone","None");
                        }
                        jsonobj.put("Block",u.getBlock());
                        array.add(jsonobj);
                    }
                }            
                response.getWriter().write(array.toString());
            }
            else if(num==3)
            {
                HttpSession session = request.getSession();
                int chars =(int) session.getAttribute("chars");
                int id =(int) session.getAttribute("id");
                User E = (User) session.getAttribute("User");
                    E.Load_inbox();
                    General_massge g = null;
                    if(E.getInbox().size() != 0)
                    {
                        g = (General_massge) E.getInbox().get(chars);
                        E.Show_this_massage(chars);
                    }
                    else
                    {
                        g = (General_massge) Message_Controller.Get_Message_Controller().Search_Massage(id);
                    }
                    JSONObject json = new JSONObject();
                    json.put("content", g.getContent());
                    User sendeer = (User) sys.Search_user_by_id(g.getSender_id());
                    json.put("sendername", sendeer.getF_name() + " " +sendeer.getL_name());
                    json.put("date", sys.Get_this_date(g.getDate_id()));
                    json.put("time", g.getTime());
                    JSONArray jsarr = new JSONArray();
                    jsarr.add(json);
                    
                    ArrayList<SE.Comment> Commints = g.getMy_Commint();
                    for(SE.Comment c : Commints)
                    {
                        json = new JSONObject();
                        User us = (User) sys.Search_user_by_id(c.getSender_id());
                        json.put("sendername", us.getF_name()+" "+us.getL_name());
                        json.put("date", sys.Get_this_date(c.getDate_id()));
                        json.put("time", c.getTime());
                        json.put("content", c.getContent());
                        jsarr.add(json);
                    } 
                    System.err.println(jsarr.toJSONString());
                    response.getWriter().write(jsarr.toJSONString());
            }
            if(num==4)
            {
                HttpSession s = request.getSession();
                int id = (int) s.getAttribute("id");
                User E = (User) s.getAttribute("User");
                int chars = (int) s.getAttribute("chars");
                E.Load_inbox();
                String content = request.getParameter("content");
                SE.Message_Controller con = Message_Controller.Get_Message_Controller();
                SE.Comment commint = new Comment();
                commint.setContent(content);
                commint.setDate_id(sys.Get_date_iD());
                commint.setMassage_type_id(3);
                commint.setSender_id(E.getID());
                commint.setState(5);
                commint.setTime(sys.Get_time());
                con.Reply_message( id,commint);
                response.sendRedirect("Show_my_profile.jsp");
            }
            if(num == 5)
            {
                int chars = Integer.parseInt(request.getParameter("chars"));
                HttpSession ses = request.getSession();
                User u = (User) ses.getAttribute("User");
                System.err.println("aaaaaaaaaaaaaaaaaaaaaaaa  :" +  u.getEmail() + "   " + u.getID());
                u.Load_inbox();
                ArrayList<SE.General_massge> message = u.Show_my_massage(chars);
                JSONObject jsobj = null;
                JSONArray jsarr = new JSONArray();
                for(General_massge g : message)
                {
                    jsobj = new JSONObject();
                    jsobj.put("id", g.getId());
                    User Sender = (User) sys.Search_user_by_id(g.getSender_id());
                    jsobj.put("sendername", u.getF_name()+" "+u.getL_name());
                    jsobj.put("date", sys.Get_this_date(g.getDate_id()));
                    jsobj.put("time", g.getTime());
                    jsobj.put("numofcommit", g.getMy_Commint().size());
                    jsarr.add(jsobj);
                }
                System.err.println(jsarr.toString());
                response.getWriter().write(jsarr.toJSONString());
            }
            if(num==6)
            {
                int chars = Integer.parseInt(request.getParameter("chars"));
                Service_Management serv = Service_Management.Get_Serive_Management();
                ArrayList<Order> ord = serv.Show_all_order(chars);
                JSONObject jsobj = null;
                JSONArray jsarr = new JSONArray();
                for(Order o : ord)
                {
                    jsobj = new JSONObject();
                    jsobj.put("id", o.getId());
                    jsobj.put("startdate", sys.Get_this_date(o.getDate_start_id()));
                    jsobj.put("enddate", o.getDate_end());
                    jsobj.put("tecnicalid", o.getMy_Technical_id().get(0));
                    jsarr.add(jsobj);
                }
                response.getWriter().write(jsarr.toJSONString());
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
