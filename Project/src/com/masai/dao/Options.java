package com.masai.dao;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Tender;
import com.masai.bean.Vendor;

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
			}
			else {
				System.out.println("Failed");
			}
			AdminOptions.adminOptions();
			
		}
		
		case 2: {
			System.out.println("Enter Vendor username");
			String username=sc.next();
			System.out.println("Enter Vendor password");
			String password=sc.next();
			boolean flag= vd.vendorLogIn(username, password);
			if(flag==true) {
				System.out.println("Welcome: "+username);
			}
			else {
				System.out.println("Failed");
			}
			
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
		case 4: 
			Options.exit();
		return;
	}
}
	
	public static void exit() {
		System.out.println("Thank You");
		return;
	}
	
}
