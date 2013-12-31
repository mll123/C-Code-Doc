/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccodedoc;

import java.util.regex.*;

/**
 *
 * @author Mike
 */
public class CCodeDoc {

    public String getMatch(String expression)
    {
       /**
        * Searches for the match pattern in a text document.
        * @return Match the matched pattern in the text document
        */
        return expression;
        
    }
          
    public static void main(String[] args) {
    /**
     * @param args the command line arguments
     */
        
        String pattern = "";
        int i;

        // TODO code application logic here
        if (!args[0].isEmpty())
        {
            for (i=0;i<args.length;i++)
            {
                pattern = pattern+" "+args[i];
            }
            CCodeDoc MyCDoc = new CCodeDoc();
            System.out.println();
            System.out.println("The number of arguments = "+args.length);
            System.out.println("Matched the pattern: "+MyCDoc.getMatch(pattern)+".");

        }
        else
        {
            System.out.println("Please provide search pattern text!");
        }
                
    }
    
}
