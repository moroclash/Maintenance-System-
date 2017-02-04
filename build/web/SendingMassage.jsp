<%-- 
    Document   : SendingMassage
    Created on : Mar 28, 2016, 8:07:16 PM
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
                        <div class="col-lg-9 main-chart">
                            <h2 id="sen"> Sending Message  </h2>
                            <hr class="dd">
                            <form id="tab" action="#" method="post">
                                <br><label id="eee" > ID: <input class="la" type="text" name="id" placeholder="Enter Id"/></label></br></br>
                                <textarea id="laa" class="la" name="complain" cols="25" rows="15" ></textarea></br><br>
                                <input class="se" type="submit" value="sent"/>



                            </form>

                        </div><!-- /col-lg-9 END SECTION MIDDLE -->

<!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>