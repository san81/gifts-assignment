/*
 * StartMenu.java
 *
 * Created on September 3, 2009, 6:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker;

import giftsmaker.common.GiftProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author name
 */
public class StartMenu {
    
    /** Creates a new instance of StartMenu */
    public StartMenu() {
        
    }
    /**
     * main method - starting point of execution
     */
    public static void main(String args[]) {
        
        // Check whether Database file exists before application is started
        GiftsUtil.validateFile(GiftsConstants.STOCKSFILE);
        GiftProduct giftProduct = new GiftProductCUI();
        
        int inputNum = 0;
        
        for (;;) {
            System.out.println(" *** Please choose your actions as per below Menu ***");
            System.out.println("1  -> All availble products");
            System.out.println("2  -> All availble inventories");
            System.out.println("3  -> Can I make a product with available inventory?");
            System.out.print("Input choice:");
            
            try {
                BufferedReader bufRdr = new BufferedReader(new InputStreamReader(System.in));
                inputNum = Integer.parseInt(bufRdr.readLine());
                System.out.println(inputNum);
                
            } catch (NumberFormatException exception) {
                System.out.println("Your input is not recognized, Please eneter again!");
            } catch (IOException exception) {
                System.out.println("System Error:"+exception.getMessage());
            } catch (Exception exception){
                System.out.println("Unknown Error:"+exception.getMessage());
            }
            
            if (inputNum==1) {
                System.out.println(giftProduct.showGifts());
            }else if(inputNum==2) {
                GiftsInventory gft = new GiftsInventory();
                System.out.println(gft.showStocks(GiftsConstants.STOCKSFILE));
            }else if(inputNum==3) {
                System.out.println(giftProduct.showGiftsWithSno());
                try {
                    System.out.print("Please enter from Serial number from above list:");
                    BufferedReader bufRdr = new BufferedReader(new InputStreamReader(System.in));
                    inputNum = Integer.parseInt(bufRdr.readLine());
                    
                    giftProduct.checkRequiredInventory(inputNum);
                    
                } catch (NumberFormatException exception) {
                    System.out.println("Your input is not recognized, Please eneter again!");
                } catch (IOException exception) {
                    System.out.println("System Error:"+exception.getMessage());
                }catch (Exception exception){
                    System.out.println("Unknown Error:"+exception.getMessage());
                }
            } else {
                System.out.println("Invalid choice.");
            }
            
            System.out.print("Do you wish to continue y/n :");
            try{
                BufferedReader bufRdr = new BufferedReader(new InputStreamReader(System.in));
                String option = bufRdr.readLine();
                if(option.equalsIgnoreCase("Y")) {
                    continue;
                }else{
                    System.out.println("Thank you for using!");
                    System.exit(0);
                }} catch (IOException exception) {
                    System.out.println("System Error:"+exception.getMessage());
                }
        }
    }
}
