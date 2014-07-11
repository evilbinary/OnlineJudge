package org.evilbinary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.evilbinary.manager.ProblemManager;
import org.evilbinary.manager.UserStateManager;
import org.evilbinary.manager.WebStateInfoManager;

public class ProblemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private ProblemManager problemManager;
	public ProblemServlet() {
		problemManager=new ProblemManager();
		 
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		doProcess(request,response); 
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		 doProcess(request,response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session=request.getSession();
			UserStateManager userState=(UserStateManager) session.getAttribute("userState");
			if(userState==null){
				userState=new UserStateManager();
				//session.setAttribute("userState", userState);
			}
			String direct="Index.jsp";
			String msg = "";
			String path = "";
			String action = request.getParameter("action");
			if ("listProblem".equals(action)) {
				String problemType = request.getParameter("problemType");
				if(problemType==null){
					problemType="Normal";
				}
				userState.setProblemType(problemType);
				userState.setCurrentPageNum(1);
//				 session.setAttribute("problemType",problemType);
				 

			} else if ("getProblem".equals(action)) {
				
				String problemId = request.getParameter("problemId");
				userState.setProblemId(problemId);
				
				direct="Problem.jsp";
//				System.out.println(problemId+" problemId");
//				 session.setAttribute("problemId",problemId);
			} else if ("submitCode".equals(action)) {
//				System.out.println(  "submitCode");
				direct="Submit.jsp";
				
			} else if ("viewUserPassDetail".equals(action)) {
				String acceptId= request.getParameter("acceptId");
				
				direct="UserPassDetail.jsp";
				
			} else if ("Manager".equals(action)) {
				
				direct="Manager.jsp";
				
			} else if("jmpToAddProblem".equals(action)){
				
				userState.setOp("addProblem");
				direct=userState.getCurrentPage();
				
			}else if("jmpToAddProblemType".equals(action)){
				
				userState.setOp("addProblemType");
				direct=userState.getCurrentPage();
				
			}else if("jmpToModifyProblem".equals(action)){
				String problemType = request.getParameter("problemType");
				if(problemType==null){
					problemType="Normal";
				}
				userState.setProblemType(problemType);
				userState.setOp("modifyProblem");
				direct=userState.getCurrentPage();
				
			}else if("addProblem".equals(action)){
				
				String problemTitile=request.getParameter("problemTitile");
				String problemContent=request.getParameter("problemContent");
				String type=request.getParameter("type");
				problemTitile=problemTitile.trim();
				problemContent=problemContent.trim();
				if(!"".equals(problemTitile)&&!"".equals(problemContent)){
					boolean b=problemManager.addNewProblem(problemTitile,problemContent,userState.getUserId(),type);
					if(b){
						userState.setMessage("添加成功!");
					}else{
						userState.setMessage("添加失败!");
					}
				}
				else{
					userState.setMessage("不能为空!");
				}
				direct=userState.getCurrentPage();
				
			}else if ("addProblemType".equals(action)) {
				
				String type=request.getParameter("problemType");
				if(problemManager.addClassify(type)){
					userState.setMessage("类型添加成功！");
				}else{
					userState.setMessage("类型添加失败");
				}
				direct=userState.getCurrentPage();
			} else if ("viewProblem".equals(action)) {
				String problemType = request.getParameter("problemType");
				if(problemType==null){
					problemType="Normal";
				}
				userState.setProblemType(problemType);
				userState.setOp("viewProblem");
				System.out.println("view "+problemType);
				direct=userState.getCurrentPage();
				
			}else if ("delProblem".equals(action)) {
				String problemId = request.getParameter("problemId");
				if(problemManager.dropProblem(problemId)){
					userState.setMessage("删除题目成功");
				}else{
					userState.setMessage("删除题目失败");
				}
				
				direct=userState.getCurrentPage();
			}else if ("jmpToAlterProblem".equals(action)) {
				String problemId = request.getParameter("problemId");
				userState.setProblemId(problemId);
				userState.setOp("alterProblem");
				direct=userState.getCurrentPage();
			}else if ("alterProblem".equals(action)) {
				String problemId=request.getParameter("problemId");
				String problemTitile=request.getParameter("problemTitile");
				String problemContent=request.getParameter("problemContent");
				String type=request.getParameter("problemType");
				problemTitile=problemTitile.trim();
				problemContent=problemContent.trim();
				if(!"".equals(problemTitile)&&!"".equals(problemContent)){
					boolean b;
					if("None".equals(type)){
						b=problemManager.modifyProblem(problemId, problemTitile, problemContent, userState.getUserId());
					}else{
						b=problemManager.modifyProblem(problemId,problemTitile,problemContent,userState.getUserId(),type);
						
					}
					if(b){
						userState.setMessage("修改成功!");
					}else{
						userState.setMessage("修改失败!");
					}
				}
				else{
					userState.setMessage("不能为空!");
				}
				userState.setOp("modifyProblem");
				direct=userState.getCurrentPage();
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}else if ("".equals(action)) {
				
			}
			session.setAttribute("msg", msg);
			if(!"".equals(direct)){
				userState.setCurrentPage(direct);
//				System.out.println("msg"+msg+" page="+direct);
				request.getRequestDispatcher(direct).forward(request, response);
			}
	 
			
		} catch (Exception e) {
			System.out.println(e + "错误");
		}
		
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		
	}

}
