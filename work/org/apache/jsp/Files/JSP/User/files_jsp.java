package org.apache.jsp.Files.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.util.*;

public final class files_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");

	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String name=Utility.parse1(request.getParameter("name")); 
	int count=1;

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/message.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/trans.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/login.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/button.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/JS/pagination.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/UploadFile\">\r\n");
      out.write("<input type=\"hidden\" name=\"name\" value=\"");
      out.print(name );
      out.write("\"/>\r\n");
      out.write("<input type=\"submit\"  name=\"submit\" value=\"Upload\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" style=\"top: 1000 ; right:100; width: 800 ; color: black\";>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th>FileId</th>\r\n");
      out.write("\t\t<th>UserId</th>\r\n");
      out.write("\t\t<th>File_Name</th>\r\n");
      out.write("\t\t<th>Date</th>\r\n");
      out.write("\t\t<th>Time</th>\r\n");
      out.write("\t\t<th>Day</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(count++ );
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getInt(8) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(9) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(10) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(11) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"cursor:hand\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results', 3); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");

	if(Utility.parse(request.getParameter("no"))==2)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("    \t\t<p>File Uploaded Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==1)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"tab1\" style=\"position:absolute;top:250px;left:410px\">\t\r\n");
      out.write("\t\t\t<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/UploadToCloud?name=");
      out.print(name );
      out.write("\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"file\" name=\"file\" class=\"field\" required=\"true\"></input><br></br>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"Upload File\" class=\"button\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"error\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Opp's select atleast one to delete.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==4)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>File Deleted Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==5)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"error\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Network problem.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"error\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Downloaded Successfully</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==7)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"error\" id=\"message\" style=\"height: 80;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Some blocks of file are already exists in the cloud</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	

      out.write("\t\t\r\n");
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
