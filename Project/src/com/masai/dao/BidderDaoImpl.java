package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Bidder;
import com.masai.bean.Tender;
import com.masai.exceptions.BidderException;
import com.masai.utility.DBUtil;

public class BidderDaoImpl implements BidderDao {

	@Override
	public String bidATender(int tendorId, String vendorUsername, int bidAmount, String deadline) throws BidderException {
		
		String res="Bid failed";
		
			try(Connection con=DBUtil.provideConnection()) {
				
				PreparedStatement pr1=con.prepareStatement("select * from bidder where username=?");
				pr1.setString(1, "vendorUsername");
				ResultSet rs=pr1.executeQuery();
				if(rs.next()) {
					throw new BidderException("Vendor: "+vendorUsername+" already placed a bid");
				}
				else {
				
			PreparedStatement pr= con.prepareStatement("insert into Bidder(bidamount,deadline,username,tid) values(?,?,?,?)");
			String status="Pending";
			pr.setInt(1, bidAmount);
			pr.setString(2, deadline);
			pr.setString(3, vendorUsername);
			pr.setInt(4, tendorId);
			int x= pr.executeUpdate();
			if(x>0) {
				res="Bid placed successfully by a vendor: "+vendorUsername;
			}
		}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String acceptBid(int bidId, String vendorUsername, int tenderId) {
		String res="Bid not accepted";
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement ps= con.prepareStatement("update bidder set status=? where bid=? and status=?");
			ps.setString(1, "Accepted");
			ps.setInt(2, bidId);
			ps.setString(3, "Pending");
			
			int x= ps.executeUpdate();
			if(x>0) {
				res="Bid Accepted";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String rejectBid(int bidId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bidder> getAllBids() throws BidderException {
		List<Bidder> li=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Bidder");
			
			ResultSet rs= pr.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt("bid");
				int bidamount= rs.getInt("bidamount");
				String deadline= rs.getString("deadline");
				String status= rs.getString("status");
				String username= rs.getString("username");
				int tid= rs.getInt("tid");
				
				Bidder bd=new Bidder(bid, bidamount, deadline, status, username, tid);
				li.add(bd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.isEmpty()) {
			throw new BidderException("No bids made yet");
		}
		
		return li;
	}

	@Override
	public List<Bidder> getBidsByTenderID(int tid) throws BidderException {
		List<Bidder> li=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Bidder where tid=?");
			
			pr.setInt(1, tid);
			
			ResultSet rs= pr.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt("bid");
				int bidamount= rs.getInt("bidamount");
				String deadline= rs.getString("deadline");
				String status= rs.getString("status");
				String username= rs.getString("username");
				int tidd= rs.getInt("tid");
				
				Bidder bd=new Bidder(bid, bidamount, deadline, status, username, tidd);
				li.add(bd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.isEmpty()) {
			throw new BidderException("There are No bids placed for tenderId: "+tid);
		}
		
		return li;
	}

	@Override
	public List<Bidder> getBidsByVendorUsername(String username) throws BidderException {
		List<Bidder> li=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Bidder where username=?");
			
			pr.setString(1, username);
			
			ResultSet rs= pr.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt("bid");
				int bidamount= rs.getInt("bidamount");
				String deadline= rs.getString("deadline");
				String status= rs.getString("status");
				String usernamee= rs.getString("username");
				int tidd= rs.getInt("tid");
				
				Bidder bd=new Bidder(bid, bidamount, deadline, status, usernamee, tidd);
				li.add(bd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.isEmpty()) {
			throw new BidderException("No bids by vendor username: "+username);
		}
		
		return li;
	}

	@Override
	public String getBidStatus(int bid) {
		String res="No status found";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr1= con.prepareStatement("select * from tenderstatus where bid=?");
			
			pr1.setInt(1, bid);
			
			ResultSet rs=pr1.executeQuery();
			
			if(rs.next()) {
				res="Already assigned";
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return res;
	}

}
