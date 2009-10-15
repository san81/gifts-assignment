package com.eshop.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.eshop.gui.handler.AllActionHandler;

public class MainCanvas extends JFrame{
	public static String listCameras = "List Cemeras";
	public static String listCellPhones = "List Cellphone";
	public static String listDesktops = "List desktops";
	public static String listLaptops = "List laptop";
	
	JButton listCemeras = new JButton(listCameras);
	JButton listCellPhone = new JButton(listCellPhones);
	JButton listDesktop = new JButton(listDesktops);
	JButton listLaptop = new JButton(listLaptops);
	Container menuBar = new Container();
	Container workArea = new Container();
	AllActionHandler handler = new AllActionHandler();
	Container container;
	MainCanvas(){
		container = this.getContentPane();
		
		listCemeras.setBounds(50,20,100,40);
		listCellPhone.setBounds(150,20,100,40);
		listCemeras.addActionListener(handler);
		listCellPhone.addActionListener(handler);
		
		menuBar.setLayout(null);
		menuBar.add(listCemeras);		
		menuBar.add(listCellPhone);
		
		workArea.setLayout(null);
		workArea.setSize(400,400);
		JLabel jl = new JLabel("Work area");
		jl.setBounds(60,60,100,100);
		workArea.add(jl);
		workArea.setBounds(0,50,500,450);
		
		menuBar.add(workArea);
		menuBar.setSize(50,500);
		container.add(menuBar,BorderLayout.CENTER);
		this.setSize(500,500);
		this.show();
	}
	
	public void addToWorkArea(Component c){
		workArea.removeAll();
		c.setBounds(60,60,100,100);
		workArea.add(c);
		this.repaint();
	}
	
}
