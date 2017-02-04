

<%-- 
    Document   : Add_bill
    Created on : May 9, 2016, 2:55:19 AM
    Author     : moahmed A.Radwan
--%>
<%@page import= "SE.Offer" %>
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
                      <link rel="stylesheet" type="text/css" href="assets/css/mohamedAddEmployee.css"> 
                      <form method="post" action="NewServlet">
                      <%
                          HttpSession sesstion=request.getSession();
                         ArrayList<String> Names= (ArrayList<String>)sesstion.getAttribute("Method_name");
                          ArrayList<Offer> Offers= (ArrayList<Offer>)sesstion.getAttribute("Offers");
                         /* ArrayList<String> Names=new ArrayList<String>();
                          ArrayList<Offer> Offers=new ArrayList<Offer>();
                          Names.add("cash");Names.add("aDAds");Names.add("DAdss");
                          Offer s= new Offer(50);
                          s.setId(5);
                          Offers.add(s);*/
                         
                      
                      %>
                   <h2 id="in" > Add Bill </h2> 
                   <hr class="in2">
                   <div>
                  <div class="label5">			 
                    <label class="label5t" for="Cost" >Cost  : </label>
                    <input type="text" id="Cost" placeholder="Cost" name="cost"  required class="Input" >
                   
                     <div class="padd">
                        
                        
                         <label class="label5t" for="Offer">Offer :</label>   
                         <select name="Offer"  class="Input" >
                             <option value="" name=""></option>
                        <%  for(Offer offer:Offers)
                        {  %>
                        
                        <option value="<%=offer.getId()%>" > <%= offer.getOffer() %> </option>                       
                        <%
                        };
                        %>
                        
                        </select>
                        
                        <label class="label5t" for="Paymethod Type" style="margin-top: 20px;">Paymethod Type :</label> 
                        <select name="Paymethod Type" required class="Input" name="payment">
                        <%  for(String name:Names)
                        {  %>
                        
                        <option value="<%=name%>" <% if(name=="cash") {%>
                            selected
                      <%  }%> ><%=name%></option>                       
                        <%
                        };
                        %>
                            
                        </select>
                        
                        <script>
                          function getSpare(str) {
                                if (str.length == 0) { 
                                    document.getElementById('thed').innerHTML = "";
                                    return;
                                } else {
                                    var xmlhttp = new XMLHttpRequest();
                                    xmlhttp.onreadystatechange = function() {
                                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) { 
                                           var ch=JSON.parse(xmlhttp.responseText);
                                           var thed=document.getElementById('thed');
                                           var bn="";
                                           for(var i in ch)
                                           {
                                               var c=ch[i];
                                               bn+="<tr>"
                                               +"<td>"+c.SpareName+"</td>"
                                               +" <td>"+c.Cost+"</td>"
                                      
                                               +"<td> <input type=\"button\" onclick=\"ADDthis(\'"+c.SpareName+"\', \'"+c.Cost+"\')\" value=\"ADD\" /></td>"
                                               
                                               +"</tr>";
                                           }
                                           thed.innerHTML=bn;
                                        }
                                    };
                                    xmlhttp.open("post","SHowAllSPare?SpareName="+ str, true);
                                    xmlhttp.send();
                                }
                            }
                            
                             function ADDthis(str,cost) {
                                        
                                           ADDthis.count=++ADDthis.count||0;  
                                           var thed=document.getElementById('thed2'); 
                                           var tr=document.createElement("tr");
                                           var att1=document.createAttribute('id');
                                           att1.value=ADDthis.count;
                                           tr.setAttributeNode(att1);
                                           var td1=document.createElement("td"),td2=document.createElement("td"),td3=document.createElement("td");
                                           td1.appendChild(document.createTextNode(str));
                                           td2.appendChild(document.createTextNode(cost));
                                             var cb = document.createElement('input');
                                             cb.type = 'checkbox';
                                             cb.id = "chek";
                                            var att=document.createAttribute("name");
                                            att.value="Name";
                                            td1.setAttributeNode(att);
                                            att=document.createAttribute("value");
                                            att.value="\""+str+"\"";
                                            td1.setAttributeNode(att);
                                            att=document.createAttribute("name");
                                            att.value="Cost";
                                            var inpu=document.createElement('input');
                                            inpu.type='hidden';
                                            inpu.value=str;
                                            var atr=document.createAttribute("name");
                                            atr.value="someName";
                                            inpu.setAttributeNode(atr);
                                            td2.setAttributeNode(att);
                                           td3.appendChild(cb);
                                           tr.appendChild(td1);
                                           tr.appendChild(td2);
                                           tr.appendChild(td3);
                                           tr.appendChild(inpu);
                                           inpu=document.createElement('input');
                                            inpu.type='hidden';
                                            inpu.value=cost;
                                             atr=document.createAttribute("name");
                                            atr.value="costS";
                                            inpu.setAttributeNode(atr);
                                          tr.appendChild(inpu);
                                           thed.appendChild(tr);                           
                                    }
                                 
                                                    function bn() {
                                                    try {
                                                    var table = document.getElementById("table1");
                                                    var rowCount = table.rows.length;
                                                    
                                                    for(var i=1; i<rowCount; i++) {
                                                    var row = table.rows[i];
                                                    var chkbox = row.cells[2].childNodes[0];
                                                    if(null != chkbox  && true == chkbox.checked){                                                 
                                                    table.deleteRow(i);
                                                    rowCount--;
                                                    i--;
                                                    }
                                                    }
                                                    }catch(e) {
                                                    alert(e);
                                                    }
                                                    }
                                    
                                     
                                    
                             
                            
                        </script>
                        <form method="post" action="">
                        <div  style="margin-top: 20px;">
                        <label for="inData" > SPare Parts name </label>
                        <input type="search" name="inData" ng-model="inData" onkeyup="getSpare(this.value)" />
                         </div>
                        <table border="1" class="tablean" id="table1">
                           <thead>
                            <tr>
                                 <th>Name </th>
                                  <th>Cost </th>
                                  <th><input type="button" onclick="bn()" value="Delete"/></th>
                            </tr>
                            </thead>
                            <thead id="thed2">
                                
                            </thead>
                        </table>
                        <table border="1"  class="table3ard">
                            <thead>
                            <tr>
                                 <th>Name </th>
                                  <th>Cost </th>
                                  <th>Add </th>
                            </tr>
                            </thead>
                            <thead id="thed">
                                
                            </thead>
                            
                        </table>
                           <input type="submit" value="send bill" onclick="" formmethod="post" formaction="NewServlet" Style="width: 150px;position: relative;top: 50px;right: -177px;" >
                    </div>
                         </div><!-- label5--> 
                 	
                  </div>
                        <script src="js/angular.min.js"></script>
                        <script type="text/javascript" src="js/APPBILL.js"></script>
                        </form>
                      
            <!-------------- ~_~ -->
            <%=notificationList%>               
            <%=footer%> 
    </body>
</html>
