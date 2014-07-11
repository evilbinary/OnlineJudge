<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

	<body>
		<br>
		
			<%
				try {
					UserStateManager userState = (UserStateManager) session
							.getAttribute("userState");
					ProblemManager problemManager = new ProblemManager();
					Problem problem = problemManager.getProblemById(userState
							.getProblemId());
			%>
			<form method="post" action="ProblemServlet?action=alterProblem&problemId=<%=problem.getId()%>"
			name="form1">
			<p style="text-align: left;">
				题目ID：<%=problem.getId()%>
				标题:
				<input type="text" name="problemTitile"
					value="<%=problem.getTitle()%>">
				类型：
				<select name="problemType">

					<%
						Vector<String> types = problemManager.getAllProblemType();
							Vector<String> ptypes = problemManager.getProblemType(userState
									.getProblemId());
							if (types == null)
								return;
							if (ptypes == null) {
					%>
					<option selected="selected">
						None
					</option>
					<%
						for (int i = 0; i < types.size(); i++) {
									String tmp = (String) types.get(i);
					%>
					<option><%=tmp%></option>
					<%
						}
							} else {
								for (int i = 0; i < types.size(); i++) {
									String tmp = (String) types.get(i);
									if (tmp.equals(ptypes.get(0))) {
					%>
					<option selected="selected"><%=tmp%></option>
					<%
						} else {
					%>
					<option><%=tmp%></option>
					<%
						}
								}
							}
					%>
				</select>
			<p style="text-align: left;">
				<textarea name="problemContent" rows="30" cols="100"><%=problem.getContent()%></textarea>
			</p>


			<p style="text-align: left;">
				&nbsp;
				<input type="submit" value="确认修改" name="button1">
			</p>
			<%
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			%>
		</form>
	</body>
</html>
