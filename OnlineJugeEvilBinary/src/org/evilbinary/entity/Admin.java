package org.evilbinary.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Admin {
	private String id;
	private String name;
	private String password;
	private String privilege;
	private String email;
	private String registeDate;
	private String mark;
	public Admin(String id, String name, String password, String privilege, String email, String registeDate, String mark) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.privilege = privilege;
		this.email = email;
		this.registeDate = registeDate;
		this.mark = mark;
	}
	public Admin(String id, String name, String password, String privilege, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.privilege = privilege;
		this.email = email;
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.registeDate = dayFormat.format(new Date());;
		this.mark = "";
	}
	public Admin() {
		this.id="";
		this.name="";
		this.password="";
		this.privilege="";
		this.email="";
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 this.registeDate = dayFormat.format(new Date());
		 this.mark="";
	}
	public String[] getParametersNonPrimary(){
		String params[]={name,password,privilege,email,registeDate};
		return params;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getRegisteDate() {
		return registeDate;
	}
	public void setRegisteDate(String registeDate) {
		this.registeDate = registeDate;
	}
	
}
