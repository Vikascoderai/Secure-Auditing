<html>
<%
	String admin=request.getAttribute("admin").toString();
%>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	<link href="<%=request.getContextPath() %>/Files/CSS/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<link href="<%=request.getContextPath()%>/Files/CSS/styles.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Files/CSS/logins.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Files/CSS/popup.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
</head>
<body>
	 <img src="<%=request.getContextPath() %>/Files/Images/tt.png" width=1000px></img> 
	

<div style="position:absolute;top:170px;left:30px;">
	
	<a class="button_example" href="<%=request.getContextPath() %>/AdminProfile?name=<%=admin %>" target="afrm">Show Profile&nbsp;&nbsp;</a>
	<a class="button_example" href="<%=request.getContextPath() %>/UserList?submit=get" target="afrm">User Details&nbsp;&nbsp;</a>
 	<a class="button_example" href="<%=request.getContextPath() %>/CloudList?submit=get" target="afrm">Cloud Details</a> 
    <a class="button_example" href="<%=request.getContextPath() %>/HashDetails?submit=get" target="afrm">Hash Details&nbsp;&nbsp;</a>
	<a class="button_example" href="<%=request.getContextPath() %>/Trans1?submit=get" target="afrm">Transactions&nbsp;</a>
	<a class="button_example" href="<%=request.getContextPath() %>/index.jsp">&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
<font style="font-family: Monotype Corsiva; font-size: 20px; color:black;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome <%=admin %></font>
	
</div>		
	
	
	<div style="position:absolute;top:200px;left:-5px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="500" width="1000" style;>
		</iframe>
	</div>
</body>
</html>