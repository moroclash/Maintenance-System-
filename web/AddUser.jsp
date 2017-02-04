<%-- 
    Document   : AddEmployee
    Created on : Mar 28, 2016, 7:49:45 PM
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
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HtmlTypes");
            ArrayList<String> HTMLCountry = (ArrayList<String>) se.getAttribute("CountryHTML");
            ArrayList<String> Mo7fzaHTML = (ArrayList<String>) se.getAttribute("Mo7fzaHTML");
            ArrayList<String> Mnat2HTML = (ArrayList<String>) se.getAttribute("Mnat2HTML");
            ArrayList<String> Questions = (ArrayList<String>) se.getAttribute("Questions");
        %>
       
                            <h2 id="in"> Add Employee </h2> 
                            <hr class="in2">
                            <div id="prof">
                                <form  action="AddActor" method="post" name="FirstForm" >
                                    
                                    <div  id="proff"> 
                                        <pre>
                                        <label style="font-size: 20px" for="Firstname"  class="top">First Name: </label>  
                                        <input type="text" name="FNAME" id="Firstname" title="please enter your First name" placeholder="First Name" autofocus required class="Input" pattern="[A-Za-z]{2,10}">
                                        </pre>
                                        <pre>
                                        <label style="font-size: 20px" for="Lastname" class="top" >Last Name :  </label>  
                                        <input type="text" id="Lastname" name="LNAME" placeholder="Last Name" title="please enter your Last name"  required class="Input" pattern="[A-Za-z ]{3,}">
                                        </pre>
                                        <pre>
                                        <label style="font-size: 20px"class="top" for="Email" >Email : </label>  
                                        <input type="email" id="Email" name="Email"placeholder="Email"  required class="Input" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"  title="please enter Employee email">
                                        </pre>  
                                      
                                        <pre>
                                          Security Question  <select style="width:200px;" name="Questions"> 
                                        <%
                                            for(int i=0;i<Questions.size();i++)
                                            {
                                                %>
                                                <%=Questions.get(i)%>
                                                <%
                                            }
                                          %>
</pre>                                    </select>                                           

                                        <%
                                            for (int i = 0; i < HTML.size(); i++)
                                            {
                                        %>
                                        <pre>
                                            <%=HTML.get(i)%>
                                        </pre>
                                        <%
                                            }
                                        %>
                                        
                                  Country  <select style="width:200px;" name="country"> 
                                        <%
                                            for(int i=0;i<HTMLCountry.size();i++)
                                            {
                                                %>
                                                <%=HTMLCountry.get(i)%>
                                                <%
                                            }
                                          %>
                                    </select>                                         
                                  Mo7fza  <select style="width:200px;" name="state"> 
                                        <%
                                            for(int i=0;i<Mo7fzaHTML.size();i++)
                                            {
                                                %>
                                                <%=Mo7fzaHTML.get(i)%>
                                                <%
                                            }
                                          %>
                                    </select>
                                    
                                    </select>                                         
                                  Mnt2a  <select style="width:200px;" name="area"> 
                                        <%
                                            for(int i=0;i<Mnat2HTML.size();i++)
                                            {
                                                %>
                                                <%=Mnat2HTML.get(i)%>
                                                <%
                                            }
                                          %>  
                                  </select>



                                        <label style="font-size: 20px" for="Gender" class="top"> Gender : </label>  
                                        <label style="font-size: 20px" for="ma"class="topAd" > Male </label>

                                        <input type="radio" id="ma"  class="radio2" name="gender" value="Male">
                                        <label style="font-size: 20px" for="fa" class="topAdw"> Famale </label>

                                        <input type="radio" class="radio2" name="gender" value="Female" id="fa"><br>
       

                                        <br>



                                        <label style="font-size: 20px" for="pass" class="top">Password : </label>  
                                        <input  name="Pass" required type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="pass" placeholder="assword of Employee" class="Input"  title="should be at least one number, one lowercase and one uppercase letter
                                                and  at least 8 characters">

                                    </div>
                                    <hr class="in3">  
                                    <div>
                                        <input id="info" type="submit" value=" ADD&nbsp; ">		
                                        <input id="info" style="margin-right: 50px;" type="reset" value=" Reset ">	  
                                    </div>
                                </form>


                            </div>
                  <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
                