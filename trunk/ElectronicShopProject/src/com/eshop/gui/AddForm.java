package com.eshop.gui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.eshop.gui.handler.AddHandler;

public class AddForm {
	
	JLabel code = new JLabel("Product Code");
	JLabel make = new JLabel("Make");
	JLabel model = new JLabel("Model");
	JLabel qty = new JLabel("Qty");
	
	JTextField codeTxt = new JTextField();
	JTextField makeTxt = new JTextField();
	JTextField modelTxt = new JTextField();
	JTextField qtyTxt = new JTextField();
	
	public void createAddForm(String item){
		
		
		code.setBounds(50,60,100,40);
		make.setBounds(150,60,100,40);
		model.setBounds(250,60,100,40);
		qty.setBounds(350,60,100,40);
		
		
		
		JButton addButton = new JButton("Add New "+item);
		addButton.addActionListener(new AddHandler());
		
		codeTxt.setBounds(50,100,100,40);
		makeTxt.setBounds(150,100,100,40);
		modelTxt.setBounds(250,100,100,40);
		qtyTxt.setBounds(350,100,100,40);
		
		addButton.setBounds(450,100,150,40);
		
		Container c = StartShop.myShop.getWrokArea();
		c.add(code);
		c.add(make);
		c.add(model);
		c.add(qty);
		c.add(codeTxt);
		c.add(makeTxt);
		c.add(modelTxt);
		c.add(qtyTxt);
		c.add(addButton);
	}
	
	public String getCodeTxt(){
		return codeTxt.getText();
	}
	public String getMakeTxt(){
		return makeTxt.getText();
	}
	public String getModelTxt(){
		return modelTxt.getText();
	}
	public String getQtyTxt(){
		return qtyTxt.getText();
	}
}
