package org.evilbinary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.evilbinary.manager.JugeManager;
import org.evilbinary.manager.UserStateManager;
import org.evilbinary.manager.WebStateInfoManager;
import org.evilbinary.oj.JugeSystem;
 

public class JugeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private JugeManager jugeManager;
	public JugeServlet() {
		super();
		jugeManager=new JugeManager();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		// PrintWriter out = response.getWriter();

	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			HttpSession session = request.getSession();
			String direct = "";
			String msg = "";
			
			String action = request.getParameter("action");
			UserStateManager userState = (UserStateManager) session.getAttribute("userState");
			ServletContext application=this.getServletContext();
			Thread jugeSystem=(JugeSystem)application.getAttribute("jugeSystem");
			if(jugeSystem==null){
				jugeSystem=new JugeSystem("Java");
				jugeSystem.start();
				System.out.println("run juge targetNum="+((JugeSystem) jugeSystem).getTargetNumber());
				application.setAttribute("jugeSystem", jugeSystem);
				
			}
			
			if ("juge".equals(action)) {
				String codeText = request.getParameter("codetxt");
				codeText=codeText.trim();
				String problemId=request.getParameter("problemId");
//				System.out.println("codetxt"+codeText);
//				System.out.println("juge1");
				if (!"".equals(codeText)) {
					if ("".equals(userState.getUserId())|| userState.getType()==0) {
						direct = "UserLogin.jsp";
						msg = "ÉÐÎ´µÇÂ¼";
					} else {
						jugeManager.setJugeSystem((JugeSystem) jugeSystem);
						System.out.println("begin add juge");
						jugeManager.addJuge(userState.getProblemId(),userState.getUserId(), codeText);
						
						
						direct="SubmitResult.jsp";
					}
				}else{
					direct=userState.getCurrentPage();
				}
			}else if("viewJugeState".equals(action)){
				jugeManager.setJugeResult();
				direct="State.jsp";
			}
			System.out.println(msg);
			if (!"".equals(direct)) {
				userState.setCurrentPage(direct);
//				System.out.println("msg" + msg + " page=" + direct);
				request.getRequestDispatcher(direct).forward(request, response);
			}
			return;
		} catch (Exception e) {
			System.out.println(e + " JugeServlet");
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
