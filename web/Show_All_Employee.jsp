

<%@page import="SE.Employee"%>
<%@page import="SE.Service"%>
<%@page import="SE.Technical"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>DASHGUM - Bootstrap Admin Template</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">

        <link href="assets/css/table-responsive.css" rel="stylesheet">

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
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">

                        <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
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
                                <li><a  href="AddEmployee.jsp">Add Employee</a></li>
                                <li><a  href="Search.html">Search Employee</a></li>
                                <li class="active" ><a href="ShowAllEmplyee">Show All Employee</a></li>
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
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i> All Employee</h3>
                    <div class="row mt">
                        <div class="col-lg-12">
                            <div class="content-panel">
                                <h4><i class="fa fa-angle-right"></i> Employee Info</h4>
                                <section id="unseen">
                                    <table class="table table-bordered table-striped table-condensed">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th class="numeric">Ssn</th>
                                                <th class="numeric">Salary</th>
                                                <th class="numeric">Gander</th>
                                                <th class="numeric">Date of Appointment</th>
                                                <th class="numeric">phone</th>
                                                <th class="numeric">Type</th>
                                                <th class="numeric">workhours</th>
                                                <th class="numeric">Quality</th>
                                                <th class="numeric">AccountBlock</th>
                                            </tr>
                                        </thead>
                                        <tbody id="Emp_D">
                                            <%
                                                HttpSession se = request.getSession();
                                                try{
                                                    ArrayList<Technical> t = (ArrayList<Technical>) se.getAttribute("tec");
                                                    ArrayList<Service> s = (ArrayList<Service>) se.getAttribute("ser");
                                                    Employee ss;
                                                    int id ;
                                                    String name ;
                                                    String ssn ;
                                                    Double salary;
                                                    String gander;
                                                    String Dept;
                                                    String phone;
                                                    String type;
                                                    int houer;
                                                    String quality;
                                                    String block;
                                                for(int i=0; i<s.size() ; i++)
                                                {
                                                    ss = s.get(i);
                                                    id = ss.ID;
                                                    name = ss.Fname+" "+ss.Lname;
                                                    ssn = ss.Ssn;
                                                    salary = ss.Salary;
                                                    gander = ss.Gender;
                                                    Dept = ss.Dateapointment;
                                                    phone =ss.Phone;
                                                    type =ss.Spetiolization;
                                                    houer = ss.Workhours;
                                                    quality = Integer.toString(ss.Quality)+"%";
                                                    block = "";
                                                    if( ss.Accountblock)
                                                    {
                                                        block="YES";
                                                    }
                                                    else
                                                    {
                                                        block="NO";
                                                    }
                                            %>
                                                <tr>
                                                    <td><%=id%></td>
                                                    <td><%=name%></td>
                                                    <td class="numeric"><%=ssn%></td>
                                                    <td class="numeric"><%=salary%></td>
                                                    <td class="numeric"><%=gander%></td>
                                                    <td class="numeric"><%=Dept%></td>
                                                    <td class="numeric"><%=phone%></td>
                                                    <td class="numeric"><%=type%></td>
                                                    <td class="numeric"><%=houer%></td>         
                                                    <td class="numeric"><%=quality%></td>
                                                    <td class="numeric"><%=block%></td>
                                                </tr>
                                            <% }
                                                for(int i=0; i<t.size() ; i++)
                                            {
                                                ss = t.get(i);
                                                    id = ss.ID;
                                                    name =ss.Fname+" "+ss.Lname;
                                                    ssn =ss.Ssn;
                                                    salary = ss.Salary;
                                                    gander = ss.Gender;
                                                    Dept =ss.Dateapointment;
                                                    phone =ss.Phone;
                                                    type =ss.Spetiolization;
                                                    houer =ss.Workhours;
                                                    quality = Integer.toString(ss.Quality)+"%";
                                                    block = "";
                                                    if( ss.Accountblock)
                                                    {
                                                        block="YES";
                                                    }
                                                    else
                                                    {
                                                        block="NO";
                                                    }
                                            %>
                                                <tr>
                                                    <td><%=id%></td>
                                                    <td><%=name%></td>
                                                    <td class="numeric"><%=ssn%></td>
                                                    <td class="numeric"><%=salary%></td>
                                                    <td class="numeric"><%=gander%></td>
                                                    <td class="numeric"><%=Dept%></td>
                                                    <td class="numeric"><%=phone%></td>
                                                    <td class="numeric"><%=type%></td>
                                                    <td class="numeric"><%=houer%></td>           
                                                    <td class="numeric"><%=quality%></td>
                                                    <td class="numeric"><%=block%></td>
                                                </tr>
                                            <% }
                                             }
                                                catch(Exception x)
                                                {
                                                    
                                                }
                                            %>
                                        </tbody>
                                         <script>          
            
        </script>
                                    </table>
                                </section>
                            </div><!-- /content-panel -->
                        </div><!-- /col-lg-4 -->			
                    </div><!-- /row -->
                    
                    
                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2014 - Alvarez.is
                    <a href="responsive_table.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>

        <!--script for this page-->


    </body>
</html>
