/*
 * GiftsUtil.java
 *
 * Created on September 3, 2009, 7:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package giftsmaker;

import java.io.File;

/**
 *
 * @author name
 */
public class GiftsUtil {
    
    /** Creates a new instance of GiftsUtil */
    public GiftsUtil() {
    }
     /**
     * Check for Database File before launching
     */
    public static void validateFile(String fileName)
    {
        File file = new File(fileName);
        System.out.println("____"+file.getAbsolutePath());
        if (!file.exists())
        {
              System.out.println("Database File "+fileName+" could not be located.");  
              System.out.println("Shutting down application...");
              System.exit(-1);
        }
        
        if (!file.canRead())
        {
              System.out.println("Database File "+fileName+" could not be read.");  
              System.out.println("Shutting down application...");
              System.exit(-1);
        }
        
        if (!file.canWrite())
        {
              System.out.println("Database File "+fileName+" does not have write permission.");  
              System.out.println("Shutting down application...");
              System.exit(-1);
        }
    
    }
    
}
