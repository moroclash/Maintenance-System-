package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Show_005fAll_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   <html>\n");
      out.write("            ");

               HttpSession ss = request.getSession();
               String list = (String) ss.getAttribute("listhtml");
               String nav = (String) ss.getAttribute("nav");
               String notificationList = (String) ss.getAttribute("NotificationList");
               String footer = (String) ss.getAttribute("footer");
               String head = (String) ss.getAttribute("head");
               String afterlist = (String) ss.getAttribute("afterlist");
               String Html = (String) ss.getAttribute("html");
            
      out.write("\n");
      out.write("    <head>\n");
      out.write("           ");
      out.print(head);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            ");
      out.print(nav);
      out.write("\n");
      out.write("            ");
      out.print(list);
      out.write("           \n");
      out.write("            ");
//=Html
      out.write("\n");
      out.write("             <!--main content start-->\n");
      out.write("            <section id=\"main-content\">\n");
      out.write("                <section class=\"wrapper\">\n");
      out.write("                    <h3 id=\"FunName\"><i class=\"fa fa-angle-right\" >Orders</i></h3>\n");
      out.write("                    <div class=\"row mt\">\n");
      out.write("                        <div style=\"margin-left: 60px;\">Show State : <select id=\"select\" onchange=\"OrderState()\"><option value=\"2\">Done</option><option value=\"3\">Wait_fix</option><option value=\"10\">reterned_order</option><option value=\"9\">Cancel</option></select></div>  \n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"content-panel\">\n");
      out.write("                                <h4><i class=\"fa fa-angle-right\" id=\"tabelname\"></i>Order</h4>\n");
      out.write("                                <section id=\"unseen\">\n");
      out.write("                                    <table class=\"table table-bordered table-striped table-condensed\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>ID</th> \n");
      out.write("                                                <th>Date_start</th>\n");
      out.write("                                                <th>Date_End</th>\n");
      out.write("                                                <th class=\"numeric\">Tecnical_ID</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <thead id=\"table\"></thead>\n");
      out.write("                                        </thead>\n");
      out.write("                                    </table>\n");
      out.write("                                </section>\n");
      out.write("                            </div><!-- /content-panel -->\n");
      out.write("                        </div><!-- /col-lg-4 -->\t\t\t\n");
      out.write("                    </div><!-- /row -->  \n");
      out.write("                </section>\n");
      out.write("            </section><!-- /MAIN CONTENT -->\n");
      out.write("            ");
      out.print(footer);
      out.write(" \n");
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
