<%@ page import="com.DAOFactory.*"%>
<%@ page import="java.sql.*"%>
<html>
<%
	DAOFactory factory=new DAOFactory();
	DAO dao=factory.getInstance("Auditor");
	ResultSet rs=dao.getUsers();
	
%>
<head>

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/Files/CSS/button.css"
	type="text/css" />
</head>
<body>
	<%
		if(rs!=null)
			while(rs.next())
			{
				%>
	<a id="a1" class="button_example"
		href="<%=request.getContextPath() %>/Trans?submit=get1&name=<%=rs.getString(2) %>"
		target="v2"><%=rs.getString(2) %></a>&nbsp;
	<%
			}
	%>


</body>
</html>