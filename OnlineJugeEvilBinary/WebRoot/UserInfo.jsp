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
			<jsp:include page="Head.jsp"></jsp:include>
			<div class="user">
				<div class="user_info">
					<%
						try {
							UserStateManager userState = (UserStateManager) session
									.getAttribute("userState");
							UserManager userManger = new UserManager();
							if (userState.getType() == 0) {
								Admin admin=userManger.findAdminById(userState.getUserId());
					%>
					<div class="textboxinfo_top">
						<a href="UserServlet?action=showUserInfo"><%=admin.getName()%></a>
						个人信息
					</div>
					<div class="textboxinfo_content">
						Id:<%=userState.getUserId()%><br>
						Email:
						<%=admin.getEmail()%><br>
						注册时间:<%=admin.getRegisteDate()%><br>
						签名:<%=admin.getMark()%><br>
					</div>
					<div class="textboxinfo_bottom">
					</div>
					<%
						} else {
								User user = userManger.findUserById(userState.getUserId());
					%>
					<div class="textboxinfo_top">
						<a href="UserServlet?action=showUserInfo"><%=user.getName()%></a>
						个人信息
					</div>
					<div class="textboxinfo_content">
						Id:<%=userState.getUserId()%><br>
						Email:
						<%=user.getEmail()%><br>
						注册时间:<%=user.getRegisteDate()%><br>
						签名:<%=user.getMark()%><br>
					</div>
					<div class="textboxinfo_bottom">
					</div>
				</div>
				<div class="user_pass_head">
					提交通过题目
				</div>
				<div class="user_pass_content">
					<%
						Vector<String[]> vv = userManger.getUserPassInfo(userState
										.getUserId());
								for (int i = 0; i < vv.size(); i++) {
									String[] v = vv.get(i);
					%>
					<%=v[0]%>
					<a href="ProblemServlet?action=getProblem&problemId=<%=v[0]%>">
						<%=v[1]%> </a>
					<%=v[2]%>
					<a
						href="ProblemServlet?action=viewUserPassDetail&acceptId=<%=v[3]%>">查看详情</a>
					<br>
					<%
						}
							}
						} catch (Exception e) {
							System.out.println(e.getMessage() + " UseInfo.jsp");
						}
					%>
				</div>


				<div class="user_pass_bottom">
					&nbsp;
				</div>
			</div>
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>
	</body>
</html>
