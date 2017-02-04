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
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("Additional_Device");
            System.out.println(HTMLD.get(0));
            %>
 
                            <h2 id="in" >Available Models and Devices</h2> 
                            <hr class="in2">


                            <div id="prof">
                                
                                <div >
                                <form action="SubmitRequest" method="post">
                                    <h2>Description :</h2> 
                                        <textarea name="Des" cols="5" rows="3" style=" margin-right: -10px; width: 686px; height: 100px;"></textarea>
                                </div>
                                            <pre>

                                        <%
                                            for(int i=0;i<HTMLD.size();i++)
                                            {
                                                %>
                                                <%=HTMLD.get(i)%>
</pre>
                                                <%
                                            }
                                          %>

<input  type="submit" value="submit" id="info1" name="">    
                                  
                                </form>


                            </div>
             <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>    