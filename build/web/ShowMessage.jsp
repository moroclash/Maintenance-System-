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
            <!--your Html  *_* -->
            <%
                int chars =Integer.parseInt(request.getParameter("chars"));
                int id =Integer.parseInt(request.getParameter("id"));
                ss.setAttribute("chars", chars);
                ss.setAttribute("id", id);
            %>
            
            
            
            
 <script>
     
     
    (function displaymasseg()
                {
                    var xmlhttp;
                    if (window.XMLHttpRequest)
                    {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                    }
                  else
                    {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }

                    xmlhttp.onreadystatechange= function ()
                    {
                    if (xmlhttp.readyState==4 && xmlhttp.status == 200)
                    {
                    var jsonarr = JSON.parse(xmlhttp.responseText);
                    console.log(jsonarr);
                    var sender = document.getElementById("sender");
                    sender.innerHTML = jsonarr[0].sendername;
                    var Date = document.getElementById("date");
                    Date.innerHTML =jsonarr[0].date;
                    var Time = document.getElementById("time");
                    Time.innerHTML = jsonarr[0].time;
                    var content = document.getElementById("content");
                    content.innerHTML = jsonarr[0].content;
                    var em = "";
                    var div = document.getElementById("commints");
                    for(var i=1; i<jsonarr.length ;i++)
                    {
                        var item = jsonarr[i];
                        console.log(item);
                        em +="sender : <h4 class=\"om\">"+item.sendername+"</h4>   Time : <h4 class=\"om\">"+item.time+"</h4>  Date : <h4 class=\"om\">"+item.date+"</h4> "
                           +"<textarea readonly class=\"la\" cols=\"20\" rows=\"2\" style=\"width: 400px;\" >"+item.content+"</textarea></br><br>"        
                    }
                    div.innerHTML = em;
                }
             };
        var ss  = "num=3";
        xmlhttp.open("POST","ShowAll?"+ss,true);
        xmlhttp.send();                   
   })();
                
            </script>
            <style>
                .om
                {
                    display: inline;
                    margin-right: 20px;
                    
                }
            </style>
                        <div class="col-lg-9 main-chart">
                            <div style="display: inline">
                                Sender : <h3 style="width: 250px; display: inline;" id="sender">  </h3><br>
                                Time : <h4 style="width: 250px; display: inline; margin-right: 50px;" id="time"> </h4>
                                Date : <h4 style="width: 250px;  display: inline;" id="date">  </h4>
                            
                            </div>  
                            
                                <textarea id="content" readonly class="la" name="complain"  cols="25" rows="10" style="width: 600px;" ></textarea></br><br>
                                <div id="commints">                          
                                </div>
                                <form method="post" action="ShowAll?num=4">
                                    <textarea id="content" name="content" placeholder="Enter Your Replaied" class="la" cols="20" rows="2" style="width: 400px;" ></textarea></br><br>    
                                    <input class="se" type="submit"  value="replay"/>
                                </form>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->
<!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>