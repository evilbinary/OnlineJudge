<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

		<title>My JSP 'ProblemOperator.jsp' starting page</title>

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
		<div>
			题目管理
			<ul>
				<li>
					<a href="ProblemServlet?action=viewProblem">查看题目</a>
				</li>
				<li>
					<a href="ProblemServlet?action=jmpToAddProblem">添加题目</a>
				</li>
				<li>
					<a href="ProblemServlet?action=jmpToModifyProblem">删除、修改</a>
				</li>
				
				 
				
			</ul>
			<br>
			类型管理
			<ul>
				<li>
					<a href="ProblemServlet?action=jmpToAddProblemType">添加类型</a>
				</li>
				<li>
					<a href="ProblemServlet?action=jmpToAddProblemType">删除、修改</a>
				</li>
			</ul>
			<br>
			 内存时间限制
			<ul>
				<li>
					<a href="">添加限制</a>
				</li>
				<li>
					<a href="">修改、删除</a>
				</li>
			</ul>
			<br>
			 用户管理
			<ul>
				<li>
					<a href="">查看用户</a>
				</li>
				<li>
					<a href="">添加用户</a>
				</li>
				<li><a href="">删除、修改</a></li>
				<li>
					<a href="">查找用户</a>
				</li>
			</ul><br>
			 用户组管理
			<ul>
				<li>
					<a href="">查看用户组</a>
				</li>
				<li>
					<a href="">添加用户组</a>
				</li>
				<li><a href="">删除、修改</a></li>
				<li>
					<a href="">查找用户组</a>
				</li>
			</ul>
		</div>
	</body>
</html>
