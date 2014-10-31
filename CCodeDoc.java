/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scodog;

import java.util.regex.*;
import java.io.*;

/**
 *
 * @author Mike
 */
public class CCodeDoc {
    private String pattern;
    private String FileDir;
        
    public String getFileDir()
    {
        /**
         * The Directory containing the source code for analysis
         * @return source code directory
         */
        if (FileDir == null)
            FileDir = "";
        
        return FileDir;
    }
    
    public void setFileDir(String FileDirArg)
    {
        this.FileDir = FileDirArg;
        return;
    }
    
    
    public String[] stmt(String SourceCodeArg)
    {
       /**
        * Splits the returned source code into statements.
        * @return the statements in the code in a string array.
        */
        String[] mystmts;
        String line;
        String delimiters = "\\*/|\\.h>|\\{|;|\\}"; 
        mystmts = SourceCodeArg.split(":",0);
        return mystmts;
        
    }
          
    /*public static void main(String[] args) {
    */
    /**
     * @param args the command line arguments
     */
        
        //int i;
/*        String[] statement;
*/
        // TODO code application logic 
/*        if (args.length > 0)
        {
            
            CCodeDoc MyCDoc = new CCodeDoc();
            MyCDoc.setFileDir("C:\\Mike\\Komatech\\SCoDoG\\dist\\");
        
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("The number of arguments = "+args.length);
            
            System.out.println("----------------------------------------------------");
            System.out.println();
            
            if (args.length > 0)
            {
                FileMan LSC = new FileMan(MyCDoc.getFileDir()+args[0]);
                File CFile = LSC.getCFile();
                System.out.println(CFile.getPath());
                System.out.println();
                System.out.println("----------------------------------------------------");
                System.out.println("");
                System.out.println("Content of first line in requested file:");
                System.out.println(LSC.getCCode());
                System.out.println("----------------------------------------------------");
                
                System.out.print("Number of statements = ");
                statement = MyCDoc.stmt(LSC.getCCode());
                System.out.println(statement.length);
                System.out.println("----------------------------------------------------");
                for (int i=0;i<statement.length;i++)
                {
                    System.out.println("");
                    System.out.println("Statement no.: "+(i+1));
                    System.out.println(statement[i]);
                }
            }
        }
        else
        {
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Please provide ssource file name!");
            System.out.println();
            System.out.print("Command: java -jar \"C:\\Mike\\..\\SCoDog.jar\"  textfile ");
            System.out.println();
        }
                
    }
    */
}
