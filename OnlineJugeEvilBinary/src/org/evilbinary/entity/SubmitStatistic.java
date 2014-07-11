package org.evilbinary.entity;

public class SubmitStatistic {
	private String id;
	private String submitCount;
	private String passCount;
	public SubmitStatistic(String id, String submitCount, String passCount) {
		super();
		this.id = id;
		this.submitCount = submitCount;
		this.passCount = passCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassCount() {
		return passCount;
	}
	public void setPassCount(String passCount) {
		this.passCount = passCount;
	}
	public String getSubmitCount() {
		return submitCount;
	}
	public void setSubmitCount(String submitCount) {
		this.submitCount = submitCount;
	}
	
}	
