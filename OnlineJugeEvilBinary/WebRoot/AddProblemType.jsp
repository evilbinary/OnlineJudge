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

		<title>My JSP 'AddProblemType.jsp' starting page</title>

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
		<form method="post" action="ProblemServlet?action=addProblemType"
			name="form1">
			 
			<input type="text" name="problemType"><input type="submit" value="添加题目类型" name="button1"><br>
			<br>所有题目类型<br><br>
			<%
				ProblemManager problemManager=new ProblemManager();
		     	Vector<String> types=problemManager.getAllProblemType(); 
		     	if(types==null)
		     		return;
		     	for(int i=0;i<types.size();i++){
		     		String tmp=(String)types.get(i);
			 %>
			 		
			 		<%=tmp %>&nbsp;&nbsp;<a href="">删除</a> <a href="">修改</a>     
			 		<a href="">查看此类型所有题目</a><br>
			 <%
			 	}
			  %>
			<br>
		</form>
	</body>
</html>
