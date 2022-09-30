package com.masai.dao;

import java.util.List;

import com.masai.bean.Bidder;

public interface BidderDao {
	
	public String bidATender(int tendorId,String vendorUsername,int bidAmount,String deadline);

	public String acceptBid(int bidId,String vendorUsername,int tenderId);
	
	public String rejectBid(int bidId);
	
	public List<Bidder> getAllBids();
	
	public List<Bidder> getBidsByTenderID(int tid);
	
	public List<Bidder> getBidsByVendorUsername(String username);
	
}
