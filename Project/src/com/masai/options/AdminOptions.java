package com.masai.options;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Bidder;
import com.masai.bean.Tender;
import com.masai.bean.Vendor;
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

public class AdminOptions {

	public static void adminOptions()  {
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
		sc.nextLine();
		System.out.println("Enter tname: ");
		String tname=sc.nextLine();
		System.out.println("Enter ttype: ");
		String ttype=sc.nextLine();
		System.out.println("Enter tprice: ");
		int tprice=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter tdesc: ");
		String tdesc=sc.nextLine();
		System.out.println("Enter tdeadline: ");
		String tdeadline=sc.nextLine();
		System.out.println("Enter taddress: ");
		String taddress=sc.nextLine();
		Tender t=new Tender(tid, tname, ttype, tprice, tdesc, tdeadline, taddress);
		String res= td.createTender(t);
		System.out.println(res);
		AdminOptions.adminOptions();
	break;
	}
	
	case 4: {
	
		try {
			List<Tender> li = td.getAllTenders();
			li.forEach(s->System.out.println(s));
		} catch (TenderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AdminOptions.adminOptions();
	break;
	}
//	5. View All the Bids of a tender.");
	case 5:{
		System.out.println("Enter tender id:");
		int tid=sc.nextInt();
		List<Bidder> li;
		try {
			li = bd.getBidsByTenderID(tid);
			li.forEach(s->System.out.println(s));
		} catch (BidderException e) {
			System.out.println(e.getMessage());
		}
		AdminOptions.adminOptions();
		break;
	}
	case 6:{
		System.out.println("Enter tender id:");
		int tenderId=sc.nextInt();
		System.out.println("Enter vendor username:");
		String vendorUsername=sc.next();
		System.out.println("Enter bidder id:");
		int bidderId=sc.nextInt();
		String res= td.assignTender(tenderId, vendorUsername, bidderId);
		System.out.println(res);
		AdminOptions.adminOptions();
		break;
	}
	case 7:
		AdminOptions.exit();
	
	return;
	
	}
	}
	
	public static void exit() {
		System.out.println("Thank You");
		return;
	}
}
