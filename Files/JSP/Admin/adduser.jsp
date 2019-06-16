<%@ page import="com.util.*"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<link href="<%=request.getContextPath() %>/Files/CSS/message.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/Files/CSS/login.css"
	type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
<link href="<%=request.getContextPath()%>/Files/CSS/styles.css"
	rel="stylesheet" type="text/css" />
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
</head>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/secure_auditing","root", "admin");
    Statement st = con.createStatement();
    ResultSet rs=st.executeQuery("select * from userlogin");
    
    %>
<body onload="startTimer()">

	<!-- User Register Pop Up -->

	<div >
		<div id="popup" style="height: 400px; width: 600px; padding: 10px; background-color: #00CCFF">

			

			<form action="<%=request.getContextPath() %>/UserList">
				<input type="hidden" name="submit" value="Add"></input> <input
					type="hidden" name="add1" value="YES"></input>


				<div style="position: absolute; top: 30px; left: 50px;">
				
				<center><label><font style="font-family: Monotype Corsiva; font-size: 35px; color:blue;">User
										Registration</font></label></center><br></br>
					<table style="width: 130">
						
						
						
						
						<tr>
							<td><label><font style="color: maroon;font-weight: bold;">UserId</font></label></td>
							<td><input type="text" tabindex="1" name="id" class="input" placeholder="User Id"
								required></td>
								<td> <label><font style="color: maroon;font-weight: bold;">Password</font></label></td>
								<td> <input type="password" class="input" name="pass" tabindex="2"
								placeholder="Password" required></td>
						</tr>
						
						<tr>
							<td><label><font style="color: maroon;font-weight: bold;">User Name</font></label> </td><td>
							<input type="text" tabindex="1" class="input" name="name"
								placeholder="User Name" required></td>
								
								<td> <label><font style="color: maroon;font-weight: bold;">Gender</font></label></td>
								<td> <input name="gender" value="Male"
								type="radio" checked="true" /> Male<input
								name="gender" value="Female" type="radio" />Female</td>
						</tr>
						

						<tr>
							<td><label><font style="color: maroon;font-weight: bold;">Address</font></label>
								</td><td> <input type="text"
								tabindex="1" name="add" class="input" placeholder="Address"
								required></td><td> <label><font
									style="color: maroon;font-weight: bold;">City</font></label>
								</td><td>
								<input type="text" class="input" tabindex="2" name="city"
								placeholder="City" required></td>
						</tr>
						

						<tr>
							<td><label><font style="color: maroon;font-weight: bold;">Email</font></label>
								</td><td>
								<input type="text" tabindex="1" class="input" name="email"
								placeholder="Email"
								pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" required>
								
								</td><td><label> <font style="color: maroon;font-weight: bold;">Phone</font></label>
								</td><td> <input type="text"
								class="input" tabindex="2" name="phone" placeholder="Phone"
								pattern="[7-9]{1}[0-9]{9}" minlength="10" maxlength="10" required></td>
						</tr>

						

						
</center>
					</table>
					<center>
					<input type="image" id="" value="register"src="<%=request.getContextPath() %>/Files/Images/register.png"
								alt="submit Button" width="80" height="30"></center>
				</div>

			</form>

		</div>
	</div>






	<%
			int no = Utility.parse(request.getParameter("no"));
			if (no == 1) {
		%>
	<div class="error" id="message">
		<p>Opp's,Invalid userid / password..!</p>
	</div>
	<%
			}
			if (no == 3) {
		%>
	<div class="error" id="message">
		<p>Opp's,Something went wrong ..!</p>
	</div>
	<%
			}
			if (no == 4) {
		%>
	<div class="success" id="message">
		<p>You have registered successfully!</p>
	</div>
	<%
			}
		%>
	</div>

	<%
			if (Utility.parse(request.getParameter("no1")) == 5) {
		%>
	<div class="error" id="message" style="position: absolute">
		<p>Sorry this user id is already exists.....!</p>
	</div>
	<%
			}
		%>
</body>
</html>