package org.apache.jsp.lineicons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ShowMessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.print(afterlist);
      out.write("\n");
      out.write("            <!--your Html  *_* -->\n");
      out.write("            <section id=\"main-content\">\n");
      out.write("                <section class=\"wrapper\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-9 main-chart\">\n");
      out.write("                            <h2 id=\"sen\"> Sending Message  </h2>\n");
      out.write("                            <hr class=\"dd\">\n");
      out.write("                            <form id=\"tab\" action=\"#\" method=\"post\">\n");
      out.write("                                <br><label id=\"eee\" > ID: <input class=\"la\" type=\"text\" name=\"id\" placeholder=\"Enter Id\"/></label></br></br>\n");
      out.write("                                <textarea id=\"laa\" class=\"la\" name=\"complain\" cols=\"25\" rows=\"15\" ></textarea></br><br>\n");
      out.write("                                <input class=\"se\" type=\"submit\" value=\"sent\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div><!-- /col-lg-9 END SECTION MIDDLE -->\n");
      out.write("\n");
      out.write("<!-------------- ~_~ -->\n");
      out.write("            ");
      out.print(notificationList);
      out.write("               \n");
      out.write("            ");
      out.print(footer);
      out.write(" \n");
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
