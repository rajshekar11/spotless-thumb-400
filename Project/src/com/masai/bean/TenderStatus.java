package com.masai.bean;

public class TenderStatus {
	
	
	private int tid;
	private int bid;
	private String status;
	private String username;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public TenderStatus(int tid, int bid, String status, String username) {
		super();
		this.tid = tid;
		this.bid = bid;
		this.status = status;
		this.username = username;
	}
	@Override
	public String toString() {
		return "TenderStatus [tid=" + tid + ", bid=" + bid + ", status=" + status + ", username=" + username + "]";
	}
	
	
	
}
