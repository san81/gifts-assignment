package giftsmaker.latest;

import giftsmaker.Gift;
import giftsmaker.GiftProductCUI;
import giftsmaker.GiftsConstants;
import giftsmaker.common.GiftProduct;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Class for reading and writing the products Inventory information to the XML
 * data base file using XMLEncoder/Decoder
 * 
 * @author Santhosh
 * 
 */
public class GiftProductsXMLInventory {

	public static void writeProductsInventory(GiftProduct products) {

		try {
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(GiftsConstants.STOCKSFILE_XML)));
			Gift[] gifts = products.getGifts();
			for (int i = 0; i < gifts.length; i++)
				encoder.writeObject(gifts[i]);
			encoder.close();
			System.out.println("Products Inventory XML Database is updated.");

		} catch (FileNotFoundException e) {
			System.out.println("XML Products inventory file is not available ");
			e.printStackTrace();
		}

	}

	public static Gift[] readProductsInventory() {
		
		XMLDecoder decoder=null;
		Gift[] gifts=null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(GiftsConstants.STOCKSFILE_XML)));
			System.out.println(decoder.getOwner());
			gifts = new Gift[GiftsConstants.MAXITEMS];
			int i=0;
			while(true)
				gifts[i++] = (Gift)decoder.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("XML products inventory file is not available.");
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			decoder.close();
		}
		
		return gifts;
	}
}
