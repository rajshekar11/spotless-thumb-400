package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Tender;
import com.masai.bean.TenderStatus;
import com.masai.exceptions.TenderException;
import com.masai.utility.DBUtil;

public class TendorDaoImpl implements TenderDao {

	@Override
	public String createTender(Tender tender) {
		String res="Tender not created";
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("insert into Tender values(?,?,?,?,?,?,?)");
			
			pr.setInt(1, tender.getTid());
			pr.setString(2, tender.getTname());
			pr.setString(3, tender.getTtype());
			pr.setInt(4, tender.getTprice());
			pr.setString(5, tender.getTdesc());
			pr.setString(6, tender.getTdeadline());
			pr.setString(7, tender.getTaddress());
			
			int x= pr.executeUpdate();
			if(x>0) {
				res="Tender created successfully!";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return res;
	}

	@Override
	public Tender getTenderById(int tid) throws TenderException {
		Tender t=null;
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from tender where tid=?");
			
			pr.setInt(1, tid);
			
			ResultSet rs= pr.executeQuery();
			
			while(rs.next()) {
				int tidd=rs.getInt("tid");
				String tname= rs.getString("tname");
				String ttype= rs.getString("ttype");
				int tprice= rs.getInt("tprice");
				String tdesc= rs.getString("tdesc");
				String tdeadline= rs.getString("tdeadline");
				String taddress= rs.getString("taddress");
				t=new Tender(tidd, tname, ttype, tprice, tdesc, tdeadline, taddress);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(t==null) {
			throw new TenderException("There are no tender by id: "+tid);
		}
		return t;
	}

	@Override
	public String removeTenderById(int tid) {
		String res="Tender remove failed";
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("delete from tender where tid=?");
			
			pr.setInt(1, tid);
			int x= pr.executeUpdate();
			
			if(x>0) {
				res="Tender removed successfully!";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return res;
	}

	@Override
	public List<Tender> getAllTenders() throws TenderException {
		List<Tender> li=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from tender");
			
			ResultSet rs= pr.executeQuery();
			
			while(rs.next()) {
				int tid=rs.getInt("tid");
				String tname= rs.getString("tname");
				String ttype= rs.getString("ttype");
				int tprice= rs.getInt("tprice");
				String tdesc= rs.getString("tdesc");
				String tdeadline= rs.getString("tdeadline");
				String taddress= rs.getString("taddress");
				Tender t=new Tender(tid, tname, ttype, tprice, tdesc, tdeadline, taddress);
				li.add(t);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.isEmpty()) {
			throw new TenderException("There are no tenders");
		}
		
		return li;
	}

	@Override
	public String getTenderStatus(int bid) {
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

	@Override
	public String assignTender(int tenderId, String vendorUsername, int bidderId) {
		String res="Assign failed";
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr1= con.prepareStatement("select * from tenderstatus where tid=?");
			
			pr1.setInt(1, tenderId);
			
			ResultSet rs=pr1.executeQuery();
			
			if(rs.next()) {
				res="Tender: "+tenderId+" is already assigned to vendor: "+rs.getString("username");
			}
			else {
			
			PreparedStatement pr= con.prepareStatement("insert into tenderstatus(tid,username,bid) values(?,?,?)");
			
			pr.setInt(1, tenderId);
			pr.setString(2, vendorUsername);
			pr.setInt(3, bidderId);
		
			int x= pr.executeUpdate();
			if(x>0) {
				res="Tender: "+tenderId+" has been assigned to vendor: "+vendorUsername;
			}
			
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public List<TenderStatus> getAllAssignedTenders() throws TenderException {
		List<TenderStatus> li=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from tenderstatus");
			ResultSet rs= pr.executeQuery();
			
			while(rs.next()) {
				int tid=rs.getInt("tid");
				int bid= rs.getInt("bid");
				String ttype= rs.getString("status");
				String taddress= rs.getString("username");
				TenderStatus ts=new TenderStatus(tid, bid, ttype, taddress);
				li.add(ts);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(li.isEmpty()) {
			throw new TenderException("There are no assigned tenders");
		}
		return li;
	}

	
}
