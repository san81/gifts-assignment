package com.eshop.common;

import java.util.*;
import java.io.*;

public class ElectronicShop {

	Bean laptop = null;
	Bean camera = null;
	Bean cellphone = null;
	Bean desktop = null;

	Map lmap = null;
			
	/**************** METHOD FOR LAPTOP INFO. **************************/

	public void readLaptopInfo(String lfile) throws Exception {
		loadLaptopInfo(lfile);
	}
	
	public void loadLaptopInfo(String filename) throws Exception {

		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		
		String id,make;
		int quantity;
		double price;
		
		
		lmap = new HashMap();

		while(line != null) 
		{
			laptop = new Bean();
			
			StringTokenizer st = new StringTokenizer(line," ");
			if(st.hasMoreTokens()) 
			{
				id = st.nextElement().toString();
				laptop.setProductid(id);
				
				make = st.nextElement().toString();
				laptop.setProductmake(make);

				try
				{
				price = Double.parseDouble(st.nextElement().toString());
				
				laptop.setProductprice(price);
				
				quantity = Integer.parseInt(st.nextElement().toString());
				
				laptop.setProductquantity(quantity);
				}catch(Exception e)
				{
					System.out.println("Exception:::"+e);
				}
				lmap.put(id,laptop);
				
				System.out.println(lmap.get(id));
				System.out.println(" \n******************************");
			}
			line = br.readLine();
			
		}
	}
	
	/**************** METHOD FOR DESKTOP INFO. **************************/

	public void readDesktopInfo(String dfile) throws Exception
	{
		loadDesktopInfo(dfile);
	}
	
	public void loadDesktopInfo(String filename) throws Exception {

		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		
		String id,make;
		int quantity;
		double price;
	
		
		lmap = new HashMap();

		while(line != null) 
		{
			desktop = new Bean();
			
			StringTokenizer st = new StringTokenizer(line," ");
			if(st.hasMoreTokens()) 
			{
				id = st.nextElement().toString();
				desktop.setProductid(id);
				
				make = st.nextElement().toString();
				desktop.setProductmake(make);

				try
				{
				price = Double.parseDouble(st.nextElement().toString());
				
				desktop.setProductprice(price);
				
				quantity = Integer.parseInt(st.nextElement().toString());
				
				desktop.setProductquantity(quantity);
				}catch(Exception e)
				{
					System.out.println("Exception:::"+e);
				}
				lmap.put(id,desktop);
				
				System.out.println(lmap.get(id));
				System.out.println(" \n******************************");
			}
			line = br.readLine();
		}
	}

	/**************** METHOD FOR CAMERA INFO. **************************/

	public void readCameraInfo(String cfile) throws Exception {
		loadCameraInfo(cfile);
	}
	
	public void loadCameraInfo(String filename) throws Exception {

		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		
		String id,make;
		int quantity;
		double price;
		
		
		lmap = new HashMap();

		while(line != null) 
		{
			camera = new Bean();
			
			StringTokenizer st = new StringTokenizer(line," ");
			if(st.hasMoreTokens()) 
			{
				id = st.nextElement().toString();
				camera.setProductid(id);
				
				make = st.nextElement().toString();
				camera.setProductmake(make);

				try
				{
				price = Double.parseDouble(st.nextElement().toString());
				
				camera.setProductprice(price);
				
				quantity = Integer.parseInt(st.nextElement().toString());
				
				camera.setProductquantity(quantity);
				}catch(Exception e)
				{
					System.out.println("Exception:::"+e);
				}
				lmap.put(id,camera);
				
				System.out.println(lmap.get(id));
				System.out.println(" \n******************************");
			}
			line = br.readLine();
		}
	}
	
	/**************** METHOD FOR CELLPHONE INFO. **************************/

	public void readCellphoneInfo(String lfile) throws Exception {
		loadCellphoneInfo(lfile);
	}
	
	public void loadCellphoneInfo(String filename) throws Exception {

		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		
		String id,make;
		int quantity;
		double price;
		
		lmap = new HashMap();

		while(line != null) 
		{
			cellphone = new Bean();
			
			StringTokenizer st = new StringTokenizer(line," ");
			if(st.hasMoreTokens()) 
			{
				id = st.nextElement().toString();
				cellphone.setProductid(id);
				
				make = st.nextElement().toString();
				cellphone.setProductmake(make);

				try
				{
				price = Double.parseDouble(st.nextElement().toString());
				
				cellphone.setProductprice(price);
				
				quantity = Integer.parseInt(st.nextElement().toString());
				
				cellphone.setProductquantity(quantity);
				}catch(Exception e)
				{
					System.out.println("Exception:::"+e);
				}
				lmap.put(id,cellphone);
				
				System.out.println(lmap.get(id));
				System.out.println(" \n******************************");
			}
			line = br.readLine();
		}
	}
			
	public static void main(String args[]) throws Exception	{

		ElectronicShop shop = new ElectronicShop();
		
		int choice=0;
		while(choice<5)
		{						
			System.out.println(" \n\n *******************************************");
			System.out.println(" ****\t\t 1 - Laptop \t\t**** \n ****\t\t 2 - Desktop \t\t****\n ****\t\t 3 - Camera \t\t**** \n ****\t\t 4 - Cellphone \t\t****\n ****\t\t 5 - Exit \t\t****");
			System.out.println(" *******************************************\n\n\n");
			System.out.println("Enter your choice of product whose list u want :");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
						shop.readLaptopInfo("laptop.txt");
						break;
				case 2: 
						shop.readDesktopInfo("desktop.txt");
						break;
				case 3:
						shop.readCameraInfo("camera.txt");
						break;
				case 4:
						shop.readCellphoneInfo("cellphone.txt");
						break;
			}
		}
	}
}