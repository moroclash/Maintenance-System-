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
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HTMLAttributes");
            ArrayList<String>Links =(ArrayList<String>) se.getAttribute("HTMLLinkesAttribute");
        %>
  
                            <h2 id="in" >Select User Attributes</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="AfterSelectAttributes">

                                    <pre>
                                        <label style="font-size: 20px" for="FirstName" class="tops">Actor Name</label>  
                                        <input name="Name" type="text"  id="FirstName"  class="Inputs">
                                        </input>

                                    </pre>
                                    <pre>
                                        <label style="font-size: 20px" for="FirstName" class="tops">Select Attributes Available</label>  
                                    </pre>
                                    <% for (int i = 0; i < HTML.size(); i++) {
                                    %>
                                    <%=HTML.get(i)%>
                                    <%
                                        }
                                    %>
                                    
                                    <pre>
                                        <label style="font-size: 20px" for="FirstName" class="tops">Select Rules Available</label>  
                                    <% for (int i = 0; i < Links.size(); i++) {
                                    %>
                                    <%=Links.get(i)%>
                                    <%
                                        }
                                    %>
                                    
                               <a><input id="Delet" name="Button" type="submit" value="Submit"></a>
</pre>
                                                                     <pre>
                               <a><input id="Delet" name="Button" type="submit" value="New Attribute"></a>
</pre>

                                </form>


                            </div>
                    <%=notificationList%>               
            <%=footer%> 
    </body>
</html>