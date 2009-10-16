package com.eshop.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.eshop.gui.AddForm;
import com.eshop.gui.StartShop;

public class AllActionHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		StartShop.myShop.getWrokArea().removeAll();
		AddForm addform = new AddForm();
		StartShop.myShop.setAddform(addform);
		addform.createAddForm(command.substring(4));
		String[] fields = {"ItemCode","Made","Model","Qty"};
		JTable prodTable = new JTable(FileHandler.getList(e.getActionCommand()),fields);
		//prodTable.setBounds(0,50,1500,1450);
		StartShop.myShop.addToWorkArea(prodTable);
	}

}
