/*
 * Gift.java
 *
 * Created on September 3, 2009, 9:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker;

import java.util.Hashtable;

/**
 *
 * @author name
 */
public class Gift {
    /**
     * Gift Name
     */
    private String giftName = null;
    /**
     * Price of Gift
     */
    private float  giftPrice = 0.0F;
    /**
     * Hashtable which stores Invetory IDs and required quantity
     */
    private java.util.Hashtable material = null;
    /** Creates a new instance of Gift */
    public Gift() {
    }
    
    public Gift(Gift gift){
    	this.giftName=gift.giftName;
    	this.giftPrice=gift.giftPrice;
    	this.material=gift.material;
    }
    
    public String getGiftName() {
        return giftName;
    }
    
    public void setGiftName(String giftName) {
        this.giftName=giftName;
    }
    
    public float getGiftPrice() {
        return giftPrice;
    }
    public void setGiftPrice(float giftPrice) {
        this.giftPrice=giftPrice;
    }
    
    public void setMaterial(Hashtable material) {
        this.material = material;
    }
    public  Hashtable getMaterial() {
        return material;
    }
}
