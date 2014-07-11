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
		<div class="page">
			<ul>
				<li>
					<a href="PageServlet?action=viewPrePage">《上一页</a>
				</li>
				<%
					try {
						UserStateManager userState = (UserStateManager) session
								.getAttribute("userState");
						if (userState == null)
							return;
							int tmp=(userState.getTotalNum()/userState.getPageSize()+1);
						 	int begin=userState.getCurrentPageNum()-2 ;
						 	int end=userState.getCurrentPageNum()+2;
						 	if(begin<=1){
						 		begin=1;
						 	}
						 	if(end>=tmp){
						 		end=tmp;
						 	}
						 	//System.out.println("begin "+begin+" cur="+userState.getCurrentPageNum()+" end="+end+" tmp="+tmp);
							for (int i = begin; i <= end; i++) {
				%>
				<li>
					<a
						href="PageServlet?action=viewPage&page=<%=i%>"><%=i%>
					</a>
				</li>
				<%
					}
					 
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				%>
				<li>
					<a href="PageServlet?action=viewNextPage">下一页》</a>
				</li>

			</ul>
		</div>
	</body>
</html>
