package com.masai.dao;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Bidder;
import com.masai.bean.Tender;
import com.masai.bean.Vendor;

public class AdminOptions {

	public static void adminOptions() {
		AdministratorDao ad=new AdministratorDaoImpl();
		VendorDao vd=new VendorDaoImpl();
		TenderDao td=new TendorDaoImpl();
		BidderDao bd=new BidderDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Select below options");
		System.out.println("1. Register a new vendor");
		System.out.println("2. View all the vendors");
		System.out.println("3. Create new tender");
		System.out.println("4. View All the Tenders");
		System.out.println("5. View All the Bids of a tender.");
		System.out.println("6. Assign tender to a vendor.");
		System.out.println("7. Exit");
		int options2=sc.nextInt();
		switch (options2) {
		case 1: {
			
			System.out.println("Enter username: ");
			String vusername=sc.next();
			System.out.println("Enter vpassword: ");
			String vpassword=sc.next();
			System.out.println("Enter vname: ");
			String vname=sc.next();
			System.out.println("Enter vmob: ");
			String vmob=sc.next();
			System.out.println("Enter vemail: ");
			String vemail=sc.next();
			System.out.println("Enter company: ");
			String company=sc.next();
			System.out.println("Enter address: ");
			String address=sc.next();
			String res= vd.registerVendor(vusername, vpassword, vmob, vname, vemail, company, address);
			System.out.println(res);
			AdminOptions.adminOptions();
		break;
		}
		
	case 2: {
			List<Vendor> li= vd.getAllVendors();
			if(li==null) {
				System.out.println("No vendors");
			}
			else {
				li.forEach(s->System.out.println(s));
			}
			AdminOptions.adminOptions();
		break;
		}
	case 3: {
		System.out.println("Enter Tender Id: ");
		int tid=sc.nextInt();
		System.out.println("Enter tname: ");
		String tname=sc.next();
		System.out.println("Enter ttype: ");
		String ttype=sc.next();
		System.out.println("Enter tprice: ");
		int tprice=sc.nextInt();
		System.out.println("Enter tdesc: ");
		String tdesc=sc.next();
		System.out.println("Enter tdeadline: ");
		String tdeadline=sc.next();
		System.out.println("Enter taddress: ");
		String taddress=sc.next();
		Tender t=new Tender(tid, tname, ttype, tprice, tdesc, tdeadline, taddress);
		String res= td.createTender(t);
		System.out.println(res);
		AdminOptions.adminOptions();
	break;
	}
	
	case 4: {
		List<Tender> li= td.getAllTenders();
		if(li==null) {
			System.out.println("No tenders");
		}
		else {
			li.forEach(s->System.out.println(s));
		}
		AdminOptions.adminOptions();
	break;
	}
//	5. View All the Bids of a tender.");
	case 5:{
		int tid=sc.nextInt();
		List<Bidder> li= bd.getBidsByTenderID(tid);
		if(li==null) {
			System.out.println("No bids by tender");
		}
		else {
			li.forEach(s->System.out.println(s));
		}
		AdminOptions.adminOptions();
		break;
	}
	case 6:{
		int tenderId=sc.nextInt();
		String vendorUsername=sc.next();
		int bidderId=sc.nextInt();
		String res= td.assignTender(tenderId, vendorUsername, bidderId);
		System.out.println(res);
		AdminOptions.adminOptions();
		break;
	}
	case 7:AdminOptions.exit();
	return;
	
	}
	}
	
	public static void exit() {
		System.out.println("Thank You");
		return;
	}
}
