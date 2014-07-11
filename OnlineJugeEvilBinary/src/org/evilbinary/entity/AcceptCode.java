package org.evilbinary.entity;

public class AcceptCode {
	private String aid;
	private String pid;
	private String uid;
	private String code;
	private String passDate;
	
	
	public AcceptCode(String aid, String pid, String uid, String code,
			String passDate) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.uid = uid;
		this.code = code;
		this.passDate = passDate;
	}
	public AcceptCode() {
		super();
		this.aid = "";
		this.pid = "";
		this.uid = "";
		this.code = "";
		this.passDate = "";
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
 
	public String getPassDate() {
		return passDate;
	}
	public void setPassDate(String passDate) {
		this.passDate = passDate;
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
	public String[] getParametersNonPrimary() {
		// TODO Auto-generated method stub
		return new String[]{this.pid,this.uid,this.code,this.passDate};
	}
	
}
