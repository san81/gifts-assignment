/*
 * GiftsInventory.java
 *
 * Created on September 3, 2009, 7:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker;

import giftsmaker.common.MoveResources;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JTable;

/**
 *
 * @author name
 */
public class GiftsInventory {
    
    /** Creates a new instance of GiftsInventory */
    public GiftsInventory() {
    }
    /**
     * Show all stocks/invertory from database file
     */
    public String showStocks(final String fileName) {
        String result="";
        File file = new File(fileName);
        FileInputStream fis = null;
        BufferedReader bis = null;
        DataInputStream dis = null;
        String fileLine = null;
        
        try {
        	 fis = new FileInputStream(file);
            dis = new DataInputStream(this.getClass().getClassLoader().getResourceAsStream(fileName));
            bis = new BufferedReader(new InputStreamReader(dis));
            
            while ((fileLine =bis.readLine()) != null) {
                // Read a record and write to console
                fileLine=fileLine.replace(';','\t');
                result+=fileLine+"\n";
            }
            
            // Release all the resources right afrer proceessing.
            fis.close();
            bis.close();
            dis.close();
           
        } catch (FileNotFoundException e) {
            System.out.println("Database File could not be located.");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("System Error whiel reading from disk.");
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    public JTable showStocksGUI(final String fileName){
    	String data[][] = new String[50][12];

        String fields[] = {"Inventory Code", "Name", "Quantity"};
        String fileLine = null;
        BufferedReader bis = null;
        
        try {   
             bis = MoveResources.getInventoryFileStream();
             int row=0;
            while ((fileLine =bis.readLine()) != null) {
                // Read a record and write to console
            	StringTokenizer tokenizer = new StringTokenizer(fileLine,";");
            	int tokensCount=tokenizer.countTokens();
            	for(int col=0;col<tokensCount;col++)
            		data[row][col]=tokenizer.nextToken(); 
            	row++;
            }
            
            // Release all the resources right afrer proceessing.           
            bis.close();
            //dis.close();
           
        } catch (FileNotFoundException e) {
            System.out.println("Database File could not be located.");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("System Error whiel reading from disk.");
            System.err.println(e.getMessage());
        }
        return new JTable( data, fields );
    }
}
