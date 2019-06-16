<%@ page import="com.util.*"%>

<html>
<head>
<%
//int no=Utility.parse(request.getParameter("no"));
%>
<link href="<%=request.getContextPath()%>/Files/CSS/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/message.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Files/CSS/login.css"
	type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/Files/JS/style.js"></script>
	
	

<link href="login-box.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/logins.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/popup.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
	



</head>

<body   onload="startTimer()" >
<div 	style="position: centre;  left: -10px;"	>
	<img src="<%=request.getContextPath()%>/Files/Images/tt.png" width=100%></img>  
</div> 

<div style="padding: 20px 0 0 250px;">

<form class="login" action="<%=request.getContextPath()%>/UserLogin"
				method="post">
<div id="login-box">

<H2>User Login</H2>
<br />
<br />
<div id="login-box-name" style="margin-top:20px;">UserName:</div><div id="login-box-field" style="margin-top:20px;"><input name="name" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name">Password:</div><div id="login-box-field"><input name="pass" type="password" class="form-login" title="Pass" value="" size="30" maxlength="2048" /></div>
<br />
<%-- <span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span> --%>
<br />
<br />
<center>
<input type="submit" name="submit" value="submit"/>

<a href="<%=request.getContextPath() %>/index.jsp">Admin  </a>
</center>



</div>
</form>







	<%-- <!-- Admin Login Pop Up -->


	 <div id="overlay"> 

		 <div id="popup"> 
			<a href=""> <img class="close_button" src="<%=request.getContextPath() %>/Files/Images/close.jpg"height="50"
				width="50" /></a>

			<form class="login" action="<%=request.getContextPath()%>/AdminLogin"
				method="post">

				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: blue;">ADMIN LOGIN</font></label>
				</center>
				<br> <label><font style="color: brown;">AdminID</font></label>&nbsp;&nbsp; <input type="text" tabindex="1" class="input"
					placeholder="Admin Id" name="name" required><br> <br>

				<label><font style="color: BROWN;">Password</font></label> <input
					type="password" class="input" tabindex="2" name="pass"
					placeholder="Password" required><br> <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login.png"alt="submit Button"
					class="gradientbuttons"
					width="80" height="80">
			</form>
		 </div> 

 </div> 

	<!-- User Login Pop Up -->

	<div id="overlay_signup">
		<div id="popup">
			<a href=""><img class="close_button" src="<%=request.getContextPath() %>/Files/Images/close.jpg"height="50"
				width="50" /></a>

			<form class="login" action="<%=request.getContextPath()%>/UserLogin"
				method="post">
				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: blue;">USER LOGIN</font></label>
				</center>
				<br> <label><font style="color: brown;">UserID</font></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
					tabindex="1" class="input" name="name" placeholder="User Id"
					required><br> <br> <label><font
					style="color: BROWN;">Password</font></label><input type="password"
					class="input" tabindex="2" name="pass" placeholder="Password"
					required><br> <br> <br>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login.png" alt="submit Button"
					 class="gradientbuttons"
					width="80" height="80">&nbsp;&nbsp;&nbsp;&nbsp; 
				
			</form>
		</div>
	</div> --%>

	<!-- Tpa Login Pop Up -->
	<!--  <div id="overlay-tpa">

		<div id="popup">
			<a href=""> <img class="close_button" src="<%=request.getContextPath() %>/Files/Images/close.png" height="50"
			width="50"/></a>

			<form class="login" action="<%=request.getContextPath()%>/AuditorLogin"
				method="post">

				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">Auditor's
							Login</font></label>
				</center>
				<br> <label><font style="color: #336633;">Auditor's Id</font></label>&nbsp;&nbsp;
				<input type="text" tabindex="1" class="input" placeholder="Tpa Id"
					name="name" required><br> <br> <label><font
					style="color: #336633;">Password</font></label> <input type="password"
					class="input" tabindex="2" name="pass" placeholder="Password"
					required><br> <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login.png" alt="submit Button"
					 class="gradientbuttons"
					width="80" height="80">
			</form>
		</div></div>-->
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<%
		int noo=Utility.parse(request.getParameter("no"));
		if(noo==1)
{
	%>
		
			<div class="error" id="message" style="height: 65; width: 250px; top:180" >	
			<p>Opp's,your Id or password is wrong ..!</p>
		</div>
			
	<%
}
		%>
</body>
</html>