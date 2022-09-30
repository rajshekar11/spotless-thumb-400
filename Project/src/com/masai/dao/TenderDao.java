package com.masai.dao;

import java.util.List;

import com.masai.bean.Tender;
import com.masai.bean.TenderStatus;

public interface TenderDao {

	public String createTender(Tender tender);
	
	public Tender getTenderById(int tid);
	
	public String removeTenderById(int tid);
	
	public List<Tender> getAllTenders();
	
	public String getTenderStatus(int tid);
	
	public String assignTender(int tenderId,String vendorUsername, int bidderId);
	
	public List<TenderStatus> getAllAssignedTenders();
	
} 
