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
					<a href="">��ҳ</a>
				</li>
				<li>
					<a href="ProblemServlet?action=listProblem&problemType=Normal">��Ŀ�б�</a>
				</li>
				<li>
					<a href="JugeServlet?action=viewJugeState">״̬</a>
				</li>
				<%
					try {
						UserStateManager userState = (UserStateManager) session
								.getAttribute("userState");
						if (userState.getType() == 0) {
				%>
				 
				<li>
					<a href="ProblemServlet?action=Manager">ϵͳ����</a>
				</li>
				<li>
					<a href="">�û���</a>
				</li>
				<li>
					<a href="UserServlet?action=showUserInfo">������Ϣ</a>
				</li>
				<li>
					<a href="UserServlet?action=showOnlineUser">�����û�</a>
				</li>
				<%
					} else {
				%>

				<li>
					<a href="UserServlet?action=showUserInfo">������Ϣ</a>
				</li>
				<li>
					<a href="">�û���</a>
				</li>
				<li>
					<a href="UserServlet?action=jmpToAdminLogin">����</a>
				</li>
				<li>
					<a href="UserServlet?action=showOnlineUser">�����û�</a>
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
