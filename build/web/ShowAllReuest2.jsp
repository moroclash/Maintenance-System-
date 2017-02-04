<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
    Author     : moroclash
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            HttpSession se=request.getSession();
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("Request_Buttons");

%>
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
          
                            <h2 id="in" > All Request</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="RequestDetails">
                     
                                 <select style="width:300px; font-size: 35px" name="State"> 
                                        <%
                                            for(int i=0;i<HTMLD.size();i++)
                                            {
                                                %>
                                                <%=HTMLD.get(i)%>
                                                <%
                                            }
                                          %>
                                    </select>                                      
                                            <input style =" margin-left: -1px ; font-size: 30px ; width:300px" type="submit" value="Show Details" id="info1" name="SELECT">    
                               
                                            
                                            
                                </form>


                            </div>
                        <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
