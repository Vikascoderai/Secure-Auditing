package org.apache.jsp.Files.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<html>\r\n");

	String user=request.getAttribute("user").toString();
	System.out.println("user name isss "+user);

      out.write("\r\n");
      out.write("<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("javascript:window.history.forward(-1);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/style.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/button.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/tt.png\"\r\n");
      out.write("\t\twidth=\"1000px\" height=\"80px\" alt=\"\"></img>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"position: absolute; top: 100px; left: 100px;\">\r\n");
      out.write("\t\t <br>\r\n");
      out.write("\t\t<br /> <a class=\"button_example\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/UserProfile?name=");
      out.print(user );
      out.write("\"\r\n");
      out.write("\t\t\ttarget=\"afrm\">&nbsp;Show Profile &nbsp;</a> <a\r\n");
      out.write("\t\t\tclass=\"button_example\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/UploadFile?name=");
      out.print(user );
      out.write("&amp;submit=get\"\r\n");
      out.write("\t\t\ttarget=\"afrm\">&nbsp;Upload File &nbsp;&nbsp;</a> <a\r\n");
      out.write("\t\t\tclass=\"button_example\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/DownloadFile?name=");
      out.print(user );
      out.write("&amp;submit=get\"\r\n");
      out.write("\t\t\ttarget=\"afrm\">Download File</a> <a class=\"button_example\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/Trans?name=");
      out.print(user);
      out.write("\"\r\n");
      out.write("\t\t\ttarget=\"afrm\">&nbsp;Transactions</a> <a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!--   <a class=\"button_example\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/AuditRequest?name=");
      out.print(user);
      out.write("\"\r\n");
      out.write("\t\t\ttarget=\"afrm\">&nbsp;Send Request &nbsp;</a><br></br> <a> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<a class=\"button_example\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/JSP/User/logout.jsp?name=");
      out.print(user );
      out.write("\">&nbsp;&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<font\r\n");
      out.write("\t\t\tstyle='font-family: Monotype Corsiva; font-size: 25px; color: purple;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome\r\n");
      out.write("\t\t\t");
      out.print(user );
      out.write("</font>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"position: absolute; top:180px; left: 50px;\">\r\n");
      out.write("\t\t<iframe frameborder=\"0\" scrolling=\"auto\" name=\"afrm\" top=\"300px\" height=\"450\" \r\n");
      out.write("\t\t\twidth=\"900\"></iframe>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
