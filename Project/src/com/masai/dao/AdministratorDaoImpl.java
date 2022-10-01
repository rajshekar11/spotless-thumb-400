package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.utility.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public String registerAdmin(String username, String password, String aname, String amob, String aemail) {
		String res="Administrator Registration failed";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("insert into Administrator values(?,?,?,?,?)");
			
			pr.setString(1, username);
			pr.setString(2, password);
			pr.setString(3, aname);
			pr.setString(4, amob);
			pr.setString(5, aemail);
			
			int x= pr.executeUpdate();
			
			if(x>0) {
				res="Administrator Registration successfull!";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		return res;
	}

	@Override
	public String registerAdmin(Admin admin) {
		String res="Administrator Registration failed";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("insert into Administrator values(?,?,?,?,?)");
			
			pr.setString(1, admin.getUsername());
			pr.setString(2, admin.getPassword());
			pr.setString(3, admin.getAname());
			pr.setString(4, admin.getAmob());
			pr.setString(5, admin.getAemail());
			
			int x= pr.executeUpdate();
			
			if(x>0) {
				res="Administrator Registration successfull!";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		return res;
	}

	@Override
	public boolean logInAdmin(String username, String password) {
		boolean flag=false;
		
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement pr= con.prepareStatement("select * from administrator where username=? and password=?");
			
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
//	@Override
//	public String changePassword(String username, String old_password, String new_password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
