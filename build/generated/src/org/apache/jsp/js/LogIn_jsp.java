package org.apache.jsp.js;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LogIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>DASHGUM - Bootstrap Admin Template</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css2/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <!--external css-->\n");
      out.write("        <link href=\"css2/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"css2/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css2/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- **********************************************************************************************************************************************************\n");
      out.write("        MAIN CONTENT\n");
      out.write("        *********************************************************************************************************************************************************** -->\n");
      out.write("\n");
      out.write("        <div id=\"login-page\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <form class=\"form-login\" action=\"LoginServlet\">\n");
      out.write("                    <h2 class=\"form-login-heading\">sign in now</h2>\n");
      out.write("                    <div class=\"login-wrap\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"User ID\" autofocus name=\"Email\">\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"Password\">\n");
      out.write("                        <label class=\"checkbox\">\n");
      out.write("                            <span class=\"pull-right\">\n");
      out.write("                                <a data-toggle=\"modal\" href=\"login.html#myModal\"> Forgot Password?</a>\n");
      out.write("\n");
      out.write("                            </span>\n");
      out.write("                        </label>\n");
      out.write("                        <button class=\"btn btn-theme btn-block\" href=\"index.html\" type=\"submit\"><i class=\"fa fa-lock\"></i> SIGN IN</button>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("                        <div class=\"login-social-link centered\">\n");
      out.write("                            <p>or you can sign in via your social network</p>\n");
      out.write("                            <button class=\"btn btn-facebook\" type=\"submit\"><i class=\"fa fa-facebook\"></i> Facebook</button>\n");
      out.write("                            <button class=\"btn btn-twitter\" type=\"submit\"><i class=\"fa fa-twitter\"></i> Twitter</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"registration\">\n");
      out.write("                            Don't have an account yet?<br/>\n");
      out.write("                            <a class=\"\" href=\"#\">\n");
      out.write("                                Create an account\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Modal -->\n");
      out.write("                    <div aria-hidden=\"true\" aria-labelledby=\"myModalLabel\" role=\"dialog\" tabindex=\"-1\" id=\"myModal\" class=\"modal fade\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                    <h4 class=\"modal-title\">Forgot Password ?</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <p>Enter your e-mail address below to reset your password.</p>\n");
      out.write("                                    <input type=\"text\" name=\"email\" placeholder=\"Email\" autocomplete=\"off\" class=\"form-control placeholder-no-fix\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button data-dismiss=\"modal\" class=\"btn btn-default\" type=\"button\">Cancel</button>\n");
      out.write("                                    <button class=\"btn btn-theme\" type=\"button\">Submit</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- modal -->\n");
      out.write("\n");
      out.write("                </form>\t  \t\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- js placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"assets/js/jquery.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!--BACKSTRETCH-->\n");
      out.write("        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/js/jquery.backstretch.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $.backstretch(\"assets/img/login-bg.jpg\", {speed: 500});\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
