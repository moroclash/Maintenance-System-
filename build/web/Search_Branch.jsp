<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
    Author     : moroclash
--%>

<%@page import="SE.Branch"%>
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
            
            Branch Value =(Branch) se.getAttribute("Value");
            
            %>
     
                            <h2 id="in" > Result</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="">
                                    <div  id="proff"> 

                                        <center>   
                                            
                                        <label style="font-size: 20px" for="ID" class="tops"> ID :  </label>  
                                        <input name="ID" value="<%=Value.getId()%>" type="text"  id="ID"  class="Inputs">
                                        </input>
                                                
                                            
                                            <%ArrayList<String> s=Value.getPhones();
                                                
                                            %>
                                            <pre>
                                        <label style="font-size: 20px" for="Manager_id" class="tops">Manager_id :  </label>  
                                        <input value="<%=Value.getManager_id()%>" type="text"  id="Manager_id"  class="Inputs">
                                        </input>
                                            </pre>                                            
                                            <pre>
                                        <label style="font-size: 20px" for="Address_id" class="tops">Address_id :  </label>  
                                        <input value="<%= Value.getAddress_id()%>" type="text"  id="Address_id"  class="Inputs">
                                        
                                            </pre>
                                            <pre>
                                        <label style="font-size: 20px" for="branch_phones" class="tops">branch_phones :  </label>  
                                        <input value="<%=s.get(0)%>" type="text"  id="branch_phones"  class="Inputs">
                                        </input>
                                            </pre>  
                                           
                                        <pre>
                                        <label style="font-size: 20px" for="notify" class="tops">notify :  </label>  
                                        <input value="<%=Value.getNotfy_message()%>" type="text"  id="notify"  class="Inputs">
                                        </input>
                                            </pre> 
                                                                                     

                                            <br>
                                            </div>
                                            <hr class="in2">  
                                            <a> <input id="info"  name="Button" type="submit" value="Back"></a>	
                                            
                                           
                                            </form>


                                    </div>
        <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
              