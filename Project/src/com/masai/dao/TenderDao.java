package com.masai.dao;

import java.util.List;

import com.masai.bean.Tender;
import com.masai.bean.TenderStatus;
import com.masai.exceptions.TenderException;

public interface TenderDao {

	public String createTender(Tender tender);
	
	public Tender getTenderById(int tid) throws TenderException;
	
	public String removeTenderById(int tid);
	
	public List<Tender> getAllTenders() throws TenderException;
	
	public String getTenderStatus(int tid);
	
	public String assignTender(int tenderId,String vendorUsername, int bidderId);
	
	public List<TenderStatus> getAllAssignedTenders() throws TenderException;
	
} 
