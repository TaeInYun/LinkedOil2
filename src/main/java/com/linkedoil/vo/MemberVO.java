package com.linkedoil.vo;

public class MemberVO {
	private int no;
	private String email;
	private String pwd;
	private String name;
	private String nickname;
	public MemberVO(int no, String email, String pwd, String name, String nickname) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
	}
	public MemberVO() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
