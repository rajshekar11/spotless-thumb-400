package com.masai.dao;

import java.util.List;

import com.masai.bean.Bidder;
import com.masai.exceptions.BidderException;

public interface BidderDao {
	
	public String bidATender(int tendorId,String vendorUsername,int bidAmount,String deadline) throws BidderException;

	public String acceptBid(int bidId,String vendorUsername,int tenderId);
	
	public String rejectBid(int bidId);
	
	public List<Bidder> getAllBids() throws BidderException;
	
	public List<Bidder> getBidsByTenderID(int tid) throws BidderException;
	
	public List<Bidder> getBidsByVendorUsername(String username) throws BidderException;
	
	public String getBidStatus(int bid);
	
}
