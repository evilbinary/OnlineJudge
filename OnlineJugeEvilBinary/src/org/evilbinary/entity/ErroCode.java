package org.evilbinary.entity;

public class ErroCode {
	private String eid;
	private String pid;
	private String uid;
	private String code;
	private String jugeDate;
	
	 
	public ErroCode(String eid, String pid, String uid, String code,
			String jugeDate) {
		super();
		this.eid = eid;
		this.pid = pid;
		this.uid = uid;
		this.code = code;
		this.jugeDate = jugeDate;
	}
	public ErroCode() {
		super();
		this.eid="";
		this.pid = "";
		this.uid = "";
		this.code = "";
		this.jugeDate = "";
	}
	
	public String getEid() {
		return eid;
	}


	public void setEid(String eid) {
		this.eid = eid;
	}


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getJugeDate() {
		return jugeDate;
	}


	public void setJugeDate(String jugeDate) {
		this.jugeDate = jugeDate;
	}
	public  String[] getParametersNonPrimary() {
		// TODO Auto-generated method stub
		return new String[]{this.pid,this.uid,this.code,this.jugeDate};
	}


	
	 
	
}
