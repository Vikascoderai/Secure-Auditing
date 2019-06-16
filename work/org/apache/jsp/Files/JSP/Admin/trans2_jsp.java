package org.apache.jsp.Files.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.DAOFactory.*;
import java.sql.*;

public final class trans2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	DAOFactory factory=new DAOFactory();
	DAO dao=factory.getInstance("Admin");
	ResultSet rs=dao.getUsers();
	

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/button.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/Trans1\" target=\"v2\">\r\n");
      out.write("\t\t<select name=\"name\" style=\"width:80;height: 30;color: #663300; background-color: #BCDCAB \">\r\n");
      out.write("\t\t<option>Select</option>\r\n");
      out.write("\t\t\t");

				while (rs.next()) {
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<option value=\"");
      out.print(rs.getString(2));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write(" </option>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Ok\" class=\"button_example\">\r\n");
      out.write("\r\n");
      out.write("\t</form>\t\r\n");
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
