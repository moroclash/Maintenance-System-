<%-- 
    Document   : AddEmployee
    Created on : Mar 28, 2016, 7:49:45 PM
    Author     : moroclash
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <html>
            <%
               HttpSession ss = request.getSession();
               String list = (String) ss.getAttribute("listhtml");
               String nav = (String) ss.getAttribute("nav");
               String notificationList = (String) ss.getAttribute("NotificationList");
               String footer = (String) ss.getAttribute("footer");
               String head = (String) ss.getAttribute("head");
               String afterlist = (String) ss.getAttribute("afterlist");
            %>
    <head>
           <%=head%>
    </head>
    <body>
            <%=nav%>
            <%=list%>           
            <%=afterlist%>
            <!--your Html  *_* -->
        <%
            HttpSession se = request.getSession();
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HtmlTypes");
        %>
       
                            <h2 id="in"> Add Branch </h2> 
                            <hr class="in2">
                            <div id="prof">
                                <form  action="AddBranch" method="post" name="FirstForm" >
                                    <div  id="proff"> 
                                       
                                        <pre>
                                        <label style="font-size: 20px" for="User_id" class="top" >User_id :  </label>  
                                        <input type="text" id="Lastname" name="User_id" placeholder="User_id" title="User_id"  required class="Input" pattern="{1,10}">
                                        </pre>
                                        <pre>
                                        <label style="font-size: 20px"class="top" for="Address_id" >Address_id : </label>  
                                        <input type="text" id="Email" name="Address_id"placeholder="Address_id"  required class="Input" pattern="{1,10}"  title="Address_id">
                                        </pre>      
                                       
                                        <pre>
                                        <label style="font-size: 20px" for="Phone" class="top">Phone : </label>  
                                        <input  name="Phone" required type="text" pattern="{0,20}"id="pass" placeholder="Phone" class="Input"  title="
                                                Phone">
                                       </pre>
                                    </div>
                                    <hr class="in3">  
                                    <div>
                                        <input id="info" style="margin-right: -40px;" type="submit" value=" ADD&nbsp; ">		
                                        <input id="info" style="margin-right: 20px;" type="reset" value=" Reset ">	  
                                        </div>
                                </form>

                                <form action="newphone.jsp">
                                    <input id="info" style="margin-right: 40px;" type="submit" value=" New Phone ">
                                    
                                </form>
                                <form action="newaddress.jsp">
                               <input id="info" style="margin-right: 60px;" type="submit" value=" New Address ">
                                </form>
                            </div>
                      <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
