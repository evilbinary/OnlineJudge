<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>
	<body class="index">
		<div class="contain">
			<jsp:include page="Head.jsp"></jsp:include>
			<div class="problem">
				<%
					try {
						UserStateManager userState = (UserStateManager) session
								.getAttribute("userState");
				%>

				<form
					action="JugeServlet?action=juge&problemId=<%=userState.getProblemId()%>"
					method="post">
					<div class="problem_title">
						ID:<%=userState.getProblemId()%>
						<a
							href="ProblemServlet?action=getProblem&problemId=<%=userState.getProblemId()%>">
							<%=userState.getProblemName()%></a> 题目组:<%=userState.getProblemType()%>
					</div>
					<div class="problem_content" align="center">
						<div align="center">
							<select name="language">
								<option>
									Java
								</option>
								<option>
									C++
								</option>
								<option>
									C
								</option>
							</select>
						</div>
						<br>
						<textarea class="code" name="codetxt" rows="20" cols="65"> 
           					</textarea>
						
					</div>
					<div class="code_submit">
						<input class="submit_btn" type="reset" value="清空" name="button1">
						<input class="submit_btn" type="submit" value="提交"
							name="submitcode" />
					</div>
				</form>

				<%
					} catch (Exception e) {
						System.out.println(e.getMessage() + " Submit.jsp");
					}
				%>

			</div>
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>
	</body>
</html>
