package giftsmaker.latest;

import giftsmaker.Gift;
import giftsmaker.GiftsConstants;
import giftsmaker.GiftsInventory;
import giftsmaker.common.CommandProcessor;
import giftsmaker.common.GiftProduct;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICommandProcessor implements CommandProcessor{
	
	private Object result;
	GiftProduct giftProduct = new GiftProductGUI();
	
	public Object processCommand(int command) {
		switch (command) {
		case 1:
			result = giftProduct.showGifts();
			break;
		case 2:
			GiftsInventory gft = new GiftsInventory();
			result = gft.showStocksGUI(GiftsConstants.STOCKSFILE);
			break;
		case 3:
			result = (Component) giftProduct.showGiftsWithSno();
			break;
		case 4:
			GiftProductsXMLInventory.writeProductsInventory(giftProduct);
			result = new JLabel("Products Inventory is persisted to XML database");
			break;
		case 5:
			giftProduct.setGifts(GiftProductsXMLInventory.readProductsInventory());
			result = new JLabel("Products Inventory is loaded from XML database");
			break;		
		case 6:
			final JPanel panel = new JPanel();			
			final JTextField inventoryName = new JTextField(10);
			final JTextField inventoryQty = new JTextField(3);
			JButton button = new JButton("Add Inventory");
			button.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent ae) {			         
			          giftProduct.addNewInventoryItem(inventoryName.getText(), 
			        		  Integer.parseInt(inventoryQty.getText()));
			          JOptionPane.showMessageDialog(panel, "New Inventory item added successfully");
			        }
			      });
			
			panel.add(new JLabel("Enter the new Inventory name and quantity "));			
			panel.add(inventoryName);
			panel.add(inventoryQty);
			panel.add(button);
			result = panel;
			break;	
		case 7:
			final  JPanel newProductPanel = new JPanel();			
			final JTextField pName = new JTextField(10);			
			final JTextField pCost = new JTextField(3);
			final JTextField invtQty = new JTextField(3);
			final JComboBox invCombo = new JComboBox(new String[]{"IV1","IV2","IV3"});
			JButton addProdbutton = new JButton("Add Product");
			addProdbutton.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent ae) {			         
			          giftProduct.addNewProduct(pName.getText(),Float.parseFloat(pCost.getText()),(String)invCombo.getSelectedItem(),
			        		  Integer.parseInt(invtQty.getText()));
			          JOptionPane.showMessageDialog(newProductPanel, "New Product added successfully");
			        }
			      });
			
			newProductPanel.add(new JLabel("Enter the new Product name "));			
			newProductPanel.add(pName);
			newProductPanel.add(new JLabel("Cost"));
			newProductPanel.add(pCost);
			newProductPanel.add(new JLabel("Inventory type"));
			newProductPanel.add(invCombo);
			newProductPanel.add(new JLabel("required qty"));
			newProductPanel.add(invtQty);
			newProductPanel.add(addProdbutton);
			result = newProductPanel;
			break;		
		default:
			System.out.println("Invalid choice.");
			result = new JLabel("Invalid choice");

		}
		return result;
	}

	public Object checkRequired(int productNumber){
		return giftProduct.checkRequiredInventory(productNumber);
	}
	
	public void manufactureNewProduct(int productSno){
		Gift[] currentGiftProducts = giftProduct.getGifts();
		Gift productToMake = currentGiftProducts[productSno];
		Gift newProduct = new Gift(productToMake);
		currentGiftProducts[currentGiftProducts.length]=newProduct;		
	}
}

