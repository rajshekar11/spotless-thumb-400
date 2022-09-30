package com.masai.useCases;

import com.masai.dao.AdministratorDao;
import com.masai.dao.AdministratorDaoImpl;

public class LoginAdmin {

	public static void main(String[] args) {
		AdministratorDao ad=new AdministratorDaoImpl();
		String username="admin";
		String password="12345";
		boolean flag= ad.logInAdmin(username, password);
		if(flag==true) {
			System.out.println("Success");
		}
		else {
			System.out.println("Failed");
		}
	}
}
