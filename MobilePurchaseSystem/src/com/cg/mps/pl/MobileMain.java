package com.cg.mps.pl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseDetails;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.service.MobileServiceImpl;

public class MobileMain {
	
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		MobileServiceImpl mosrImpl = new MobileServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Mobile Purchase Menu");
			System.out.println("1. Enter Customer and purchase Details");
			System.out.println("2. Details of all Mobiles");
			System.out.println("3. Delete Mobile");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			String choice = sc.next();

			switch (choice) {
			
			case "1":
				System.out.println("Enter mobile id to purchase");
				
				String mid = sc.next();
				System.out.println("Enter customer's name");
				String cname = sc.next();
				System.out.println("Enter emailid");
				String email = sc.next();
				System.out.println("Enter phone number");
				String phone = sc.next();
				
				PurchaseDetails purchaseDetails = new PurchaseDetails(null,mid,cname,email,phone);
				try{
					if(mosrImpl.searchMobile(mid) == null){
						System.out.println("Mobile not found with mobileid"+" "+ mid);
					}else{
						if(mosrImpl.isValidPurchaseMobile(purchaseDetails)){
							mosrImpl.purchaseDetails(purchaseDetails);
							System.out.println("Purchase done with id " +" "+ purchaseDetails.getPurchaseId());
						}
					}
				}catch(MobileDBException e){
					System.out.println(e.getMessage());
				}
				break;
			case "2":
				try {
					List<Mobile> mlist = mosrImpl.getAllMobiles() ;
					if (mlist.size() == 0) {
						System.out.println("No mobile available");
					} else {
						for (Mobile m : mlist) {
							System.out.println(m);
						}
					}
				} catch (MobileDBException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "3":
				System.out.println("enter mobile id to delete");
				String mobid = sc.next();
				try {
					if(mosrImpl.searchMobile(mobid) == null){
						System.out.println("Mobile doesn't exist with product id" + mobid);
					}else{
						mosrImpl.deleteMobile(mobid);
						System.out.println(" Selected mobile deleted" + mobid);
					}
				} catch (MobileDBException e) {
					System.out.println(e.getMessage());
				} 
				break;
			case "4":
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice...");
				break;
			}
		} while (true);

	}

}
