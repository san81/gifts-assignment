package giftsmaker.common;

import giftsmaker.Gift;

public interface GiftProduct {
	
	public  Object showGifts();
	 public  Object showGiftsWithSno();
	 public Object checkRequiredInventory(int inputNum);
	 public Gift[] getGifts() ;
	 public void setGifts(Gift[] gifts);
}
