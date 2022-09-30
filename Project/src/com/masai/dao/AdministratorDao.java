package com.masai.dao;

import com.masai.bean.Admin;

public interface AdministratorDao {

	public String registerAdmin(String username,String password, String aname,String amob,String aemail);
	
	public String registerAdmin(Admin admin);
	
	public boolean logInAdmin(String username,String password);
	
//	public String changePassword(String username, String old_password,String new_password);
}
