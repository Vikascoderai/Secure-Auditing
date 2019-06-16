package org.apache.jsp.Files.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.util.*;

public final class integrity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("/DownloadFile\">\r\n");
      out.write("<input type=\"hidden\" name=\"name\" value=\"");
      out.print(name );
      out.write("\"/>\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Integrity\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<!--  <input type=\"submit\" name=\"submit\" value=\"Integrity\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;-->\r\n");
      out.write("<!--<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"button_example\" id=\"a1\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t-->\r\n");
      out.write("\t\t<table id=\"results\" class=\"tab\" style=\"width: 500 ; color: black\";>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Id</th>\r\n");
      out.write("\t\t<th width=30px ></th>\r\n");
      out.write("\t\t<th>Old_hashCode</th>\r\n");
      out.write("\t\t<th width=30px ></th>\r\n");
      out.write("\t\t<th>New_hashCode</th>\r\n");
      out.write("\t\t<th width=30px ></th>\r\n");
      out.write("\t\t<th>status</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td width=30px ></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td width=30px ></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(3) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td width=30px ></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(4) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"cursor:hand\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results', 5); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");

	if(Utility.parse(request.getParameter("no"))==2)
    {
      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>File Uploaded Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==1)
	{
      out.write("\r\n");
      out.write("\t\t<div class=\"tab1\" style=\"position:absolute;top:50px;left:510px\">\t\r\n");
      out.write("\t\t\t<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/UploadToCloud\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(name );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"file\" name=\"file\" class=\"field\" required=\"true\"></input><br></br>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"Upload File\" class=\"button\"></input>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
    {
      out.write("\r\n");
      out.write("    \t<div align=\"right\" class=\"error\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Opp's select atleast one to process.....!</p>\r\n");
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
      out.write("    \t<!-- <div class=\"error\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Network Problem.....!</p>\r\n");
      out.write("    \t</div>\t -->\t\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    alert('Some Content is missing may be data is hacked');\r\n");
      out.write("</script>\t\t\r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {
      out.write("\r\n");
      out.write("    \t<!-- <div class=\"success\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Downloaded Successfully</p>\r\n");
      out.write("    \t</div>\t -->\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    alert('Downloaded successfully');\r\n");
      out.write("</script>\t\t\r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==7)
    {
      out.write("\r\n");
      out.write("    \t<!-- <div class=\"success\" id=\"message\" style=\"height: 50;width: 250;\">\t\r\n");
      out.write("    \t\t<p>Downloaded Successfully</p>\r\n");
      out.write("    \t</div>\t -->\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    alert('Some Content is missing may be data is hacked');\r\n");
      out.write("</script>\t\t\r\n");
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
