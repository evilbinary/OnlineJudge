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
	<script language="JavaScript">
<!--
function checkpass(){
			if((document.form1.username.value == "")||(document.form1.password.value == ""))
			{
				alert("您输入的用户名或密码不能为空，请重新输入！")
				return false;
			}
			else{
				 
				return true;
			}
		}
//-->
</script>
	</head>

	<body class="index">
		<div class="contain">
			<jsp:include page="HeadNoLogin.jsp"></jsp:include>
			 <div class="login_main">
			<form name="form1" action="UserServlet?action=userLogin" method="post">
				<div class="login">
					<br>
					<div class="login_item">
					用户名:
					<input type="text" maxlength="20" name="username"><br>
					</div>
					<div class="login_item">
					密 码:
					<input type="password" maxlength="20" name="password"><br>
					</div>
					<div class="login_item"  >
						<input type="submit" class="login_btn"  value="登录" onclick="return checkpass();" name="button1">
					</div>
				</div>
			</form>
			</div>
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>
	</body>
</html>
