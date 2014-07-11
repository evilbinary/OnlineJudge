<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link href="css/styles.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <div class="main">
    	<div class="navigator">
    		<jsp:include page="ProblemType.jsp" />
    	</div>
    	<div class="content">
    		<jsp:include page="ProblemList.jsp" />
    		<jsp:include page="Page.jsp" />
    	</div>
    </div>
  </body>
</html>
