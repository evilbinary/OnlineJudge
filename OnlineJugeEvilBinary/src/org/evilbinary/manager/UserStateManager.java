package org.evilbinary.manager;

//用于session 保存用户状态
public class UserStateManager {
	private String userName;
	private String userId;
	private String problemType;
	private String problemId;
	private String problemName;
	private String message;
	private PageManager page;
	private String op;
	private int type;
	public UserStateManager() {
		userName = "游客";
		userId = "";
		problemType = "";
		problemId = "";
		page = new PageManager();
		type=1;
		op="";
	}
	
	public int getType() {
		return type;
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setUser(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrentPage() {
		return page.getCurrentPage();
	}

	public void setCurrentPage(String currentPage) {
		this.page.setCurrentPage(currentPage);
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	public void setNextPage(){
		page.nextPage();
	}
	public void setPrePage(){
		page.prePage();
	}
	public void setPageSize(int size){
		this.page.setPageSize(size);
	}
	public int getCurrentPageNum(){
		return page.getCurrentPageNum();
	}
	public int getTotalNum(){
		return page.getTotalNum();
	}
	public void setCurrentPageNum(int currentPageNum) {
			this.page.setCurrentPageNum(currentPageNum);
	}

	public void setTotalNum(int totalNum) {
		this.page.setTotalNum(totalNum);
	}
	public int  getPageSize(){
		return page.getPageSize();
	}
	private int stringToInt(String string){
		int page=-1;
		try {
			page=Integer.valueOf(string);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro page");
		}
		return page;
	}
	private String intToString(String string){
		String page=null;
		try {
			page=String.valueOf(string);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro page");
		}
		return page;
	}

}
