<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*"%>
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

		<title>My JSP 'head.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/styles.css">


	</head>

	<body>
		<div class="head">
			<div class="logo">
				<%
					//String userId=(String)session.getAttribute("userId");
					//String userName=(String)session.getAttribute("userName");
					UserStateManager userState = (UserStateManager) session
							.getAttribute("userState");
					if (userState == null) {
						userState=new UserStateManager();
						userState.setUserName("�ο�");
						session.setAttribute("userState", userState);
					}  
					if (userState.getUserName().equals("�ο�")) {
				%>
				<div class="welcome">
					��ӭ  
					<a href="UserServlet?action=showUserInfo"><%=userState.getUserName()%>
					</a>
					<a href="UserServlet?action=jmpToLogin">���ȵ�¼</a>
					<a href="UserServlet?action=jmpToRegiste">ע��</a>
				</div>
				<%
					} else {
				%>
				<div class="welcome">
					��ӭ
					<a href="UserServlet?action=showUserInfo"><%=userState.getUserName()%>
					</a>
					<a href="UserServlet?action=userLogout">�˳�</a>
				</div>
				<%
					}
					 
				%>
				<p align="center">
					EvilBinary OnlineJuge
				</p>
			</div>

		</div>
		<jsp:include page="Menu.jsp"></jsp:include>
		<div>

		</div>
		<br>
	</body>
</html>
