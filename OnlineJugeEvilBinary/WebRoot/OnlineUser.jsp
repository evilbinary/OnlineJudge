<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OnlineUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
  <table bgcolor="#ffffff" align=center>
	<tr>
		<td><div  id="lclock"></div></td>
	</tr>
</table>
		<SCRIPT language="JavaScript">
	<!--
	function webclock()
	{
	var dataobj=new Date()
	var hours=dataobj.getHours()
	var minutes=dataobj.getMinutes()
	var seconds=dataobj.getSeconds()
	
	if(minutes<=9)
	minutes="0"+minutes
	if(seconds<=9)
	seconds="0"+seconds
	myclock="<font size='7' color='#ff0000' face='Arial black'>"+hours+":"+minutes+":"+seconds+"</font>"
	lclock.innerHTML=myclock;
	setTimeout("webclock()",1000)
	}
	webclock();
	//-->
	</SCRIPT>
    <%
    try{
    	WebStateInfoManager webStateInfoManager=(WebStateInfoManager)application.getAttribute("webStateInfoManager");
    	Vector<String[]> userList=webStateInfoManager.getUserList();
    	Iterator ite=userList.iterator();
    	while(ite.hasNext()){
    		String[] u=(String[])ite.next();
    		String type="用户";
    		if("0".equals(u[2])){
    			type="管理员";
    		}
    		
    		%>
    		<%=type %>
    		<a href="UserServlet?action=viewUserBase&userId=<%= u[0]%>"><%= u[1]%></a><br>
    		<% 
    	}
    }catch(Exception e){
    	System.out.println(e.getMessage()+"OnlineUser");
    }
    %>
  </body>
</html>
