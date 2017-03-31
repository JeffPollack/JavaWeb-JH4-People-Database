/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneliners;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 *
 * @author Jeff
 */
public class OneLinerInit {
    
    
        public static String init(ServletConfig sc, ServletContext sctx) {

        String fullFilePath = "";   
       
        String lineFile = sc.getInitParameter("lineFile");
        String linePath = sc.getInitParameter("linePath");
        
        System.out.println("lineFile="+ lineFile);
        System.out.println("linePath="+linePath);

        String pathSeparator = System.getProperty("file.separator");
        
        if (linePath == null)
            linePath="";
        else
            linePath = linePath.trim();
        
        if (lineFile == null)
            lineFile="oneliners.txt";
        
        if ( linePath.length() == 0)
        {
            fullFilePath = sctx.getRealPath("/WEB-INF/")+pathSeparator+lineFile;
            System.out.println("fullFilePath="+fullFilePath); // just checking
        }
        else
        {
            //fullFilePath = System.getProperty("user.home")+"/" + guestPath + "/" + guestFile;
            
            fullFilePath = System.getProperty("user.home")+ pathSeparator + linePath + pathSeparator + lineFile;
        }
        System.out.println("From JSP: fullFilePath="+ fullFilePath);
        
        return fullFilePath;
    }
    
    
    
}
