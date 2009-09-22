package giftsmaker.latest;

import giftsmaker.Gift;
import giftsmaker.GiftsConstants;
import giftsmaker.GiftsInventory;
import giftsmaker.common.CommandProcessor;
import giftsmaker.common.GiftProduct;

import java.awt.Component;

import javax.swing.JLabel;

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

