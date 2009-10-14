/*
 * GiftProduct.java
 *
 * Created on September 3, 2009, 9:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker.latest;


import giftsmaker.Gift;
import giftsmaker.GiftsConstants;
import giftsmaker.common.GiftProduct;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author name
 */
public class GiftProductGUI implements GiftProduct{
    
    private Gift[] gifts = null;
    String data[][] = {{"TeddyBear", "10.00", "IV1,IV5,IV4"},
            {"MickeyMouse", "24.00", "IV6,IV5,IV4"},
            {"BarbieDoll", "34.00", "IV2,IV4,IV1"},
            {"TinTin", "54.00", "IV7,IV6,IV4"},
            {"Aeroplane", "76.00", "IV1,IV3,IV2"},
            {"RemoteBike", "123.00", "IV3,IV2,IV1"},
            {"Car", "200.00", "IV1,IV5,IV4"},
    };

    String fields[] = {"Gift Item Name", "Price", "Material"};
    /** Creates a new instance of GiftProduct */
    public GiftProductGUI() {
        loadProducts();
    }
    /**
     * Intialize system by loading all products
     */
    public void loadProducts() {
        gifts = new Gift[GiftsConstants.MAXITEMS];
        gifts[0] = new Gift();
        gifts[0].setGiftName("TeddyBear");
        gifts[0].setGiftPrice(24.00F);
        Hashtable ht0 = new Hashtable();
        ht0.put("IV1",new Integer(2));
        ht0.put("IV5",new Integer(6));
        ht0.put("IV4",new Integer(3));
        gifts[0].setMaterial(ht0);
        
        gifts[1] = new Gift();
        gifts[1].setGiftName("MickeyMouse");
        gifts[1].setGiftPrice(10.00F);
        Hashtable ht1 = new Hashtable();
        ht1.put("IV11",new Integer(2));
        ht1.put("IV5",new Integer(3));
        ht1.put("IV4",new Integer(3));
        ht1.put("IV9",new Integer(3));
        gifts[1].setMaterial(ht1);
        
        gifts[2] = new Gift();
        gifts[2].setGiftName("BarbieDoll");
        gifts[2].setGiftPrice(104.00F);
        Hashtable ht2 = new Hashtable();
        ht2.put("IV1",new Integer(2));
        ht2.put("IV5",new Integer(6));
        ht2.put("IV6",new Integer(3));
        gifts[2].setMaterial(ht2);
        
        gifts[3] = new Gift();
        gifts[3].setGiftName("TinTin");
        gifts[3].setGiftPrice(10.00F);
        Hashtable ht3 = new Hashtable();
        ht3.put("IV10",new Integer(2));
        ht3.put("IV5",new Integer(6));
        ht3.put("IV4",new Integer(3));
        gifts[3].setMaterial(ht3);
        
        gifts[4] = new Gift();
        gifts[4].setGiftName("Aeroplane");
        gifts[4].setGiftPrice(24.00F);
        Hashtable ht4 = new Hashtable();
        ht4.put("IV11",new Integer(2));
        ht4.put("IV5",new Integer(6));
        ht4.put("IV6",new Integer(3));
        gifts[4].setMaterial(ht4);
        
        gifts[5] = new Gift();
        gifts[5].setGiftName("RemoteBike");
        gifts[5].setGiftPrice(24.00F);
        Hashtable ht5 = new Hashtable();
        ht5.put("IV1",new Integer(2));
        ht5.put("IV5",new Integer(6));
        ht5.put("IV4",new Integer(3));
        gifts[5].setMaterial(ht5);
        
        gifts[6] = new Gift();
        gifts[6].setGiftName("Car");
        gifts[6].setGiftPrice(24.00F);
        Hashtable ht6 = new Hashtable();
        ht6.put("IV1",new Integer(2));
        ht6.put("IV5",new Integer(60));
        ht6.put("IV4",new Integer(3));
        gifts[6].setMaterial(ht6);
        
    }
    /**
     * Show all gifts
     */
    public  Object showGifts() {
    	JTable jt = new JTable( data, fields );
        JScrollPane pane = new JScrollPane( jt );
        return jt;
    }
    /**
     * Same as show all gifts method, this shows serial number
     */
    public  Object showGiftsWithSno() {
    	 String data[][] = new String[gifts.length][3];
    	 String fields[] = {"Sno","Product Name", "Price"};
    	String result="**** All Availbale Products ***\n";
        for(int c=0;c<gifts.length;c++) {
            Gift gf = gifts[c];
            if(gf==null) break;
            data[c][0]=c+1+"";
            data[c][1]=gf.getGiftName();
            data[c][2]=gf.getGiftPrice()+"";            
        }
        return new JTable(data,fields);
    }
    /**
     * Check manfacturing decision by comparing required and avaible qunatity for a specific product
     * @param inputNum  Sequence number as shown in display
     */
    public Object checkRequiredInventory(int inputNum) {
    	String result="";
        try{
            String str = null;
            String key = null;
            String name = null;
            int invCount = 0;
            int requiredCount;
            boolean isLow = false;
            Gift checkGift = gifts[inputNum-1];
            Hashtable ht = checkGift.getMaterial();
            //Open the file for both reading and writing
            RandomAccessFile rand = new RandomAccessFile(GiftsConstants.TMP_FOLDER+GiftsConstants.STOCKSFILE,"r");
            rand.seek(0);  //Seek to start point of file
            InventoryMgt.inventoryItemCount=1;
            while((str=rand.readLine()) != null) {
            	InventoryMgt.inventoryItemCount++;
                StringTokenizer fields = new StringTokenizer(str,";");
                key = fields.nextToken();
                name = fields.nextToken();
                invCount = Integer.parseInt(fields.nextToken());
                
                if(ht.get(key)!=null) {
                    
                    Integer intObj = (Integer)ht.get(key);
                    requiredCount = intObj.intValue();
                    if(invCount>=requiredCount) {
                        result+=name +"  is available. Required Qunatity:"+requiredCount +" Availble Qunatity:"+invCount+"\n";
                    }else {
                        result+=name +"  is NOT available. Required Qunatity:"+requiredCount +" Availble Qunatity:"+invCount+"\n";
                        isLow = true;
                    }
                }
                
            }
            rand.close();
            if(isLow == true) {
                result+="\n\nProduct can not be produced as invetory is low, Please order invetory";
            }else{
                result+="\n\n Product can be produced as invetory is sufficient, Please proceed";
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	public Gift[] getGifts() {
		return gifts;
	}
	public void setGifts(Gift[] gifts) {
		this.gifts = gifts;
	}
	
	public void addNewInventoryItem(String name, int quantity) {
		InventoryMgt.addNewInventory(name, quantity);		
	}
	public void addNewProduct(String name,float cost,String invtory,int invQty){
		String newData[][] = new String[data.length+1][3];
		for(int i=0;i<data.length;i++)
			for(int j=0;j<3;j++)
				newData[i][j]=data[i][j];
		newData[data.length]=new String[]{name,new Float(cost).toString(),invtory};
		data=newData;
		//List dataList= Arrays.asList(data);		
		//dataList.add(new String[]{name,new Float(cost).toString(),invtory});
		Gift[] gifts= getGifts();
		Gift newGift = new Gift();
		newGift.setGiftName(name);
		newGift.setGiftPrice(cost);
		Hashtable material = new Hashtable();
		material.put(invtory, new Integer(invQty));
		newGift.setMaterial(material);
		gifts[data.length]=newGift;
		//dataList.add(new Gift[]);
		
	}
}
