package com.masai.bean;

public class Admin {

	private String username;
	private String password;
	private String aname;
	private String amob;
	private String aemail;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAmob() {
		return amob;
	}
	public void setAmob(String amob) {
		this.amob = amob;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public Admin(String username, String password, String aname, String amob, String aemail) {
		super();
		this.username = username;
		this.password = password;
		this.aname = aname;
		this.amob = amob;
		this.aemail = aemail;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", aname=" + aname + ", amob=" + amob
				+ ", aemail=" + aemail + "]";
	}
	
	
}
