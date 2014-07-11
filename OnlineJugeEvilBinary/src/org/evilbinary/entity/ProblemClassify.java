package org.evilbinary.entity;

public class ProblemClassify {
	private String id;
	private String problemType;
	private String createDate;
	public ProblemClassify(String id, String problemType, String createDate) {
		super();
		this.id = id;
		this.problemType = problemType;
		this.createDate = createDate;
	}
	public ProblemClassify() {
		// TODO Auto-generated constructor stub
		this.id="";
		this.problemType="";
		this.createDate="";
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String[] getParametersNonPrimary() {
		// TODO Auto-generated method stub
		return new String[]{this.id,this.problemType,this.createDate};
	}
	
}
