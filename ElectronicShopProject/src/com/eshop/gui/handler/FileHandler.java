package com.eshop.gui.handler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.eshop.gui.MainCanvas;

public class FileHandler {

	public static void addRecord(String fileName,String code,String make,String model,String qty){
		try{
			FileOutputStream fos = new FileOutputStream(new File("E:/bond pro/gifts-assignment/ElectronicShopProject/src/"+fileName),true);			
			fos.write(("\n"+code+" "+make+" "+model+" "+qty).getBytes());
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getList(String productType){
		String[][] data = new String[20][4];		
		int itemCount=0;
		String fileName = getFileName(productType);
		DataInputStream stream = new DataInputStream(FileHandler.class.getClassLoader().getResourceAsStream(fileName));
		BufferedReader bis = new BufferedReader(new InputStreamReader(stream));
		String fileLine="";
		try{
			 while ((fileLine =bis.readLine()) != null) {				 
	             // Read a record and write to data
				 String[] strings = fileLine.split("\\s");
				 for(int i=0;i<strings.length;i++)
					 data[itemCount][i]=strings[i];
	             itemCount++;
	         }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static String getFileName(String productType){
		String fileName="";
		if(MainCanvas.listCameras.equals(productType))
			fileName="camera.txt";
		else if(MainCanvas.listCellPhones.equals(productType))
			fileName="cellphone.txt";
		else if(MainCanvas.listDesktops.equals(productType))
			fileName="desktop.txt";
		else if(MainCanvas.listLaptops.equals(productType))
			fileName="laptop.txt";
		
		return fileName;
	}
}
