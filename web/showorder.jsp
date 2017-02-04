<%-- 
    Document   : show order
    Created on : May 11, 2016, 7:35:51 AM
    Author     : moahmed A.Radwan
--%>
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
                            <h2 id="in"> Show Order </h2> 
                            <hr class="in2">
                            <div id="prof">
                                <form  method="post" name="FirstForm" action="" >
                                    <div  id="proff"> 
                                        <%
                                                HttpSession sesstion=request.getSession();
                                                String date=(String) session.getAttribute("Date");
                                                String descripe=(String)session.getAttribute("descripe");
                                                int Request=(Integer) session.getAttribute("request");
                                                String service=(String) session.getAttribute("service");
                                                String fDate=(String) session.getAttribute("fDate");
                                        
                                        %>

                                        <label style="font-size: 20px"   class="top">Order ID : </label>  
                                        <label type="text" name="order" class="Input" > </label>
                                        <label style="font-size: 20px"   class="top">See Request :</label>  
                                        <label type="text" name="request" class="Input" ><a href=""><%=Request%></a> </label>
                                         <label style="font-size: 20px"  class="top">Start Date : </label>  
                                        <label type="text" name="date" class="Input" > <%=date%></label>
                                         <label style="font-size: 20px"   class="top">Technical description : </label>  
                                        <textarea rows="5" type="text" name="descripe" class="Input" class="form-control" style="font-family:sans-serif;font-size:1.2em;max-width: 600px;height: 80px"><%=descripe%>
                                        </textarea>
                                        <label style="font-size: 20px"  class="top">service name : </label>  
                                        <label type="text" name="service" class="Input" ><%=service%> </label>
                                        <label style="font-size: 20px"  class="top">finish date : </label>  
                                        <label type="text" name="fdate" class="Input" > <%=fDate%></label>
                                        <br>
                                        <br>
                                        <% 
                                            HttpSession s = request.getSession();
                                            try
                                            {
                                            int f = (Integer) s.getAttribute("flag");
                                            if(f==1)
                                            {
                                        %>
                                        <h3 style="color: green;">Add id Done !<h3>
                                        <%}
                                            else if(f == 2)
                                            {
                                        %>
                                         <h3 style="color: red;">Employee Exist!<h3>
                                        <%
                                            }
                                          }
                                          catch(Exception x)
                                          {
                                            
                                          }
                                         %>
                                            
                                
                                    </div>
                                    <hr class="in3">  
                                     		
                                        <input id="info" style="margin-right: 50px;" type="reset" value=" Back ">	  
                                </form>


                            </div>
                        <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>