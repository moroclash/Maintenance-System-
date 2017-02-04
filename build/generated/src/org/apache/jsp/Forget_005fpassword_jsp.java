package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class Forget_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"Dashboard\">\n");
      out.write("        <meta name=\"keyword\" content=\"Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\n");
      out.write("\n");
      out.write("        <title>Maintenence_Manager_Profile</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <!--external css-->\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/zabuto_calendar.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/js/gritter/css/jquery.gritter.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/lineicons/style.css\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/mohamedAddEmployee.css\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"assets/css/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/chart-master/Chart.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("            <style>\n");
      out.write("                #prof{\n");
      out.write("                    border:none;\n");
      out.write("                    border-radius:10px;\n");
      out.write("                    width:700px;\n");
      out.write("                    height:300px; \n");
      out.write("                    margin-left:70px;\n");
      out.write("                    margin-top:65px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #proff{\n");
      out.write("\n");
      out.write("                    border: none;\n");
      out.write("                    width: 695px;\n");
      out.write("                    margin-left: 100px;\n");
      out.write("                    position: relative;\n");
      out.write("                    bottom: 50px; \n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #proff2{\n");
      out.write("                    border:none;  \n");
      out.write("                    width:290px;\n");
      out.write("                    margin-left:60px;\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #in{\n");
      out.write("\n");
      out.write("                    margin-left:400px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .in2{\n");
      out.write("                    width:600px;\n");
      out.write("                    margin-left:125px;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                #Delet{\n");
      out.write("                    background-color:#424a5d;\n");
      out.write("                    color:white;\n");
      out.write("                    border-radius:3px;\n");
      out.write("                    border:1px solid #424a5d;\n");
      out.write("                    width:150px;\n");
      out.write("                    font-size:20px;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                #info{\n");
      out.write("                    float: right;\n");
      out.write("\n");
      out.write("                    background-color:#424a5d;\n");
      out.write("                    color:white;\n");
      out.write("                    border-radius:3px;\n");
      out.write("                    border:1px solid #424a5d;\n");
      out.write("                    width:150px;\n");
      out.write("                    font-size:20px;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                #info1{\n");
      out.write("                    background-color:#424a5d;\n");
      out.write("                    color:white;\n");
      out.write("                    border-radius:3px;\n");
      out.write("                    border:1px solid #424a5d;\n");
      out.write("                    width:150px;\n");
      out.write("                    font-size:20px;\n");
      out.write("                    margin-left: 190px;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("            <!--sidebar end-->\n");
      out.write("\n");
      out.write("            ");

            HttpSession se = request.getSession();
            ArrayList<String> HTML = (ArrayList<String>) se.getAttribute("HTML1");
           
          
            ArrayList<String> HTMLD=(ArrayList<String>) se.getAttribute("Question");

          

      out.write("\n");
      out.write("          \n");
      out.write("                        <div class=\"col-lg-9 main-chart\">\n");
      out.write("                            <h2 id=\"in\" > Result</h2> \n");
      out.write("                            <hr class=\"in2\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div id=\"prof\">\n");
      out.write("                                <form action=\"Forget_pass2\">\n");
      out.write("                                    <div  id=\"proff\"> \n");
      out.write("\n");
      out.write("                                        <center>   \n");
      out.write("                                           <pre>\n");
      out.write("                                       <select style=\"width:300px; font-size: 20px\" name=\"question\"> \n");
      out.write("                                        ");

                                            for(int i=0;i<HTMLD.size();i++)
                                            {
                                                
      out.write("\n");
      out.write("                                                ");
      out.print(HTMLD.get(i));
      out.write("\n");
      out.write("                                                ");

                                            }
                                          
      out.write("\n");
      out.write("                                    </select>  </pre>\n");
      out.write("                                        <pre>\n");
      out.write("                                        <label style=\"font-size: 20px\" for=\"Answer\" class=\"top\" >Answer :  </label>  \n");
      out.write("                                        <input type=\"text\" id=\"Answer\" name=\"Answer\" placeholder=\"Answer\" title=\"please enter your Last name\"  required class=\"Input\" pattern=\"[A-Za-z ]{3,}\">\n");
      out.write("                                        </pre>\n");
      out.write("                                        <pre>\n");
      out.write("                                        <label style=\"font-size: 20px\"class=\"top\" for=\"Email\" >Email : </label>  \n");
      out.write("                                        <input type=\"email\" id=\"Email\" name=\"Email\"placeholder=\"Email\"  required class=\"Input\" pattern=\"[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\"  title=\"please enter Employee email\">\n");
      out.write("                                        </pre>\n");
      out.write("                                        \n");
      out.write("                                            <br>\n");
      out.write("                                            </div>\n");
      out.write("                                            <hr class=\"in2\">  \n");
      out.write("                                            <a> <input id=\"info\"  name=\"Button\" type=\"submit\" value=\"Submit\"></a>\t\n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                            </div><!-- /col-lg-9 END SECTION MIDDLE -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
