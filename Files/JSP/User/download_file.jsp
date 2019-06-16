
<%@page import="java.sql.ResultSet"%>
<%@page import="com.util.*"%>
<%@page import="com.DAOFactory.*"%>
<html>
<head>

	<link href="<%=request.getContextPath() %>/Files/CSS/message.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/pagination.js"></script>

</head>
<body onload="startTimer()">

<%
    int no=Utility.parse(request.getParameter("no"));

	String userid=(String)session.getAttribute("userid");
	
	System.out.println("User Id :"+userid);
    
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,cloudId=0,owner_id=0;
	String fileName="",fileTypes="",username="",date = "";

	username = session.getAttribute("userid").toString();
	if(no==0)
	{
%>	

<div style="top:30px;left:10px;width: 600px;height: 300px;">
			
<p>

	<table id="results" cellpadding="5px" cellspacing="4px" width="600px">
		
		<tr>
			
			<td colspan="6" align="center">
				<font color=White size="8">Available Files To Download</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th><font color="red">FileId</font></th>
			<th><font color="red">File Name</font></th>
			<th><font color="red">Date&nbsp;&nbsp;&nbsp;&nbsp; Time</font></th>
			<th><font color="red">Download</font></th>
		</tr>
	
<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			fileName=rs.getString(2);
			fileTypes=rs.getString(3);
			date=rs.getString(4);
		
%>
			<tr align="center">
						<td><font color="white" ><%=id%></font></td>
						<td><font color="white" ><%=fileName%></font></td>
						<td><font color="white" ><%=date%></font></td>
						<td><a href="<%=request.getContextPath() %>/Download?fileId=<%=id%>& userid=<%=userid%>&no=1">
						<img src="<%=request.getContextPath()%>/Files/Images/download-button.png" height="36" width="90" ></a></td>
						
			</tr>
<%
		}
    
}
%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:relative;top:30px;left:75px;cursor:hand; color: #fedcba"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
    

<% 	
if(Utility.parse(request.getParameter("no1"))==1)
{
	%>
		<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
			<p>Sorry,Same File Is Already On The Cloud.</p>
		</div>
	<%
}


	
}
	if(Utility.parse(request.getParameter("no"))==1)
	{
		
     String file_name = request.getParameter("fname");	
     String downloadedFrom = request.getParameter("dfrom");
%>

	<div id="a2" style="position:absolute;top:40px;left:25" class="c">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="green" style="font-style: bold" size="5">File Download Acknowledgement</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		
		<tr  bgcolor="#A9D2FB" align="center">
		
		    <td colspan="3" align="center"><pre><font color="green">Your File has been Downloaded Successfully......</font></pre></td>
		    
	    </tr>
	    
	    <tr  bgcolor="#A9D2FB" align="center">
		
		    <td><pre><font color="white">File Name</font></pre></td>
		    <td>:</td>
		    <td><%= file_name %></td>
		    
	    </tr>
	    <tr  bgcolor="#A9D2FB" align="center">
		
		    <td><pre><font color="white">File Downloaded From </font></pre></td>
		    <td>:</td>
		    <td><%= downloadedFrom %></td>
		    
	    </tr>
	    
	     <tr  bgcolor="#A9D2FB" align="center">
		
		    <td><pre><font color="white">Date </font></pre></td>
		    <td>:</td>
		    <td><%= Utility.getDate()%> &nbsp;&nbsp;<%= Utility.getTime()%></td>
		    
	    </tr>
	    
	</table>
	</div>

<%
} 
  if(Utility.parse(request.getParameter("no"))==3)
	{
    
%>

	<div id="a2" style="position:absolute;top:40px;left:50" class="c">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="green" style="font-style: bold" size="5">File Download Acknowledgement</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		
		<tr  bgcolor="#A9D2FB" align="center">
		
		    <td colspan="3" align="center"><pre><font color="red">Sorry Download Process Failed.</font></pre></td>
		    
	    </tr>
	    
	    <tr  bgcolor="#A9D2FB" align="center">
		
		    <td colspan="3" align="center"><pre><font color="red">Something Went Wrong,Try IT Again....</font></pre></td>
		    
	    </tr>
  
	</table>
	</div>

<%
} 
%>

</body>
</html>


