<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
 
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

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body class="index">
		<div class="contain">
			<jsp:include page="HeadNoLogin.jsp"></jsp:include>
			 <div class="login_main">
			<form action="UserServlet?action=userRegister" method="post">
				<div class="login">
					<br>
					<div class="login_item">
					�û���:
					<input type="text" maxlength="20" name="username"><br>
					</div>
					<div class="login_item">
					�� ��:
					<input type="password" maxlength="20" name="password"><br>
					</div>
					<div class="login_item">
					Email:
					<input type="text" maxlength="20" name="email"><br>
					</div>
					<div class="login_item"  >
						<input type="submit" class="login_btn"  value="ע��" name="button1">
					</div>
				</div>
			</form>
			</div>
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>
	</body>
</html>
