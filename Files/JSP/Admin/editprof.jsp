<%@ page import="com.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String admin=Utility.parse1(request.getAttribute("admin"));
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
%>
<head>
	<link href="<%=request.getContextPath() %>/Files/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Files/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
	<link href="<%=request.getContextPath()%>/Files/CSS/logins.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Files/CSS/popup.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
	<style>
table, tr, td
th, td
{
padding:8px;
}

</style>
<style> 
#popup {

    box-shadow: 10px 10px 50px #1A1A14;
}
</style>
</head>
<body onload="startTimer()">
		<div >
		<div id="popup"  style="height: 400px; width: 600px; padding: 10px;background-color: #00CCFF; ">
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
		

			

				<form action="<%=request.getContextPath() %>/EditProfile1">
					<input type="hidden" name="admin" value="<%=admin %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div style="position: absolute; top: 30px; left: 50px;">
					<table style="width: 100">
					<center>
						<input type="submit" value="Save Updates" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<!--  	<a class="button_example" href="<%=request.getContextPath() %>/ChangePass1?name=<%=admin %>&no=1&id=<%=id %>" target="afrm">Change Password</a>-->
					</center><br></br>


				
						<tr>
							<td><label><font style="color: #00CCFF;font-weight: bold;">Id</font></label></td>
							<td> <input type="text" value="<%=id %>"
								tabindex="1" name="id" class="input" placeholder="User Id"
								readonly="readonly"></td><td>
								<label>
							<font style="color: maroon;font-weight: bold;">Admin Id</font></label></td><td>
							 <input type="text" value="<%=adminid %>" tabindex="1" class="input" name="name"
								 required>&nbsp;&nbsp;
						</td></tr>
					
					
						<tr>
						<td><label>
							<font style="color: maroon;font-weight: bold;">Admin Name</font></label></td><td>
							 <input type="text" value="<%=name %>" tabindex="1" class="input" name="name"
								 required></td><td>
								 <label><font style="color: maroon; font-weight: bold;">Address</font></label>
								</td><td><input type="text"
								tabindex="1" name="add" class="input" value="<%=add %>" 
								required>&nbsp;&nbsp; 
						</td>
						</tr>

						<tr>
							<td> <label><font style="color: maroon; font-weight: bold;">Email</font></label>
								</td><td>
								<input type="text" tabindex="1" class="input" name="email"
								value="<%=email %>" 
								pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" required></td><td>
								<label> <font style="color: maroon;font-weight: bold;">Phone</font></label>
								</td><td><input type="text"
								class="input" tabindex="2" name="phone" value="<%=phone %>"
								pattern="[7-9]{1}[0-9]{9}"
								required></td>
						</tr>

						

						
					</table>
				</div>

			</form>

		</div>
	</div>
				<%
			}
		%>
</body>
</html>