<%-- 
    Document   : Search
    Created on : Mar 28, 2016, 8:04:48 PM
    Author     : moroclash
--%>

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
        <%
        HttpSession se=request.getSession();
        String Alert=(String) se.getAttribute("Alert1");
        System.out.println(Alert);
        String Color ="";
            String Action="";        
        if(Alert.equals("User Blocked"))
        {
            Color="Red";
            Action="SearchUser.jsp";
        }
        else if(Alert.equals("User UnBlocked"))
        {
            Color="Green";
             Action="SearchUser.jsp";
        }
        else if(Alert.equals("Blocked"))
        {
            Color="Red";
            Action="Login.jsp";
        }
        else if(Alert.equals("ErrorPassword"))
        {
            Color="Red";
            Action="Login.jsp";
        }else if(Alert.equals("Accept"))
            {
                int id = (int) session.getAttribute("reqID");
                SE.Service_Management ser = SE.Service_Management.Get_Serive_Management();
                ser.Accept_Request(id);
                response.sendRedirect("Show_my_profile.jsp");
                
            }        
        else 
        {
            Color="aqua";
             Action="SearchUser.jsp";            
        }
        %>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
          
            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
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

            <!--
         **********************************************************************************************************************************************************
          
        MAIN CONTENT
         
              *********************************************************************************************************************************************************** -->

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">

                    <div class="row">
                        <div class="col-lg-9 main-chart">
                            <h2  id="in" > Result</h2> 


                            <div id="prof">
                                <form action=<%=Action%>>
                                    <pre>
                                    <H3 style=" color:<%=Color%>;text-align: center; margin-left: 37px "><%=Alert%></H3>
                                    </pre>
                                            <input style="margin-left:0px"   type="submit" value="Back" id="info1">                                    
                                </form>


                            </div>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->


                        <!-- **********************************************************************************************************************************************************
                        RIGHT SIDEBAR CONTENT
                        *********************************************************************************************************************************************************** -->                  

            <!--main content end-->
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/jquery-1.8.3.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="assets/js/jquery.sparkline.js"></script>


        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>

        <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

        <!--script for this page-->
        <script src="assets/js/sparkline-chart.js"></script>    
        <script src="assets/js/zabuto_calendar.js"></script>	



        <script type="application/javascript">
            $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
            $(this).hide();
            });

            $("#my-calendar").zabuto_calendar({
            action: function () {
            return myDateFunction(this.id, false);
            },
            action_nav: function () {
            return myNavFunction(this.id);
            },
            ajax: {
            url: "show_data.php?action=1",
            modal: true
            },
            legend: [
            {type: "text", label: "Special event", badge: "00"},
            {type: "block", label: "Regular event", }
            ]
            });
            });


            function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
            }
        </script>


    </body>
</html>