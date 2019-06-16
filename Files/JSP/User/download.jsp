<%@ page import="java.sql.*" %>
<%@ page import="com.util.*" %>
<html>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String name=Utility.parse1(request.getParameter("name")); 
	int count=1;
%>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/trans.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/login.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
</head>
<body onload="startTimer()">
<form action="<%=request.getContextPath() %>/DownloadFile">
<input type="hidden" name="name" value="<%=name %>"/>
<input type="submit" name="submit" value="Download" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="Integrity" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<!--<input type="submit" name="submit" value="Delete" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
		-->
		<table id="results" class="tab" style="width: 500 ; color: black";>
	<tr>
		<th>Select</th>
		<th>Id</th>
		<th>Name</th>
		<th>User id</th>
		<th>Date</th>
		<th>Day</th>
		<th>Time</th>
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr>
				<td><%=count++ %>&nbsp;&nbsp;&nbsp;
					<input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=rs.getInt(8) %></td>
				<td><%=rs.getString(9) %></td>
				<td><%=rs.getString(11) %></td>
				<td><%=rs.getString(10) %></td>
				
			</tr>
		<%}
	%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
<%
	if(Utility.parse(request.getParameter("no"))==2)
    {%>
    	<div class="success" id="message" style="height: 50;width: 250;">	
    		<p>File Uploaded Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==1)
	{%>
		<div class="tab1" style="position:absolute;top:50px;left:510px">	
			<form id="login" action="<%=request.getContextPath() %>/UploadToCloud" enctype="multipart/form-data" method="post">
				<input type="hidden" name="name" value="<%=name %>"/>
				<input type="file" name="file" class="field" required="true"></input><br></br>
				<input type="submit" name="Upload File" class="button"></input>
			</form>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
    {%>
    	<div align="right" class="error" id="message" style="height: 50;width: 250;">	
    		<p>Opp's select atleast one to process.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==4)
    {%>
    	<div class="success" id="message" style="height: 50;width: 250;">	
    		<p>File Deleted Successfully.....!</p>
    	</div>			
    <%}
	
	if(Utility.parse(request.getParameter("no"))==5)
    {%>
    	<!-- <div class="error" id="message" style="height: 50;width: 250;">	
    		<p>Network Problem.....!</p>
    	</div>	 -->	
    	<script type="text/javascript">
    alert('Some Content is missing may be data is hacked');
</script>		
    <%}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {%>
    	<!-- <div class="success" id="message" style="height: 50;width: 250;">	
    		<p>Downloaded Successfully</p>
    	</div>	 -->
    	<script type="text/javascript">
    alert('Downloaded successfully');
</script>		
    <%}
	
	if(Utility.parse(request.getParameter("no"))==7)
    {%>
    	<!-- <div class="success" id="message" style="height: 50;width: 250;">	
    		<p>Downloaded Successfully</p>
    	</div>	 -->
    	<script type="text/javascript">
    alert('Some Content is missing may be data is hacked');
</script>		
    <%}
	
%>		
</body>
</html>