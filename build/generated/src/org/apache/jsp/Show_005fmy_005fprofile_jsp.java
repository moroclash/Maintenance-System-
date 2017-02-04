package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import SE.Employee;

public final class Show_005fmy_005fprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html ng-app=\"sampleApp\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"Dashboard\">\n");
      out.write("        <meta name=\"keyword\" content=\"Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\n");
      out.write("\n");
      out.write("        <title>Maintenence</title>\n");
      out.write("        \n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <!--external css-->\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/zabuto_calendar.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/js/gritter/css/jquery.gritter.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/lineicons/style.css\">    \n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"assets/css/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/chart-master/Chart.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/test1.js\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"js/angular.min.js\"></script>\n");
      out.write("        <script  src=\"js/App.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("            ");

               HttpSession ss = request.getSession();
               String list = (String) ss.getAttribute("listhtml");
               String nav = (String) ss.getAttribute("nav");
               String notificationList = (String) ss.getAttribute("NotificationList");
               String footer = (String) ss.getAttribute("footer");
            
      out.write("\n");
      out.write("    <body>\n");
      out.write("            <section id=\"container\" >\n");
      out.write("  <!--header start-->\n");
      out.write("      <header class=\"header black-bg\">\n");
      out.write("              <div class=\"sidebar-toggle-box\">\n");
      out.write("                  <div class=\"fa fa-bars tooltips\" data-placement=\"right\" data-original-title=\"Toggle Navigation\"></div>\n");
      out.write("              </div>\n");
      out.write("            <!--logo start-->\n");
      out.write("            <a href=\"index.html\" class=\"logo\"><b>Maintance</b></a>\n");
      out.write("            <!--logo end-->\n");
      out.write("            <div class=\"nav notify-row\" id=\"top_menu\">\n");
      out.write("                <!--  notification start -->\n");
      out.write("                <ul class=\"nav top-menu\">\n");
      out.write("        \n");
      out.write("                    <!-- inbox dropdown start-->\n");
      out.write("                    <li id=\"header_inbox_bar\" class=\"dropdown\">\n");
      out.write("                        <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"index.html#\">\n");
      out.write("                            <i class=\"fa fa-envelope-o\"></i>\n");
      out.write("                            <span class=\"badge bg-theme\" id=\"taskenum\"></span>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu extended inbox\">\n");
      out.write("                            <div class=\"notify-arrow notify-arrow-green\"></div>\n");
      out.write("                            <li>\n");
      out.write("                                <p class=\"green\" id=\"taskeinsidnum\"></p>\n");
      out.write("                            </li>\n");
      out.write("                            <div id=\"notyfies\">\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"index.html#\">See all messages</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- inbox dropdown end -->\n");
      out.write("                </ul>\n");
      out.write("                <!--  notification end -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"top-menu\">\n");
      out.write("            \t<ul class=\"nav pull-right top-menu\">\n");
      out.write("                    <li><a class=\"logout\" href=\"LogOut\">Logout</a></li>\n");
      out.write("            \t</ul>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("      <!--header end-->\n");
      out.write("            ");
      out.print(list);
      out.write("           \n");
      out.write("             <section id=\"main-content\">\n");
      out.write("                <section class=\"wrapper\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-9 main-chart\">\n");
      out.write("                            <div ng-view>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                        </div><!-- /col-lg-9 END SECTION MIDDLE -->\n");
      out.write("                        <div class=\"col-lg-3 ds\">\n");
      out.write("                            <!--COMPLETED ACTIONS DONUTS CHART-->\n");
      out.write("                            <h3>NOTIFICATIONS</h3>\n");
      out.write("                           <div id=\"notyfi\">\n");
      out.write("                               \n");
      out.write("                          \n");
      out.write("                           </div>\n");
      out.write("<!-- CALENDAR-->\n");
      out.write("                            <div id=\"calendar\" class=\"mb\">\n");
      out.write("                                <div class=\"panel green-panel no-margin\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <div id=\"date-popover\" class=\"popover top\" style=\"cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;\">\n");
      out.write("                                            <div class=\"arrow\"></div>\n");
      out.write("                                            <h3 class=\"popover-title\" style=\"disadding: none;\"></h3>\n");
      out.write("                                            <div id=\"date-popover-content\" class=\"popover-content\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div id=\"my-calendar\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div><!-- / calendar -->\n");
      out.write("                  </div><!-- /col-lg-3 -->\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("            </section>\n");
      out.write("             \n");
      out.write("                 <!--footer start-->\n");
      out.write("            <footer class=\"site-footer\">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    2014 - Alvarez.is\n");
      out.write("                    <a href=\"index.html#\" class=\"go-top\">\n");
      out.write("                        <i class=\"fa fa-angle-up\"></i>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("            <!--footer end-->\n");
      out.write("        </section>\n");
      out.write("<!-- js placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"assets/js/jquery.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-1.8.3.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script class=\"include\" type=\"text/javascript\" src=\"assets/js/jquery.dcjqaccordion.2.7.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.scrollTo.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.nicescroll.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.sparkline.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--common script for all pages-->\n");
      out.write("        <script src=\"assets/js/common-scripts.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/js/gritter/js/jquery.gritter.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/js/gritter-conf.js\"></script>\n");
      out.write("\n");
      out.write("        <!--script for this page-->\n");
      out.write("        <script src=\"assets/js/sparkline-chart.js\"></script>    \n");
      out.write("        <script src=\"assets/js/zabuto_calendar.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"application/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("            $(\"#date-popover\").popover({html: true, trigger: \"manual\"});\n");
      out.write("            $(\"#date-popover\").hide();\n");
      out.write("            $(\"#date-popover\").click(function (e) {\n");
      out.write("            $(this).hide();\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(\"#my-calendar\").zabuto_calendar({\n");
      out.write("            action: function () {\n");
      out.write("            return myDateFunction(this.id, false);\n");
      out.write("            },\n");
      out.write("            action_nav: function () {\n");
      out.write("            return myNavFunction(this.id);\n");
      out.write("            },\n");
      out.write("            ajax: {\n");
      out.write("            url: \"show_data.php?action=1\",\n");
      out.write("            modal: true\n");
      out.write("            },\n");
      out.write("            legend: [\n");
      out.write("            {type: \"text\", label: \"Special event\", badge: \"00\"},\n");
      out.write("            {type: \"block\", label: \"Regular event\", }\n");
      out.write("            ]\n");
      out.write("            });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("\n");
      out.write("            function myNavFunction(id) {\n");
      out.write("            $(\"#date-popover\").hide();\n");
      out.write("            var nav = $(\"#\" + id).data(\"navigation\");\n");
      out.write("            var to = $(\"#\" + id).data(\"to\");\n");
      out.write("            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
