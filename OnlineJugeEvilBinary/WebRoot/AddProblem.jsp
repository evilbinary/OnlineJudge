<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

		<title>My JSP 'AddProblem.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body><br>
		<form method="post" action="ProblemServlet?action=addProblem"
			name="form1">
			<p style="text-align: left;">
				标题: 
			<input type="text" name="problemTitile">
			类型:<select name="type">
			<%
				ProblemManager problemManager=new ProblemManager();
     			Vector<String> types=problemManager.getAllProblemType(); 
     			if(types==null)
     				return;
     			for(int i=0;i<types.size();i++){
     			String tmp=(String)types.get(i);
			%>
				<option><%=tmp %></option>
				 
			<% }
			%>
			</select>
			</p>
			<p style="text-align: left;">
				<textarea name="problemContent"  rows="30" cols="100"></textarea>
			</p>
			 
			 
			<p style="text-align: left;">
				&nbsp;
				<input type="submit" value="确认添加" name="button1">
			</p>
		</form>
	</body>
</html>
