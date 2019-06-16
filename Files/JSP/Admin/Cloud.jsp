<%@ page import="java.sql.*" %>
<%@ page import="com.util.*" %>
<html>
<%
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int count=1;
%>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
</head>
<body onload="startTimer()">
<form action="<%=request.getContextPath() %>/CloudList">
<!-- <input type="submit" name="submit" value="Add" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="Edit" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="Delete" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp; -->
	<table id="results"  class="tab" style="color: black">
	<tr>
		 <th></th> 
		 
		 <th>Select</th>
		<th>ID</th>
		<th>URL</th>
		<th>Folder</th>
		<th>Login_Id</th>
		<th>Password</th>
		
	</tr>
	<%
		while(rs.next())
		{%>
			<tr>
				 <td><%=count++ %></td>
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td> 
				         <td><%=rs.getInt(1) %></td>
				        <td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
						<td><%=rs.getString(4) %></td>
						<td><%=rs.getString(5) %></td>
						
						
			</tr>
		<%}
	%>
</table>
</form>
<!-- <!-- <div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //</script> -->
<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
    		<p>User Added Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==-1)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select atleast one.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>User Deleted Successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==4)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's Select only one user to edit....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>User Updated Successfully....!</p>
		</div>			
	<%}if(Utility.parse(request.getParameter("no"))==6)
	{%>
	<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
		<p>Sorry more than one user should be in one group....!</p>
	</div>			
<%}if(Utility.parse(request.getParameter("no"))==7)
{%>
<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
	<p>User Deleted and Key Changed successfully....!</p>
</div>			
<%}
%>		
</body>
</html>