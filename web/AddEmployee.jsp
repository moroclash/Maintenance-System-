<%-- 
    Document   : AddEmployee
    Created on : Mar 28, 2016, 7:49:45 PM
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
        <script src="assets/js/AddingEmployee.js"></script>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                 <a href="Home.jsp" class="logo"><b>Maintenance</b></a>             
                 <!--logo end-->
                <div class="nav notify-row" id="top_menu">
                    <!--  notification start -->
                    <ul class="nav top-menu">
                        <!-- settings start -->
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <i class="fa fa-tasks"></i>
                                <span class="badge bg-theme">4</span>
                            </a>
                            <ul class="dropdown-menu extended tasks-bar">
                                <div class="notify-arrow notify-arrow-green"></div>
                                <li>
                                    <p class="green">You have 4 pending tasks</p>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <div class="task-info">
                                            <div class="desc">DashGum Admin Panel</div>
                                            <div class="percent">40%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                                <span class="sr-only">40% Complete (success)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <div class="task-info">
                                            <div class="desc">Database Update</div>
                                            <div class="percent">60%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                <span class="sr-only">60% Complete (warning)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <div class="task-info">
                                            <div class="desc">Product Development</div>
                                            <div class="percent">80%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                <span class="sr-only">80% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <div class="task-info">
                                            <div class="desc">Payments Sent</div>
                                            <div class="percent">70%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                                <span class="sr-only">70% Complete (Important)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="external">
                                    <a href="#">See All Tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- settings end -->
                        <!-- inbox dropdown start-->
                        <li id="header_inbox_bar" class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-theme">5</span>
                            </a>
                            <ul class="dropdown-menu extended inbox">
                                <div class="notify-arrow notify-arrow-green"></div>
                                <li>
                                    <p class="green">You have 5 new messages</p>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                        <span class="subject">
                                            <span class="from">Zac Snider</span>
                                            <span class="time">Just now</span>
                                        </span>
                                        <span class="message">
                                            Hi mate, how is everything?
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
                                        <span class="subject">
                                            <span class="from">Divya Manian</span>
                                            <span class="time">40 mins.</span>
                                        </span>
                                        <span class="message">
                                            Hi, I need your help with this.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
                                        <span class="subject">
                                            <span class="from">Dan Rogers</span>
                                            <span class="time">2 hrs.</span>
                                        </span>
                                        <span class="message">
                                            Love your new Dashboard.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">
                                        <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
                                        <span class="subject">
                                            <span class="from">Dj Sherman</span>
                                            <span class="time">4 hrs.</span>
                                        </span>
                                        <span class="message">
                                            Please, answer asap.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="index.html#">See all messages</a>
                                </li>
                            </ul>
                        </li>
                        <!-- inbox dropdown end -->
                    </ul>
                    <!--  notification end -->
                </div>
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="login.html">Logout</a></li>
                    </ul>
                </div>
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
           <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">

                        <p class="centered"><a href="MyInfo.jsp"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                        <h5 class="centered">Manager</h5>

                        <li class="mt">
                            <a  href="Manager_profile.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Home</span>
                            </a>
                        </li>

                        <li class="sub-menu">
                            <a class="active" href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Manage</span>
                            </a>
                            <ul class="sub">
                                <li class="active" ><a  href="AddEmployee.jsp">Add Employee</a></li>
                                <li><a  href="Search.jsp">Search Employee</a></li>
                                <li><a  href="ShowAllEmplyee">Show All Employee</a></li>
                                <li><a  href="Search.html">Search Customer</a></li>
                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a  href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Quality</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="#">Branch</a></li>
                                <li><a  href="#">Technical</a></li>

                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Messages</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="gallery.html">Inbox</a></li>
                                <li><a  href="gallery.html">Send to Employee</a></li>
                                <li><a  href="lock_screen.html">Send to Customer</a></li>
                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Complains</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="Search.html">Show Complain</a></li>
                            </ul>
                        </li>

                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>

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
                    width: 665px;
                    margin-left: 75px;
                    position: relative;
                    bottom: 60px;

                }

                #proff2{
                    border:none;  
                    width:290px;
                    margin-left:60px;


                }

                #in{
                    margin-top:20px;
                    margin-left:300px;
                }

                .in2{
                    width: 751px;
                    margin-left: 40px;

                }

                .in3{
                    width: 751px;

                    position: relative;
                    left: -24px;

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
                            <h2 id="in"> Add Employee </h2> 
                            <hr class="in2">
                            <div id="prof">
                                <form  method="post" name="FirstForm" action="AddEmployee" >
                                    <div  id="proff"> 

                                        <label style="font-size: 20px" for="Firstname"  class="top">First Name: </label>  
                                        <input type="text" name="FirstName"id="Firstname" title="please enter your First name" placeholder="First Name" autofocus required class="Input" pattern="[A-Za-z]{2,10}">

                                        <label style="font-size: 20px" for="Lastname" class="top" >Last Name :  </label>  
                                        <input type="text" id="Lastname" name="Lastname" placeholder="Last Name" title="please enter your Last name"  required class="Input" pattern="[A-Za-z ]{3,}">

                                        <label style="font-size: 20px" for="SSn" class="top">SSN  : </label>  
                                        <input type="text" id="SSn" name="Ssn" title="please enter your Employee SSN" placeholder="SSn"  required class="Input"pattern="[0-9]{15}">


                                        <label style="font-size: 20px" for="salary" class="top"> Salary : </label>  
                                        <input type="number" id="salary" name="Salary" title="please enter your Employee salary" placeholder="Salary"  required class="Input" min="500" step="50" max="10000">                        

                                        <label style="font-size: 20px" for="Address" class="top">Adress: </label>  
                                        <input type="text" id="Address" name="Address" placeholder="Address"  required class="Input">


                                        <label style="font-size: 20px" class="top"for="BD" >BirthDate : </label>  
                                        <input type="date" id="BD" name="BirthDate" class="Input" placeholder="dd/mm/yyyy" >

                                        <label style="font-size: 20px" for="phone" class="top">Phone  : </label>  
                                        <input type="text" pattern="[0-9]{11}"  name="Phone" id="phone" placeholder="Phone" required  class="Input">

                                        <label style="font-size: 20px" for="workH" class="top">Work hours: </label>  
                                        <input type="number" min="6" name="Workhours" max="12" step="2" id="workH"  placeholder="Work Hours"  required class="Input">


                                        <label style="font-size: 20px" for="Gender" class="top"> Gender : </label>  
                                        <label style="font-size: 20px" for="ma"class="topAd" > Male </label>

                                        <input type="radio" id="ma"  class="radio2" name="gender" value="Female">
                                        <label style="font-size: 20px" for="fa" class="topAdw"> Famale </label>

                                        <input type="radio" class="radio2" name="gender" id="fa" value="Male"><br>
                                        <label style="font-size: 20px" for="deparment" class="top"> Type&nbsp; : </label>  
                                        <label style="font-size: 20px" for="tec" class="topAds"> techincal </label>

                                        <input type="radio" id="tec"  class="radio3" name="depart" value="0">
                                        <label style="font-size: 20px" for="ser" class="topAds"> service </label>
                                        <input type="radio" class="radio3" name="depart" value="1" id="ser" >
                                        <br>

                                        <label style="font-size: 20px" for="pass" class="top">Password : </label>  
                                        <input  required type="password" name="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="pass" placeholder="Password of Employee" class="Input"  title="should be at least one number, one lowercase and one uppercase letter
                                                and  at least 8 characters">
                                        
                                        
                                        <br>
                                        <br>
                                        <% 
                                            HttpSession s = request.getSession();
                                            try
                                            {
                                            int f = (Integer) s.getAttribute("flag");
                                            if(f==1)
                                            {
                                        %>
                                        <h3 style="color: green;">Add id Done !<h3>
                                        <%}
                                            else if(f == 2)
                                            {
                                        %>
                                         <h3 style="color: red;">Employee Exist!<h3>
                                        <%
                                            }
                                          }
                                          catch(Exception x)
                                          {
                                            
                                          }
                                         %>
                                            
                                
                                    </div>
                                    <hr class="in3">  
                                        <input id="info" type="submit" value=" ADD&nbsp; ">		
                                        <input id="info" style="margin-right: 50px;" type="reset" value=" Reset ">	  
                                </form>


                            </div>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->


                        <!-- **********************************************************************************************************************************************************
                        RIGHT SIDEBAR CONTENT
                        *********************************************************************************************************************************************************** -->                  

                        <div class="col-lg-3 ds">
                            <!--COMPLETED ACTIONS DONUTS CHART-->
                            <h3>NOTIFICATIONS</h3>

                            <!-- First Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>2 Minutes Ago</muted><br/>
                                    <a href="#">James Brown</a> subscribed to your newsletter.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Second Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>3 Hours Ago</muted><br/>
                                    <a href="#">Diana Kennedy</a> purchased a year subscription.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Third Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>7 Hours Ago</muted><br/>
                                    <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Fourth Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>11 Hours Ago</muted><br/>
                                    <a href="#">Mark Twain</a> commented your post.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Fifth Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>18 Hours Ago</muted><br/>
                                    <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                                    </p>
                                </div>
                            </div>





                            <!-- CALENDAR-->
                            <div id="calendar" class="mb">
                                <div class="panel green-panel no-margin">
                                    <div class="panel-body">
                                        <div id="date-popover" class="popover top" style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                                            <div class="arrow"></div>
                                            <h3 class="popover-title" style="disadding: none;"></h3>
                                            <div id="date-popover-content" class="popover-content"></div>
                                        </div>
                                        <div id="my-calendar"></div>
                                    </div>
                                </div>
                            </div><!-- / calendar -->

                        </div><!-- /col-lg-3 -->
                    </div><! --/row -->
                </section>
            </section>

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    FCIH_2014 TEAM
                    <a href="index.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
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
