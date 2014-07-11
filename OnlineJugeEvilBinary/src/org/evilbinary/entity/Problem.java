package org.evilbinary.entity;

public class Problem {
	private String id;
	private String title;
	private String content;
	private String createDate;
	private String owner;
	public Problem(String id, String title,String content, String createDate, String owner) {
		super();
		this.id = id;
		this.title=title;
		this.content = content;
		this.createDate = createDate;
		this.owner = owner;
	}
	public Problem() {
		this.id = "";
		this.title="";
		this.content = "";
		this.createDate = "";
		this.owner = "";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getParametersNonPrimary() {
		 
		return new String[]{ this.title,this.content,this.createDate,this.owner};
	}
	
}
