package com.masai.dao;

import java.util.List;

import com.masai.bean.Vendor;

public interface VendorDao {

	public String registerVendor(String username, String password,String vname,String vmob,String vemail, String company,String address);
	
	public String registerVendor(Vendor vendor);
	
	public List<Vendor> getAllVendors();
	
	public Vendor getVendorById(String username);
	
	public boolean vendorLogIn(String username, String password);
	
//	public String changePassword(String username, String old_password,String new_password);
	
	
	
}
