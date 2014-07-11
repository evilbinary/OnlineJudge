package org.evilbinary.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String id;
	private String name;
	private String password;
	private String email;
	private String registeDate;
	private String mark;
	public User(){
		this.id = "";
		this.name = "";
		this.password = "";
		this.email = "";
		this.registeDate = "";
		this.mark = "";
	}
	public User(String id, String name, String password, String email, String registeDate, String mark) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.registeDate = registeDate;
		this.mark = mark;
	}
	public User(String id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		SimpleDateFormat dayFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.registeDate = dayFormat.format(new Date());
		System.out.println(registeDate+" registeDate");
		this.mark = "";
	}
	public String[] getParametersNonPrimary(){
		String params[]={name,password,email,registeDate,mark};
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
	public String getRegisteDate() {
		return registeDate;
	}
	public void setRegisteDate(String registeDate) {
		this.registeDate = registeDate;
	}
	
}
	
