package org.evilbinary.entity;

public class ProblemAnswer {
	private String testId;
	private String problemId;
	public ProblemAnswer(String testId, String problemId) {
		super();
		this.testId = testId;
		this.problemId = problemId;
	}
	public String getProblemId() {
		return problemId;
	}
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
}
