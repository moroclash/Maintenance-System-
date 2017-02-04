
 <%@page import="java.util.ArrayList"%>
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
            String BlockTest=(String) se.getAttribute("BlockTest");
            String Sex="Male";
            if(Integer.parseInt(Normal_Values.get(5))==2)
            {
                Sex="Female";
            }
        %>
            
                            <div id="prof">
                                <form action="Options">
                                    <div  id="proff"> 

                                        <center>   
                                            <pre>
                                        <label style="font-size: 20px" for="UserID" class="tops">User ID :  </label>  
                                        <input name="UserID" value="<%=Normal_Values.get(0)%>" type="text"  id="UserID"  class="Inputs">
                                        </input>
                                            </pre>    
                                            
                                            
                                            <pre>
                                        <label style="font-size: 20px" for="FirstName" class="tops">First Name :  </label>  
                                        <input value="<%=Normal_Values.get(1)%>" type="text"  id="FirstName"  class="Inputs">
                                        </input>
                                            </pre>                                            
                                            <pre>
                                        <label style="font-size: 20px" for="Lastname" class="tops">Last Name :  </label>  
                                        <input value="<%=Normal_Values.get(2)%>" type="text"  id="Lastname"  class="Inputs">
                                        </input>
                                            </pre>
                                            <pre>
                                        <label style="font-size: 20px" for="Email" class="tops">Email :  </label>  
                                        <input value="<%=Normal_Values.get(3)%>" type="text"  id="Email"  class="Inputs">
                                        </input>
                                            </pre>  
                                            <pre>
                                        <label style="font-size: 20px" for="TypeID" class="tops">Type ID :  </label>  
                                        <input value="<%=Normal_Values.get(4)%>" type="text"  id="TypeID"  class="Inputs">
                                        </input>
                                            </pre>  
                                            <pre>
                                        <label style="font-size: 20px" for="Gender" class="tops">Gender :  </label>  
                                        <input value="<%=Sex%>" type="text"  id="Gender"  class="Inputs">
                                        </input>
                                            </pre>                                          

                                            <%
                                                for (int i = 0; i < HTML.size(); i++) {
                                            %>
                                            <pre>
                                                <%=HTML.get(i)%>
                                            </pre>
                                            <%// al goz2 al tane mn al script 3shan ykml al loop lma y5ls
                                                }
                                            %>
                                            <br>
                                            </div>
                                            <hr class="in2">  
                                            <a> <input id="info"  name="Button" type="submit" value="Update">	</a>	
                                            <a><input id="Delet" name="Button" type="submit" value="Delete"></a>
                                            <a><input id="info1" name="Button" type="submit" value=<%=BlockTest%>></a>
                                            </form>


                                    </div>
<!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>