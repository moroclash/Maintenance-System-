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
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HTML1");
            ArrayList<String> Normal_Values=Normal_Values=(ArrayList<String>) se.getAttribute("Normal_Values");
          
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("Question");

          
%>
            
                            <h2 id="in" > Enter new Address</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="AddnewPhone">
                                    <div  id="proff"> 

                                        <center>   
                                           
                                        <pre>
                                        <label style="font-size: 20px" for="New_phone" class="top" >New_phone :  </label>  
                                        <input type="text" id="New_phone" name="New_phone" placeholder="New_phone" title="New_phone"  required class="Input" pattern="{0,20}">
                                        </pre>
                                        <pre>   
                                        <label style="font-size: 20px" for="user_id" class="top" >user_id :  </label>  
                                        <input type="text" id="user_id" name="user_id" placeholder="user_id" title="user_id"  required class="Input" pattern="{0,10}">
                                        </pre>
                                        
                                            <br>
                                            </div>
                                            <hr class="in2">  
                                            <a> <input id="info"  name="Button" type="submit" value="Add Phone"></a>	
                                            
                                            
                                            </form>


                                    </div>
                          <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
