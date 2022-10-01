package com.masai.options;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Bidder;
import com.masai.bean.Tender;
import com.masai.dao.AdministratorDao;
import com.masai.dao.AdministratorDaoImpl;
import com.masai.dao.BidderDao;
import com.masai.dao.BidderDaoImpl;
import com.masai.dao.TenderDao;
import com.masai.dao.TendorDaoImpl;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exceptions.BidderException;
import com.masai.exceptions.TenderException;

public class VendorOptions {

	public static void vendorOptions() {
		
		AdministratorDao ad=new AdministratorDaoImpl();
		VendorDao vd=new VendorDaoImpl();
		TenderDao td=new TendorDaoImpl();
		BidderDao bd=new BidderDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Select below options");
		System.out.println("1. View all the current Tenders.");
		System.out.println("2. Place a Bid against a Tender.");
		System.out.println("3. View status of a Bid(Whether Selected or Not)");
		System.out.println("4. View his own Bid History.");
		System.out.println("5. Exit");
		int options=sc.nextInt();

		switch (options) {
		case 1: {
			try {
				List<Tender> li= td.getAllTenders();
				li.forEach(s->System.out.println(s));
			} catch (TenderException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			VendorOptions.vendorOptions();
			break;
		}
		case 2: {
			System.out.println("Enter tendor id: ");
			int tendorId=sc.nextInt();
			System.out.println("Enter vendor username");
			String vendorUsername=sc.next();
			System.out.println("Enter bid amount: ");
			int bidAmount=sc.nextInt();
			System.out.println("Enter enter bid deadline: ");
			String deadline=sc.next();
			
			String str;
			try {
				str = bd.bidATender(tendorId, vendorUsername, bidAmount, deadline);
				System.out.println(str);
			} catch (BidderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			VendorOptions.vendorOptions();
			break;
		}
		case 3:{
			System.out.println("Enter bid id:");
			int bid=sc.nextInt();
			String res=bd.getBidStatus(bid);
			System.out.println(res);
			VendorOptions.vendorOptions();
			break;
		}
		case 4:{
			try {
				List<Bidder> li= bd.getAllBids();
				li.forEach(s->System.out.println(s));
			} catch (BidderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VendorOptions.vendorOptions();
			break;
		}
		case 5:{
			VendorOptions.exit();
			break;
		}
		
		default:{
			System.out.println("Please choose correct options");
			VendorOptions.vendorOptions();
		}
		
	  }
	}
	
	public static void exit() {
		System.out.println("Thank you visit again");
		return;
	}
}
