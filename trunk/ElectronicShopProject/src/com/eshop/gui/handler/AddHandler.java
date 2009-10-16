package com.eshop.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.eshop.gui.AddForm;
import com.eshop.gui.StartShop;

public class AddHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String fileName = FileHandler.getFileName("List "+command.substring(8).trim());
		AddForm addform = StartShop.myShop.getAddform();
		FileHandler.addRecord(fileName, addform.getCodeTxt(),
				addform.getMakeTxt(), addform.getModelTxt(), addform.getQtyTxt());
	}
	
}
