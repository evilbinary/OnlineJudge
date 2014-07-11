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

		<title>My JSP 'ProblemList.jsp' starting page</title>

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
			<%
				try {
					UserStateManager userState = (UserStateManager) session
							.getAttribute("userState");
					if (userState == null)
						return;
					if("".equals(userState.getProblemType()))
							userState.setProblemType("Normal");
					userState.setPageSize(4);//设置一页显示数目
					ProblemManager probleManager = new ProblemManager();
					Vector<Problem> problems = probleManager.getTypeProblem(
							userState.getProblemType(), userState
									.getCurrentPageNum(), userState.getPageSize());
					
					userState.setTotalNum(probleManager.getAllProblemCount(userState.getProblemType()));
					for (int i = 0; i < problems.size(); i++) {
						Problem problem = problems.get(i);
						String content = problem.getContent();
						if (content.length() > 150)
							content = content.substring(0, 150);
			%>
			<div class="textbox_title">
				<a
					href="ProblemServlet?action=getProblem&problemId=<%=problem.getId()%>">
					<%=(problem.getTitle())%></a>
			</div>
			<div class="textbox_content">
				<%=content%>......
			</div>
			<div class="textbox_bottom">
			</div>
			<%
				}
				} catch (Exception e) {
					System.out.println(e.getMessage() + "异常");
				}
			%>


		</div>
	</body>
</html>
