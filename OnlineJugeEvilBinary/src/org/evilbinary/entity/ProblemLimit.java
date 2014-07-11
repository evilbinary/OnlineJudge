package org.evilbinary.entity;

public class ProblemLimit {
	private String pid;
	private String timeLimit;
	private String memoryLimit;
	private String submitDateLimit;
	public ProblemLimit(String pid, String timeLimit, String memoryLimit, String submitDateLimit) {
		super();
		this.pid = pid;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.submitDateLimit = submitDateLimit;
	}
	public ProblemLimit() {
		// TODO Auto-generated constructor stub
		this.pid="";
		this.timeLimit="";
		this.submitDateLimit="";
		this.memoryLimit="";
	}
	public String getMemoryLimit() {
		return memoryLimit;
	}
	public void setMemoryLimit(String memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSubmitDateLimit() {
		return submitDateLimit;
	}
	public void setSubmitDateLimit(String submitDateLimit) {
		this.submitDateLimit = submitDateLimit;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	
}
