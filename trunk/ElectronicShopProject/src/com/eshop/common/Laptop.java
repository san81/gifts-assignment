package com.eshop.common;

import java.util.*;

public class Laptop {

	public static void main(String args[]) {

		List laptoplist = new ArrayList();
		LaptopBean lb = new LaptopBean();
		//lb.setProductid(
		laptoplist.add(1,lb);
		lb.setProductprice(25000.00);
		lb.setProductquantity(25);
		lb.setProductmake("compaq");

		laptoplist.add(2,lb);
		lb.setProductprice(30000.00);
		lb.setProductquantity(5);
		lb.setProductmake("HCL");

		laptoplist.add(lb);
		lb.setProductprice(40000.00);
		lb.setProductquantity(50);
		lb.setProductmake("Lanovo");

		Iterator it = laptoplist.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		/*
		System.out.println("Do u want to Add / Show / Sell ??? \nPlease Enter ur choice ::");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = br.readLine();
		while(choice<4)
		{
			System.out.println(" 1. ---- Add /n 2. ---- Show /n 3. ---- Sell");
			switch(choice)
			{
				case 1:
					System.out.println("Enter Product Id	Quantity");
					String productid = br.readLine();
					

					
	}*/
	}
}