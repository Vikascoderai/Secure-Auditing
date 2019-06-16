package org.apache.jsp.Files.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.util.*;

public final class HashBlock_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int count=1;

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/message.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/contact.css\" type=\"text/css\"/>\r\n");
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
      out.write("/HashDetails\">\r\n");
      out.write("<!--  <input type=\"submit\" name=\"submit\" value=\"Add\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Edit\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;-->\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" style=\"color:black\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th>Hash ID</th>\r\n");
      out.write("\t\t<th>Hash Code</th>\r\n");
      out.write("\t\t<th>Block Name</th>\r\n");
      out.write("\t\t<th>Instance</th>\r\n");
      out.write("\t\t<th>Upload Status</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	   if(rs==null)
	   {
		   
	   }
	   else
	   {
		while(rs.next())
		{ 
		
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(count++);
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(3) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getInt(4) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(5) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
 } 
		}
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"cursor:hand\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results', 5); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("    \t\t<p>User Added Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==-1)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's something went wrong.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==2)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's select atleast one.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>User Deleted Successfully.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==4)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>Opp's Select only one user to edit....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==5)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t\t<p>User Updated Successfully....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}if(Utility.parse(request.getParameter("no"))==6)
	{
      out.write("\r\n");
      out.write("\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t\t<p>Sorry more than one user should be in one group....!</p>\r\n");
      out.write("\t</div>\t\t\t\r\n");
}if(Utility.parse(request.getParameter("no"))==7)
{
      out.write("\r\n");
      out.write("<div class=\"success\" id=\"message\" style=\"position:absolute;top:10px;left:300px\">\t\r\n");
      out.write("\t<p>User Deleted and Key Changed successfully....!</p>\r\n");
      out.write("</div>\t\t\t\r\n");
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
