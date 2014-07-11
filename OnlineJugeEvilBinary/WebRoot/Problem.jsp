<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
 <%@ page language="java" import="org.evilbinary.manager.*" %>
  <%@ page language="java" import="org.evilbinary.entity.*" %>
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
			<%
				try{
				//String problemId=(String)session.getAttribute("problemId");
				UserStateManager userState=(UserStateManager)session.getAttribute("userState");
				String problemId=userState.getProblemId();
				ProblemManager problmeManager=new ProblemManager();
				Problem problem=problmeManager.getProblemById(problemId);
				userState.setProblemName(problem.getTitle());
				//System.out.println(problem.getTitle()+"problem.jsp title="+userState.getProblemName());
				
			%>
			<form action="ProblemServlet?action=submitCode&problemId=<%=problem.getId()%> " method="post">
			<div class="problem">
				 
					<div class="problem_title">
						题目ID：<%=problem.getId() %>
						<a href="ProblemServlet?action=getProblem&problemId=<%=problem.getId() %>"><%=problem.getTitle() %></a>
					</div>
				 
				<div class="problem_content">
					<%=problem.getContent() %>
				</div>
				
				
				<div class="code_submit" >
				<input class="submit_btn" type="submit" value="提交">
				<a href="JugeServlet?action=viewJugeState">查看状态</a>
				</div>
			</div>
			
			<%}catch(Exception e){
				System.out.println(e.getMessage()+" problem.jsp erro");
			}
			%>
			</form>
			
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>
	</body>
</html>
