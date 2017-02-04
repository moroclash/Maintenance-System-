<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
    Author     : moroclash
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
                            <h2 id="in" >Add Attribute</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="NewAttribute">
                                    <div  id="proff"> 

                                        <center>  
                                            
                                            <input type="text" id="ser" placeholder="Attribute Name" autofocus required class="top1s" name="Name"></center><br>
                                            <pre>
                                        <select style=" margin-right:20px" name="Att">
                                            <option value="String">text</option>
                                            <option value="Integer">int</option>
                                            <option value="Double">double</option>
                                        </select>
                                            </pre>
                                        <input type="submit" value="Add" id="info1">

                                    </div>
                                    <hr class="in2">  

                                </form>


                            </div>
          <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>