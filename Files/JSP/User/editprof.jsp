<%@ page import="com.util.*"%>
<%@ page import="java.sql.*"%>
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
<link href="<%=request.getContextPath() %>/Files/CSS/message.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/Files/CSS/button.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
<link href="<%=request.getContextPath()%>/Files/CSS/logins.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/popup.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js"
	type="text/javascript"></script>
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
	<div>
		<div id="popup" style="height: 400px; width: 600px; padding: 10px; background-color: #FFFFD1;">
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


			

			<form action="<%=request.getContextPath() %>/EditProfile2">
					<input type="hidden" name="user" value="<%=user %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<center>
				<table style="width: 100">
					
					<input type="submit" value="Save Updates" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="button_example" href="<%=request.getContextPath() %>/ChangePass2?name=<%=user %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					</center>
					
					<tr>
							<td align="center" colspan="5"><label><font
									style="font-family: Monotype Corsiva; font-size: 35px; color: blue;">Edit Your Details</font></label></td>
						</tr>



					
					<tr>
					<td><label><font style="color: maroon;font-weight: bold;">your
								Id</font></label></td>
								<td><input type="text"
						value="<%=id %>" tabindex="1" name="id" class="input"
						placeholder="User Id" readonly="readonly">&nbsp;&nbsp; 
						<label></td><td>
							<font style="color: maroon;font-weight: bold;">User's id</font>
					</label></td><td> <input type="text"  value="<%=userid %>" readonly
						class="input" name="name" required>&nbsp;&nbsp;</td>
					</tr>
					<br/>
					<tr>
						<td><label> <font style="color: maroon;font-weight: bold;">User
									Name</font></label></td><td> <input type="text" value="<%=name %>" 
							class="input" name="name" required>&nbsp;&nbsp;</td><td> <label><font
								style="color: maroon;font-weight: bold;">Address</font></label></td><td>
							 <input type="text"
							name="add" class="input" value="<%=add %>" required>&nbsp;&nbsp;
						</td>
					</tr>

					<tr>

						<td> <label><font style="color: maroon;font-weight: bold;">Email</font></label></td>
							
							<td><input type="text" tabindex="1" class="input" name="email"
							value="<%=email %>"
							pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" required>&nbsp;&nbsp;</td>
							
							<td>
							<label> <font style="color: maroon;font-weight: bold;">Phone</font></label></td>
							<td>
							 <input type="text"
							class="input"  name="phone" value="<%=phone %>"
							pattern="[7-9]{1}[0-9]{9}"
							required></td>
					</tr>
				</table>
		</div>

		</form>

	</div>
	
	<%
			}
		%>
</body>
</html>