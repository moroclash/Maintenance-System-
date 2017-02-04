<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
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
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("DHTML");
            
        %>
      
                            <h2 id="in" > Result</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="Options">
                                    <div  id="proff"> 

                                       
                                            <%
                                                for (int i = 0; i < HTML.size(); i++) {
                                            %>
                                            <pre>
                                                <%=HTML.get(i)%>
                                            </pre>
                                            <%
                                                }
                                            %>
                                            <br>
                                            </div>
                                            <hr class="in2">  
                                            <a> <input id="info"  name="Button" type="submit" value="Accept">	</a>	
                                            <a><input id="Delet" name="Button" type="submit" value="Refuse"></a>
                                            </form>


                                    </div>
                 <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>