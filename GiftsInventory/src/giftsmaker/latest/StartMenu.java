/*
 * StartMenu.java
 *
 * Created on September 3, 2009, 6:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker.latest;

import giftsmaker.GiftsConstants;
import giftsmaker.GiftsUtil;
import giftsmaker.common.CommandProcessor;

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
        GiftsUtil.validateFile(GiftsConstants.STOCKSFILE_XML);
        CommandProcessor processor=new CUICommandProcessor();
        
        int inputNum = 0;
        
        for (;;) {
            System.out.println(" *** Please choose your actions as per below Menu ***");
            System.out.println("1  -> All availble products");
            System.out.println("2  -> All availble inventories");
            System.out.println("3  -> Can I make a product with available inventory?");
            System.out.println("4  -> Store inventory data to the STOCKFILE.XML");
            System.out.println("5  -> Load inventory data from the STOCKFILE.XML");
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
            
            
            //process the user give command
            System.out.println(processor.processCommand(inputNum));
            
            
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
