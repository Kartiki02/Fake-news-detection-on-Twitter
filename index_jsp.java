package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t\n");
      out.write("<title>Fake News Detection </title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"bootloader.css\">\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t(function() {\n");
      out.write("\t\n");
      out.write("\tvar loading = 0;\n");
      out.write("\tvar id = setInterval(keepLoading,60);\n");
      out.write("\n");
      out.write("\tfunction keepLoading()\n");
      out.write("\t{\n");
      out.write("\t\tif(loading == 100)\n");
      out.write("\t\t{\n");
      out.write("\t\t\tclearInterval(id);\n");
      out.write("\t\t\t// alert(\"Check !!\")\n");
      out.write("\t\t\t//var MyWindow=window.open(\"http://localhost:8080/Socio/index.jsp\",\"myAdWin\",\"_self\");\n");
      out.write("\t\t\twindow.location = \"http://localhost:8080/Socio/Home.jsp\"\n");
      out.write("\t\t}\n");
      out.write("\t\telse\n");
      out.write("\t\t{\n");
      out.write("\t\t\tloading = loading +1;\n");
      out.write("\t\t\tif(loading == 90)\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\tdocument.getElementById('backframe').style.animation = \"fadeout 1s ease\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("})();3\n");
      out.write("\t</script>\n");
      out.write("\t</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div id=\"backframe\">\n");
      out.write("\t<div class=\"title\">\n");
      out.write("\t\t<strong style=\"font-family:raleway; color: #fff\">FAKE \n");
      out.write("\t\t\t<span style=\"color: #5cb85c;\">NEWS DETECTION</span>\n");
      out.write("\t\t</strong>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"preloader\">\n");
      out.write("\t\t<div class=\"box1\"></div>\n");
      out.write("\t\t<div class=\"box2\"></div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
