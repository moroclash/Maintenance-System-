<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
    Author     : moroclash
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Maintenence_Manager_Profile</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css"> 
        <link rel="stylesheet" type="text/css" href="assets/css/mohamedAddEmployee.css"> 


        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">

        <script src="assets/js/chart-master/Chart.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        
            <style>
                #prof{
                    border:none;
                    border-radius:10px;
                    width:700px;
                    height:300px; 
                    margin-left:70px;
                    margin-top:65px;
                }

                #proff{

                    border: none;
                    width: 695px;
                    margin-left: 100px;
                    position: relative;
                    bottom: 50px; 
                }

                #proff2{
                    border:none;  
                    width:290px;
                    margin-left:60px;


                }

                #in{

                    margin-left:400px;
                }

                .in2{
                    width:600px;
                    margin-left:125px;

                }
                #Delet{
                    background-color:#424a5d;
                    color:white;
                    border-radius:3px;
                    border:1px solid #424a5d;
                    width:150px;
                    font-size:20px;

                }
                #info{
                    float: right;

                    background-color:#424a5d;
                    color:white;
                    border-radius:3px;
                    border:1px solid #424a5d;
                    width:150px;
                    font-size:20px;

                }
                #info1{
                    background-color:#424a5d;
                    color:white;
                    border-radius:3px;
                    border:1px solid #424a5d;
                    width:150px;
                    font-size:20px;
                    margin-left: 190px;

                }
            </style>
            <!--sidebar end-->

            <%
            HttpSession se = request.getSession();
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HTML1");
           
          
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("Question");

          
%>
          
                        <div class="col-lg-9 main-chart">
                            <h2 id="in" > Result</h2> 
                            <hr class="in2">


                            <div id="prof">
                                <form action="Forget_pass2">
                                    <div  id="proff"> 

                                        <center>   
                                           <pre>
                                       <select style="width:300px; font-size: 20px" name="question"> 
                                        <%
                                            for(int i=0;i<HTMLD.size();i++)
                                            {
                                                %>
                                                <%=HTMLD.get(i)%>
                                                <%
                                            }
                                          %>
                                    </select>  </pre>
                                        <pre>
                                        <label style="font-size: 20px" for="Answer" class="top" >Answer :  </label>  
                                        <input type="text" id="Answer" name="Answer" placeholder="Answer" title="please enter your Last name"  required class="Input" pattern="[A-Za-z ]{3,}">
                                        </pre>
                                        <pre>
                                        <label style="font-size: 20px"class="top" for="Email" >Email : </label>  
                                        <input type="email" id="Email" name="Email"placeholder="Email"  required class="Input" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"  title="please enter Employee email">
                                        </pre>
                                        
                                            <br>
                                            </div>
                                            <hr class="in2">  
                                            <a> <input id="info"  name="Button" type="submit" value="Submit"></a>	
                                            
                                            
                                            </form>


                                    </div>
                            </div><!-- /col-lg-9 END SECTION MIDDLE -->
    </body>
</html>
