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

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
		function submitSelect(){
			form1.submit();
			return true;
		}
	</script>
	</head>

	<body>
		<form name="form1" action="ProblemServlet?action=viewProblem"
			method="post">
			选择类型:
			<select name="problemType" onchange=" return submitSelect();">
				<option selected="selected">All</option>
				<%
					try {
						UserStateManager userState = (UserStateManager) session
								.getAttribute("userState");
						ProblemManager problemManager = new ProblemManager();
						Vector<String> types = problemManager.getAllProblemType();
						if (types == null)
							return;
						for (int i = 0; i < types.size(); i++) {
							String tmp = (String) types.get(i);
							if (tmp.equals(userState.getProblemType())) {
				%>
				<option selected="selected"><%=tmp%>
				</option>
				<%
					} else {
				%>
				<option><%=tmp%></option>

				<%
					}
						}
				%>

			</select>

		</form>
		题目ID 标题   所有者 创建日期<br>
		<%
			Vector<Problem> problems;
			if(userState.getProblemType().equals("All")){
				problems=problemManager.getAllProblem();
			}else{
			  problems = problemManager
						.getTypeProblem(userState.getProblemType());
						}
				for (int i = 0; i < problems.size(); i++) {
					Problem problem = problems.get(i);
					Admin admin=problemManager.getOwnerById(problem.getOwner());
		%>
			   <%=problem.getId()%>  
			  <a href="ProblemServlet?action=getProblem&problemId=<%=problem.getId()%>"><%=problem.getTitle()%></a>
			  <a href="UserServlet?action="><%= admin.getName()%></a>  
			  <%=problem.getCreateDate() %>
			 <br>
			
		<%
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		%>

	</body>
</html>
