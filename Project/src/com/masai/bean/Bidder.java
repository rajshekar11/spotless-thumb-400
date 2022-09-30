package com.masai.bean;

public class Bidder {
	
	
	private int bid;
	private int bidamount;
	private String deadline;
	private String status;
	private String username;
	private int tid;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBidamount() {
		return bidamount;
	}
	public void setBidamount(int bidamount) {
		this.bidamount = bidamount;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Bidder(int bid, int bidamount, String deadline, String status, String username, int tid) {
		super();
		this.bid = bid;
		this.bidamount = bidamount;
		this.deadline = deadline;
		this.status = status;
		this.username = username;
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Bidder [bid=" + bid + ", bidamount=" + bidamount + ", deadline=" + deadline + ", status=" + status
				+ ", username=" + username + ", tid=" + tid + "]";
	}

	

}
