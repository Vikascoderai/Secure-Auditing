<html>
<%
	String user=request.getAttribute("user").toString();
	System.out.println("user name isss "+user);
%>
<script language="JavaScript" type="text/javascript">
javascript:window.history.forward(-1);
</script>

<head>
<link href="<%=request.getContextPath() %>/Files/CSS/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/Files/CSS/button.css"
	type="text/css" />
</head>
<body>
	<img src="<%=request.getContextPath() %>/Files/Images/tt.png"
		width="1000px" height="80px" alt=""></img>


	<div style="position: absolute; top: 100px; left: 100px;">
		 <br>
		<br /> <a class="button_example"
			href="<%=request.getContextPath() %>/UserProfile?name=<%=user %>"
			target="afrm">&nbsp;Show Profile &nbsp;</a> <a
			class="button_example"
			href="<%=request.getContextPath() %>/UploadFile?name=<%=user %>&amp;submit=get"
			target="afrm">&nbsp;Upload File &nbsp;&nbsp;</a> <a
			class="button_example"
			href="<%=request.getContextPath() %>/DownloadFile?name=<%=user %>&amp;submit=get"
			target="afrm">Download File</a> <a class="button_example"
			href="<%=request.getContextPath() %>/Trans?name=<%=user%>"
			target="afrm">&nbsp;Transactions</a> <a>
			
			 
			
			<!--   <a class="button_example"
			href="<%=request.getContextPath() %>/AuditRequest?name=<%=user%>"
			target="afrm">&nbsp;Send Request &nbsp;</a><br></br> <a> -->
			
			
			
			<a class="button_example" href="<%=request.getContextPath() %>/Files/JSP/User/logout.jsp?name=<%=user %>">&nbsp;&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			
			<font
			style='font-family: Monotype Corsiva; font-size: 25px; color: purple;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome
			<%=user %></font>

	</div>


	<div style="position: absolute; top:180px; left: 50px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" top="300px" height="450" 
			width="900"></iframe>
	</div>
</body>
</html>