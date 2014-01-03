/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccodedoc;

import java.util.regex.*;
import java.io.*;

/**
 *
 * @author Mike
 */
public class CCodeDoc {

    public String getPattern(String patternArg)
    {
       /**
        * Searches for the match pattern in a text document.
        * @return Match the matched pattern in the text document
        */
        return patternArg;
        
    }
          
    public static void main(String[] args) {
    /**
     * @param args the command line arguments
     */
        
        String pattern;
        int i;

        // TODO code application logic here
        if (args.length > 0)
        {
            pattern = args[0];
            
            CCodeDoc MyCDoc = new CCodeDoc();
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("The number of arguments = "+args.length);
            System.out.println("Matched the pattern: "+MyCDoc.getPattern(pattern)+".");
            
            
            System.out.println("----------------------------------------------------");
            System.out.println();
            
            if (args.length > 1)
            {
                LoadSrcCode LSC = new LoadSrcCode(args[1]);
                File CFile = LSC.getCFile();
                System.out.println(CFile.getPath());
                System.out.println();
                System.out.println("----------------------------------------------------");
                System.out.println("");
                System.out.println("Content of first line in requested file:");
                System.out.println(LSC.getCcode());
            }
        }
        else
        {
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Please provide search pattern text!");
            System.out.println();
            System.out.print("Command: java -jar CCodeDoc.jar \"pattern\" textfile ");
            System.out.println();
        }
                
    }
    
}
