package com.eshop.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.eshop.gui.handler.AllActionHandler;

public class MainCanvas extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	AddForm addform;
	Container container;
	MainCanvas(){
		container = this.getContentPane();
		
		listCemeras.setBounds(50,20,100,40);
		listCellPhone.setBounds(150,20,100,40);
		listDesktop.setBounds(250,20,100,40);
		listLaptop.setBounds(350,20,100,40);
		
		listCemeras.addActionListener(handler);
		listCellPhone.addActionListener(handler);
		listDesktop.addActionListener(handler);
		listLaptop.addActionListener(handler);
		
		menuBar.setLayout(null);
		menuBar.add(listCemeras);		
		menuBar.add(listCellPhone);
		menuBar.add(listDesktop);
		menuBar.add(listLaptop);
		
		workArea.setLayout(null);
		workArea.setSize(400,400);
		JLabel jl = new JLabel("Work area");
		jl.setBounds(60,60,100,100);
		workArea.add(jl);
		workArea.setBounds(0,50,800,850);
		
		menuBar.add(workArea);
		menuBar.setSize(50,800);
		container.add(menuBar,BorderLayout.CENTER);
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
	
	public void addToWorkArea(Component c){				
		c.setBounds(50,200,800,850);
		workArea.add(c);
		this.repaint();
	}
	
	public Container getWrokArea(){
		return workArea;
	}

	public AddForm getAddform() {
		return addform;
	}

	public void setAddform(AddForm addform) {
		this.addform = addform;
	}
}
