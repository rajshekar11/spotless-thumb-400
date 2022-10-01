package com.masai.options;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.dao.AdministratorDao;
import com.masai.dao.AdministratorDaoImpl;
import com.masai.dao.TenderDao;
import com.masai.dao.TendorDaoImpl;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exceptions.BidderException;

public class Options {

	public static void selectOptions() {
		AdministratorDao ad=new AdministratorDaoImpl();
		VendorDao vd=new VendorDaoImpl();
		TenderDao td=new TendorDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Select any options");
		System.out.println("1.Login as administrator");
		System.out.println("2.Login as vendor");
		System.out.println("3.Register as administrator");
		System.out.println("4. Exit");
		int options=sc.nextInt();
		switch (options) {
		case 1: {
			System.out.println("Enter Admin username");
			String username=sc.next();
			System.out.println("Enter Admin password");
			String password=sc.next();
			boolean ans= ad.logInAdmin(username, password);
			if(ans) {
				System.out.println("Welcome: "+username);
				AdminOptions.adminOptions();
			}
			else {
				System.out.println("Invalid Username or Password!");
			}
				
			Options.selectOptions();
			break;
		}
		
		case 2: {
			System.out.println("Enter Vendor username");
			String username=sc.next();
			System.out.println("Enter Vendor password");
			String password=sc.next();
			boolean flag= vd.vendorLogIn(username, password);
			if(flag==true) {
				System.out.println("Welcome: "+username);
				VendorOptions.vendorOptions();
			}
			else {
				System.out.println("Failed");
			}
			Options.selectOptions();
			break;
		}
		case 3: {
			System.out.println("Enter Admin username");
			String username=sc.next();
			System.out.println("Enter Admin password");
			String password=sc.next();
			System.out.println("Enter Admin aname");
			String aname=sc.next();
			System.out.println("Enter Admin amob");
			String amob=sc.next();
			System.out.println("Enter Admin aemail");
			String aemail=sc.next();
			String res= ad.registerAdmin(username, password, aname, amob, aemail);
			System.out.println(res);
				AdminOptions.adminOptions();
			break;
		}
		case 4: {
			Options.exit();
			return;
		}
		default:{
			System.out.println("Please choose the correct options");
			Options.selectOptions();
		}
	}
}
	
	public static void exit() {
		System.out.println("Thank You");
		return;
	}
	
}
