package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.masai.bean.Bidder;
import com.masai.bean.Tender;
import com.masai.utility.DBUtil;

public class BidderDaoImpl implements BidderDao {

	@Override
	public String bidATender(int tendorId, String vendorUsername, int bidAmount, String deadline) {
		String res="Bid failed";
		
			try(Connection con=DBUtil.provideConnection()) {
				
			PreparedStatement pr= con.prepareStatement("insert into Bidder(bidamount,deadline,username,tid) values(?,?,?,?,?,?)");
			String status="Pending";
			pr.setInt(1, bidAmount);
			pr.setString(2, deadline);
			pr.setString(3, status);
			pr.setString(4, vendorUsername);
			pr.setInt(5, tendorId);
			
			int x= pr.executeUpdate();
			if(x>0) {
				res="Tender created successfully!";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
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
			// TODO: handle exception
		}
		
		return res;
	}

	@Override
	public String rejectBid(int bidId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bidder> getAllBids() {
		List<Bidder> li=null;
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
			// TODO: handle exception
		}
		return li;
	}

	@Override
	public List<Bidder> getBidsByTenderID(int tid) {
		List<Bidder> li=null;
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
			// TODO: handle exception
		}
		return li;
	}

	@Override
	public List<Bidder> getBidsByVendorUsername(String username) {
		List<Bidder> li=null;
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
			// TODO: handle exception
		}
		return li;
	}

}
