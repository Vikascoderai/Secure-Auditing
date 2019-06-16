<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath() %>/Files/CSS/message.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<%
int no=Utility.parse(request.getParameter("no"));
%>
</head>
<body>
<%
if(no==1)
{
	%>
		<div class="error" id="message">	
			<p>Network problem...!!!</p>
		</div>
	<%
}
%>
</body>
</html>