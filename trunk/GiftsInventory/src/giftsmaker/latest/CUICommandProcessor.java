package giftsmaker.latest;

import giftsmaker.Gift;
import giftsmaker.GiftProductCUI;
import giftsmaker.GiftsConstants;
import giftsmaker.GiftsInventory;
import giftsmaker.common.CommandProcessor;
import giftsmaker.common.GiftProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CUICommandProcessor implements CommandProcessor {

	private String result;		
	GiftProduct giftProduct = new GiftProductCUI();
	
	public Object processCommand(int command) {
		switch (command) {
		case 1:
			result = (String) giftProduct.showGifts();
			break;
		case 2:
			GiftsInventory gft = new GiftsInventory();
			result = gft.showStocks(GiftsConstants.STOCKSFILE);
			break;
		case 3:
			result = (String) giftProduct.showGiftsWithSno();
			try {
				result += "\n\nPlease enter from Serial number from above list:";
				System.out.println(result);
				BufferedReader bufRdr = new BufferedReader(
						new InputStreamReader(System.in));
				int inputNum = Integer.parseInt(bufRdr.readLine());

				result += giftProduct.checkRequiredInventory(inputNum);

			} catch (NumberFormatException exception) {
				System.out
						.println("Your input is not recognized, Please eneter again!");
			} catch (IOException exception) {
				System.out.println("System Error:" + exception.getMessage());
			} catch (Exception exception) {
				System.out.println("Unknown Error:" + exception.getMessage());
			}
			break;
		case 4:
			GiftProductsXMLInventory.writeProductsInventory(giftProduct);
			result = "Products Inventory is persisted to XML database";
			break;
		case 5:
			giftProduct.setGifts(GiftProductsXMLInventory.readProductsInventory());
			result = "Products Inventory is loaded from XML database";
			break;
		default:
			System.out.println("Invalid choice.");
			result = "Invalid choice";

		}
		return result;
	}
	
	public void manufactureNewProduct(int productSno){
		Gift[] currentGiftProducts = giftProduct.getGifts();
		Gift productToMake = currentGiftProducts[productSno];
		Gift newProduct = new Gift(productToMake);
		currentGiftProducts[currentGiftProducts.length]=newProduct;		
	}
	
}
