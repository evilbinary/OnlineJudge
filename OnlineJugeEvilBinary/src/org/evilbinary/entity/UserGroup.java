package org.evilbinary.entity;

public class UserGroup {
	private String id;
	private String createDate;
	private String owner;
	private String mark;
	public UserGroup(String id, String createDate, String owner, String mark) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.owner = owner;
		this.mark = mark;
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
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
