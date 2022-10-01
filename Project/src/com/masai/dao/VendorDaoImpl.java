package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Vendor;
import com.masai.utility.DBUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public String registerVendor(String username, String password, String vname, String vmob, String vemail,
			String company, String address) {
		String res="Registration failed";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("insert into Vendor values(?,?,?,?,?,?,?);");
			
			pr.setString(1, username);
			pr.setString(2, password);
			pr.setString(3, vname);
			pr.setString(4, vmob);
			pr.setString(5, vemail);
			pr.setString(6, company);
			pr.setString(7, address);
			
			int x= pr.executeUpdate();
			if(x>0) {
				res="Vendor registration successfull";
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String registerVendor(Vendor vendor) {
		String res="Registration failed";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("insert into Vendor values(?,?,?,?,?,?,?);");
			
			pr.setString(1, vendor.getUsername());
			pr.setString(2, vendor.getPassword());
			pr.setString(3, vendor.getVname());
			pr.setString(4, vendor.getVmob());
			pr.setString(5, vendor.getVemail());
			pr.setString(6, vendor.getCompany());
			pr.setString(7, vendor.getAddress());
			
			int x= pr.executeUpdate();
			if(x>0) {
				res="Vendor registration successfull";
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public List<Vendor> getAllVendors() {
		List<Vendor> li=new ArrayList<>();
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Vendor");
			
			ResultSet rs= pr.executeQuery();
			
			
			while(rs.next()) {
				
				String username=rs.getString("username");
				String password=rs.getString("password");
				String vname=rs.getString("vname");
				String vmob=rs.getString("vmob");
				String vemail=rs.getString("vemail");
				String company=rs.getString("company");
				String address=rs.getString("address");
				
				Vendor v=new Vendor(username, password, vname, vmob, vemail, company, address);
				if(v!=null) {
					li.add(v);
				}
				
			}
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return li;
	}

	@Override
	public Vendor getVendorById(String username) {
		Vendor ven=null;
		
try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Vendor where username=?");
			
			pr.setString(1, username);
			ResultSet rs= pr.executeQuery();
			
			
			while(rs.next()) {
				
				String usernamee=rs.getString("username");
				String password=rs.getString("password");
				String vname=rs.getString("vname");
				String vmob=rs.getString("vmob");
				String vemail=rs.getString("vemail");
				String company=rs.getString("company");
				String address=rs.getString("address");
				
				ven=new Vendor(usernamee, password, vname, vmob, vemail, company, address);
			}
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		return ven;
	}

	@Override
	public boolean vendorLogIn(String username, String password) {
		boolean flag=false;
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from Vendor where username=? and password=?");
			
			pr.setString(1, username);
			pr.setString(2, password);
			
			ResultSet rs= pr.executeQuery();
			
			if(rs.next()) {
				flag=true;
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
//
//	@Override
//	public String changePassword(String username, String old_password, String new_password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
