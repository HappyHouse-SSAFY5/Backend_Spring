package com.ssafy.happyhouse.model;

public class QnaDto {
	private int id;
	private String title;
	private String content;
	private String userid;
	public QnaDto(int id, String title, String content, String userid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "QnaDto [id=" + id + ", title=" + title + ", content=" + content + ", userid=" + userid + "]";
	}
	
}
