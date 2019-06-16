<%@ page import="com.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String user=Utility.parse1(request.getAttribute("user"));
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String userid="",name="",gender="",add="",email="",phone="",city="";
	if(no==0)
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		gender=rs.getString(5);
		add=rs.getString(6);
		city=rs.getString(7);
		email=rs.getString(8);
		phone=rs.getString(9);
	}
%>
<head>
	
	<link href="<%=request.getContextPath() %>/Files/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Files/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
				<style>
table, tr, td
th, td
{
padding:8px;
}
</style>
</head>
<body onload="startTimer()">
		<%
			if(no==1)
			{
				%>
					<div class="error" id="message">	
						<p>Opp's,Seems something went wrong ..!</p>
					</div>
				<%
			}
			if(no==0)
			{
				%>
					<br>
					<center>
						<a class="button_example" href="<%=request.getContextPath() %>/EditProfile2?name=<%=user %>&no=1" target="afrm">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="button_example" href="<%=request.getContextPath() %>/ChangePass2?name=<%=user %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					<br></br>
					<div>
					<table style="width: 100px ; color: black;font-weight: bold;">
						<tr><td>ID No : </td><td><%=id %></td></tr>
						<tr><td>Name : </td><td><%=name %></td></tr>
						<tr><td>User ID: </td><td><%=userid %></td></tr>
						<tr><td>Mail ID: </td><td><%=email%></td></tr>
						<tr><td>Cell No: </td><td><%=phone %></td></tr>
						<tr><td>Address: </td><td><%=add%></td></tr>
					
						</table></div></center>
				<%
				if(Utility.parse(request.getParameter("no1"))==1)
				{
					%>
						<div class="success" id="message">	
							<p>Your profile updated successfully ..!</p>
						</div>
					<%
				}
			}
		%>
</body>
</html>