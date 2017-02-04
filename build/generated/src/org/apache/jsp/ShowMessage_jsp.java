package org.apache.jsp;

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
      out.write(" <script>\n");
      out.write("    (function displaymasseg()\n");
      out.write("                {\n");
      out.write("                    var xmlhttp;\n");
      out.write("                    if (window.XMLHttpRequest)\n");
      out.write("                    {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                    xmlhttp=new XMLHttpRequest();\n");
      out.write("                    }\n");
      out.write("                  else\n");
      out.write("                    {// code for IE6, IE5\n");
      out.write("                    xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    xmlhttp.onreadystatechange= function ()\n");
      out.write("                    {\n");
      out.write("                    if (xmlhttp.readyState==4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("                    var jsonarr = JSON.parse(xmlhttp.responseText);\n");
      out.write("                    var sender = document.getElementById(\"sender\");\n");
      out.write("                    sender.innerHTML = jsonarr[0].sendername;\n");
      out.write("                    var Date = document.getElementById(\"date\");\n");
      out.write("                    Date.innerHTML =jsonarr[0].date;\n");
      out.write("                    var Time = document.getElementById(\"time\");\n");
      out.write("                    Time.innerHTML = jsonarr[0].time;\n");
      out.write("                    var content = document.getElementById(\"content\");\n");
      out.write("                    content.innerHTML = jsonarr[0].content;\n");
      out.write("                    var em = \"\";\n");
      out.write("                    var div = document.getElementById(\"commints\");\n");
      out.write("                    for(var i in jsonarr)\n");
      out.write("                    {\n");
      out.write("                        var item = jsonarr[i+1];\n");
      out.write("                        em +=\"sender : <h4 class=\\\"om\\\">\"+item.comSendername+\"</h4>   Time : <h4 class=\\\"om\\\">\"+item.comtime+\"</h4>  Date : <h4 class=\\\"om\\\">\"+item.comdate+\"</h4> \"\n");
      out.write("                           +\"<textarea readonly class=\\\"la\\\" cols=\\\"20\\\" rows=\\\"2\\\" style=\\\"width: 400px;\\\" >\"+item.concontent+\"</textarea></br><br>\"        \n");
      out.write("                    }\n");
      out.write("                    div.innerHTML = em;\n");
      out.write("                }\n");
      out.write("             };\n");
      out.write("        var ss  = \"num=3\";\n");
      out.write("        xmlhttp.open(\"POST\",\"ShowAll?\"+ss,true);\n");
      out.write("        xmlhttp.send();                   \n");
      out.write("   })();\n");
      out.write("                \n");
      out.write("            </script>\n");
      out.write("            <style>\n");
      out.write("                .om\n");
      out.write("                {\n");
      out.write("                    display: inline;\n");
      out.write("                    margin-right: 20px;\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("                        <div class=\"col-lg-9 main-chart\">\n");
      out.write("                            <div style=\"display: inline\">\n");
      out.write("                                Sender : <h3 style=\"width: 250px; display: inline;\" id=\"sender\">  </h3><br>\n");
      out.write("                                Time : <h4 style=\"width: 250px; display: inline; margin-right: 50px;\" id=\"time\"> </h4>\n");
      out.write("                                Date : <h4 style=\"width: 250px;  display: inline;\" id=\"date\">  </h4>\n");
      out.write("                            \n");
      out.write("                            </div>  \n");
      out.write("                            \n");
      out.write("                                <textarea id=\"content\" readonly class=\"la\" name=\"complain\"  cols=\"25\" rows=\"10\" style=\"width: 600px;\" ></textarea></br><br>\n");
      out.write("                                <div id=\"commints\">                          \n");
      out.write("                                </div>\n");
      out.write("                                <textarea id=\"content\" placeholder=\"Enter Your Replaied\" class=\"la\" cols=\"20\" rows=\"2\" style=\"width: 400px;\" ></textarea></br><br>    \n");
      out.write("                                <input class=\"se\" type=\"button\"  onclick=\"location.href='SendingMassage.jsp';\" value=\"replay\"/>\n");
      out.write("                        </div><!-- /col-lg-9 END SECTION MIDDLE -->\n");
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
