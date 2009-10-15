package com.eshop.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.eshop.gui.StartShop;

public class AllActionHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		StartShop.myShop.addToWorkArea(new JLabel(e.getActionCommand()));
	}
	

}
