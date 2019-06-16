package org.apache.jsp.Files.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.*;
import java.sql.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String admin=Utility.parse1(request.getAttribute("admin"));
	System.out.println("In profile.jsp admin value issss "+admin);
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String adminid="",name="",add="",email="",phone="";
	if(no==0)
	while(rs.next())
	{
		id=rs.getInt(1);
		adminid=rs.getString(4);
		name=rs.getString(2);
		add=rs.getString(5);
		email=rs.getString(7);
		phone=rs.getString(6);
	}

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/JS/style.js\"></script>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("table, tr, td\r\n");
      out.write("th, td\r\n");
      out.write("{\r\n");
      out.write("padding:8px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\t\t");

			if(no==1)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t\t\t<p>Opp's,Seems something went wrong ..!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

			}
			if(no==0)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"button_example\" href=\"");
      out.print(request.getContextPath() );
      out.write("/EditProfile1?name=");
      out.print(admin);
      out.write("&no=1\" target=\"afrm\">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<a class=\"button_example\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ChangePass1?name=");
      out.print(admin);
      out.write("&no=1&id=");
      out.print(id );
      out.write("\" target=\"afrm\">Change Password</a>\r\n");
      out.write("\t\t\t\t\t<br></br>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<table  style=\"width: 100px ; color: black; font-weight: bold;\";>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>ID No : </td><td>");
      out.print(id );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>Name : </td><td>");
      out.print(name );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>User Id: </td><td>");
      out.print(adminid );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>Mail Id: </td><td>");
      out.print(email);
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>Cell No: </td><td>");
      out.print(phone );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td>Address: </td><td>");
      out.print(add);
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div></center>\r\n");
      out.write("\t\t\t\t");

				if(Utility.parse(request.getParameter("no1"))==1)
				{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t\t\t\t<p>Your profile updated successfully ..!</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");

				}
			}
		
      out.write("\r\n");
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
