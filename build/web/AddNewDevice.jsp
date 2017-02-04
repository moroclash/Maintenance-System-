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
            ArrayList<String> Main_HTML=(ArrayList<String>) se.getAttribute("MainHTML");
            ArrayList<String> Attributes_HTML=(ArrayList<String>) se.getAttribute("Attributes_HTML");
            %>
        
                            <h2 id="in" >New Device</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="NewDevice2">
                                    <div  id="proff">
                                            
                                            Mainfactor <input type="text" id="ser" placeholder="Enter/Name" autofocus  class="top1s" name="Device_Type"><br>
                                            <select name="Factor" style="width: 150px">
                                  
                                         <%
                                            for(int i=0;i<Main_HTML.size();i++)
                                            {
                                                %>
                                                <%=Main_HTML.get(i)%>
                                                <%
                                            }
                                          %>     
                                     </select><br>
                                        <h3>Select Attributes</h3>
                                        <div > 
                                        <%
                                            for(int i=0;i<Attributes_HTML.size();i++)
                                            {
                                                %>
                                                <%=Attributes_HTML.get(i)%>
                                                <%
                                            }
                                          %>   
                                          </div>
                                      
                                        <center>   

                                    </div>
                                    <hr class="in2">  
         <input type="text" id="ser" placeholder="New Attribute Or Company" autofocus  class="top1s" name="New_Att"></center><br>
                                    
<input  type="submit" value="Submit"  name="SUBMIT">    
<input  type="submit" value="NewAttribute"  name="SUBMIT">    
<input  type="submit" value="NewCompany"  name="SUBMIT">    

                                </form>


                            </div>
                      <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
