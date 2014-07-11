package org.evilbinary.entity;

public class TestData {
	private String id;
	private String pid;
	private String input;
	private String output;
	 
	 
	
	public TestData(String id, String pid, String input, String output) {
		super();
		this.id = id;
		this.pid = pid;
		this.input = input;
		this.output = output;
	}

	public TestData() {
		// TODO Auto-generated constructor stub
		this.id="";
		this.pid="";
		this.input="";
		this.output="";
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
 

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String[] getParametersNonPrimary() {
		// TODO Auto-generated method stub
		return new String[]{this.pid,this.input,this.output};
	}
	
}
