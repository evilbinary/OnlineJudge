<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*"%>
<%@ page language="java" import="org.evilbinary.entity.*"%>
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
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>

	<body>
		<div class="menu">
			<ul>
				<li>
					<a href="">首页</a>
				</li>
				<li>
					<a href="ProblemServlet?action=listProblem&problemType=Normal">题目列表</a>
				</li>
				<li>
					<a href="JugeServlet?action=viewJugeState">状态</a>
				</li>
				<%
					try {
						UserStateManager userState = (UserStateManager) session
								.getAttribute("userState");
						if (userState.getType() == 0) {
				%>
				 
				<li>
					<a href="ProblemServlet?action=Manager">系统管理</a>
				</li>
				<li>
					<a href="">用户组</a>
				</li>
				<li>
					<a href="UserServlet?action=showUserInfo">个人信息</a>
				</li>
				<li>
					<a href="UserServlet?action=showOnlineUser">在线用户</a>
				</li>
				<%
					} else {
				%>

				<li>
					<a href="UserServlet?action=showUserInfo">个人信息</a>
				</li>
				<li>
					<a href="">用户组</a>
				</li>
				<li>
					<a href="UserServlet?action=jmpToAdminLogin">管理</a>
				</li>
				<li>
					<a href="UserServlet?action=showOnlineUser">在线用户</a>
				</li>
				<%
					}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				%>



			</ul>
		</div>
	</body>
</html>
