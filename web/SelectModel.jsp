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
            HttpSession se=request.getSession();
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("HTMLDevice");
            
            %>
  
                            <h2 id="in" >Available Models and Devices</h2> 
                            <hr class="in2">


                            <div id="prof">
                                
                                
                                <form action="AfterSelectionModel">
                                                                        
                                    <pre>
                                  Device  <select style="width:200px;" name="Device"> 
                                        <%
                                            for(int i=0;i<HTMLD.size();i++)
                                            {
                                                %>
                                                <%=HTMLD.get(i)%>
                                                <%
                                            }
                                          %>
                                    </select> 
                           </pre>                                   

                                            <input style =" margin-left: -1px" type="submit" value="SELECT" id="info1" name="SELECT">    
                                  
                                </form>


                            </div>
                                          <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html> 