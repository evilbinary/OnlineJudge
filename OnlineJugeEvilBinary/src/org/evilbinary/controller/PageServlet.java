package org.evilbinary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.evilbinary.manager.UserStateManager;

public class PageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PageServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		doProcess(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String direct = "";
			String msg = "";
//			System.out.println("page");
			UserStateManager userState=(UserStateManager) session.getAttribute("userState");
			if(userState==null){
				userState=new UserStateManager();
			}
			String action = request.getParameter("action");
			if("viewPage".equals(action)){
				String currentPageNum=request.getParameter("page");
				userState.setCurrentPageNum(Integer.valueOf(currentPageNum));
				
				direct=userState.getCurrentPage();
//				System.out.println(currentPageNum);
				
			}else if("viewNextPage".equals(action)){
				userState.setNextPage();
				direct=userState.getCurrentPage();
				
			}else if("viewPrePage".equals(action)){
				userState.setPrePage();
				direct=userState.getCurrentPage();
				
			}else if("".equals(action)){
				
			}else if("".equals(action)){
				
			}else if("".equals(action)){
				
			}else if("".equals(action)){
				
			}else if("".equals(action)){
				
			}else if("".equals(action)){
				
			}
			if (!"".equals(direct)) {
//				System.out.println("msg" + msg + " page=" + direct);
				request.getRequestDispatcher(direct).forward(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
