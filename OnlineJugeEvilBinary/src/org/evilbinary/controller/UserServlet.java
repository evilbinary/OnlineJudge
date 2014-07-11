package org.evilbinary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.evilbinary.manager.*;
import org.evilbinary.entity.*;;
 

public class UserServlet extends HttpServlet {

	 
	private UserManager userManager;
 
	public UserServlet() {
		super();
		userManager=new UserManager();
 
	}
 
	public void destroy() {
		System.out.println("destroy");
		super.destroy(); // Just puts "destroy" string in log
		
	 
	}

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
//		System.out.println("doget");
		doProcess(request,response);
	
 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
//		System.out.println("dopost");
		doProcess(request,response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response){
		try {
			String direct="Index.jsp";
			String msg = "";
			String path = "";
			HttpSession session=request.getSession();
			ServletContext application=this.getServletContext();
			UserStateManager userState=(UserStateManager) session.getAttribute("userState");
			WebStateInfoManager webStateInfoManager=(WebStateInfoManager)application.getAttribute("webStateInfoManager");
			if(userState==null){
				userState=new UserStateManager();
			}
			 if(webStateInfoManager==null){
				 webStateInfoManager=new WebStateInfoManager();
				 application.setAttribute("webStateInfoManager", webStateInfoManager);
			 }
			String action = request.getParameter("action");
			if ("userLogin".equals(action)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				username=username.trim();
				password=password.trim();
				if(!"".equals(username)&&!"".equals(password)){
					System.out.println("登录 "+ username+" "+password);
					User user=userManager.userLoginReturnUser(username, password);
					 if(user!=null){
//						 session.setAttribute("userId", userManager.user.getId());
//						 session.setAttribute("userName",userManager.user.getName());
						 userState.setUser( user.getId(),  user.getName());
						 session.setAttribute("userState", userState);
						 webStateInfoManager=(WebStateInfoManager)application.getAttribute("webStateInfoManager");
						 if(webStateInfoManager==null){
							 webStateInfoManager=new WebStateInfoManager();
							 application.setAttribute("webStateInfoManager", webStateInfoManager);
							 
						 }
						 webStateInfoManager.addLoginUser(user.getId(),user.getName());
						 
					 }else{
						 msg="用户名或密码错误。";
					 }
				}

			} else if ("showUserInfo".equals(action)) {
				userState = (UserStateManager) session.getAttribute("userState");
				if (!"".equals(userState.getUserId()) ) {
					direct = "UserInfo.jsp";
				} else {
					msg = " 请先登录。";
					direct = "UserLogin.jsp";
				}
				path = "用户信息";
			} else if ("userLogout".equals(action)) {
//				session.removeAttribute("userId");
//				session.removeAttribute("userName");
				webStateInfoManager=(WebStateInfoManager)application.getAttribute("webStateInfoManager");
				if(userState.getType()==0){
					webStateInfoManager.dropLogoutAdmin(userState.getUserId());
				}else{
					webStateInfoManager.dropLogoutUser(userState.getUserId());
				}
				
				session.removeAttribute("userState");
				msg="注销";
				//direct="Index.jsp";
				 
			} else if ("adminLogin".equals(action)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				username=username.trim();
				password=password.trim();
				
				Admin admin=userManager.adminLogin(username,password);
				
				if(admin!=null){
					if(!"".equals(userState.getUserId())){
						webStateInfoManager.dropLogoutUser(userState.getUserId());
					}
					userState.setUser( admin.getId(),  admin.getName());
					System.out.println(admin.getId()+admin.getName());
					userState.setType(0);
					session.setAttribute("userState", userState);
					 webStateInfoManager=(WebStateInfoManager)application.getAttribute("webStateInfoManager");
					 if(webStateInfoManager==null){
						 webStateInfoManager=new WebStateInfoManager();
						 application.setAttribute("webStateInfoManager", webStateInfoManager);
						 
					 }
					 webStateInfoManager.addLoginAdmin(admin.getId(),admin.getName());
					 
				}else{
					direct=userState.getCurrentPage();
				}
				
			}else if ("adminLogout".equals(action)) {
				 
				 webStateInfoManager.dropLogoutAdmin(userState.getUserId());
				
			}else if ("jmpToAdminLogin".equals(action)) {
				direct="AdminLogin.jsp";
				
			} else if ("jmpToLogin".equals(action)) {
				direct="UserLogin.jsp";
				
			} else if ("jmpToRegiste".equals(action)) {
				direct="UserRegister.jsp";
				
			} else if ("userRegister".equals(action)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				username=username.trim();
				password=password.trim();
				if(userManager.register(username, password, email)){
					msg="注册成功";
					
				}
				
				
			} else if ("showOnlineUser".equals(action)) {
				direct="OnlineUser.jsp";
				
			} else if ("viewPage".equals(action)) {
				
			} else if ("".equals(action)) {
				
			} else if ("".equals(action)) {
				
			}
			
			System.out.println("msg"+msg+" page="+direct);
			if(userState!=null)
				userState.setMessage(msg);
			
			if(!"".equals(direct)){
				userState.setCurrentPage(direct);
				request.getRequestDispatcher(direct).forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println(e + "错误");
		}
		
	}
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
