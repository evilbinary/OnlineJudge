package org.evilbinary.entity;

public class LoginInfo {
	private String uid;
	private String ipaddress;
	private String loginTime;
	
	public LoginInfo(String uid, String ipaddress, String loginTime) {
		super();
		this.uid = uid;
		this.ipaddress = ipaddress;
		this.loginTime = loginTime;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
