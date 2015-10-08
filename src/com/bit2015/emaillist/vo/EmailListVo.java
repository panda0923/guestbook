package com.bit2015.emaillist.vo;

public class EmailListVo {
	private String firstname;
	private String lastname;
	private long no;
	private String email;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailListVo [firstname=" + firstname + ", lastname=" + lastname
				+ ", no=" + no + ", email=" + email + "]";
	}
}
