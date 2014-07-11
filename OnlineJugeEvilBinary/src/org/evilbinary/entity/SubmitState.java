package org.evilbinary.entity;

public class SubmitState {
	private String id;
	private String cid;
	private String state;
	private String codeType;
	private String memory;
	private String runtime;
	private String submitDate;
	private String codeLength;
	 
	
	public SubmitState(String id, String cid, String state, String codeType,
			String memory, String runtime, String submitDate, String codeLength) {
		super();
		this.id = id;
		this.cid = cid;
		this.state = state;
		this.codeType = codeType;
		this.memory = memory;
		this.runtime = runtime;
		this.submitDate = submitDate;
		this.codeLength = codeLength;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public SubmitState() {
		// TODO Auto-generated constructor stub
		this.id="";
		this.cid="";
		this.state="";
		this.submitDate="";
		this.codeType="";
		this.memory="";
		this.runtime="";
		this.codeLength="";
	}
	
	public String getCodeLength() {
		return codeLength;
	}
	public void setCodeLength(String codeLength) {
		this.codeLength = codeLength;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return cid;
	}
	 
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	
	 
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String[] getParametersNonPrimary() {
		// TODO Auto-generated method stub
		return new String[]{this.cid,this.state,this.codeType,this.memory,this.runtime,this.submitDate,this.codeLength};
	}
	
}
