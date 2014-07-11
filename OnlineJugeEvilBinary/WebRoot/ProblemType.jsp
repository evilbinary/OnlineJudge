<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProblemType.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	 
  	<div class="problem_type">
  		<div class="problem_type_head">
  			题目类型
  		</div>
     <%
     	ProblemManager problemManager=new ProblemManager();
     	Vector<String> types=problemManager.getAllProblemType(); 
     	if(types==null)
     		return;
     	for(int i=0;i<types.size();i++){
     		String tmp=(String)types.get(i);
   		%>
   		<div class="problem_type_item">
   			<a href="ProblemServlet?action=listProblem&problemType=<%= tmp%>"><%= tmp%></a>
   		</div>
   		<%
     	}
     %>
     </div>
     
     <div class="problem_type">
  		<div class="problem_type_head">
  			题目类型
  		</div>
     <%
     	 
     	 types=problemManager.getAllProblemType(); 
     	if(types==null)
     		return;
     	for(int i=0;i<types.size();i++){
     		String tmp=(String)types.get(i);
   		%>
   		<div class="problem_type_item">
   			<a href="ProblemServlet?action=listProblem&problemType=<%= tmp%>"><%= tmp%></a>
   		</div>
   		<%
     	}
     %>
     </div>
     
     <div class="problem_type">
  		<div class="problem_type_head">
  			公告
  		</div>
     <%
     	 
     	types=problemManager.getAllProblemType(); 
     	if(types==null)
     		return;
     	for(int i=0;i<types.size();i++){
     		String tmp=(String)types.get(i);
   		%>
   		<div class="problem_type_item">
   			<a href="ProblemServlet?action=listProblem&problemType=<%= tmp%>"><%= tmp%></a>
   		</div>
   		<%
     	}
     %>
     </div>
     
     
  </body>
</html>
