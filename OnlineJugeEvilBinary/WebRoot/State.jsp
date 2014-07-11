<%-- 
    Document   : state
    Created on : 2010-12-4, 0:01:21
    Author     : Administrator
--%>

<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="org.evilbinary.manager.*"%>
<%@ page language="java" import="org.evilbinary.entity.*"%>

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
			<div>
				<div class="textbox_title">
					<ul>
						<li>结果Id</li>
						<li> 题目Id</li><li> 用户</li><li> 状态</li>
						<li> 代码类型</li><li> 运行内存</li>
						<li> 运行时间 </li><li>提交日期</li><li> 代码长度</li>
					</ul>
				</div>

				<div class="textbox_content">
					<%
						try {
							SubmitManager submitManager = new SubmitManager();
							Vector<String[]> sumitStates = submitManager
									.getAllSubmitStateOderByTime();
							for (int i = 0; i < sumitStates.size(); i++) {
								String[] s = sumitStates.get(i);
								int mem = Integer.valueOf(s[5]) / 1024;
					%>


					<ul>
						<li>
							<%=s[0]%>
						</li>
						<li>
							<a href="ProblemServlet?action=getProblem&problemId=<%=s[1]%>"><%=s[1]%>
							</a>
						</li>
						<li>
							<%=s[2]%>
						</li>
						<li>
							<%=s[3]%>
						</li>
						<li>
							<%=s[4]%>
						</li>
						<li>
							<%=mem%>k
						</li>
						<li>
							<%=s[6]%>ms
						</li>
						<li>
							<%=s[7]%>
						</li>
						<li>
							<%=s[8]%>b
						</li>
					</ul>

					<%
						}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					%>

				</div>

				<div class="textbox_bottom">
				</div>
			</div>
			<jsp:include page="Foot.jsp"></jsp:include>
		</div>

	</body>
</html>
