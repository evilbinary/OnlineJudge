<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="org.evilbinary.manager.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProblemOperatorList.jsp' starting page</title>
    
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
     <%
     	UserStateManager userState=(UserStateManager)session.getAttribute("userState");
     	if(userState==null)
     		return;
     	String msg=userState.getMessage();
     	String op=userState.getOp();
     	if(!msg.equals("")){
     	%>
     		<script type="text/javascript">
     			alert("<%=msg%>");
     		</script>
     	<% }
     	userState.setMessage("");
     	if("addProblem".equals(op)){
     		%>
     		<jsp:include page="AddProblem.jsp"></jsp:include>
     		<%
     	}else if("addProblemType".equals(op)){
     		%>
     		<jsp:include page="AddProblemType.jsp"></jsp:include>
     		<%
     	}else if("viewProblem".equals(op)){
     		%>
     		<jsp:include page="ViewProblem.jsp"></jsp:include>
     		<%
     	}else if("modifyProblem".equals(op)){
     		%>
     		<jsp:include page="ModifyProblem.jsp"></jsp:include>
     		<%
     	}else if("addProblem".equals(op)){
     		%>
     		<jsp:include page="AddProblem.jsp"></jsp:include>
     		<%
     	}else if("alterProblem".equals(op)){
     		%>
     		<jsp:include page="AlterProblem.jsp"></jsp:include>
     		<%
     	}else if("addProblem".equals(op)){
     		
     	}else if("addProblem".equals(op)){
     		
     	}else if("addProblem".equals(op)){
     		
     	}else if("addProblem".equals(op)){
     		
     	}
     %>
     
  </body>
</html>
