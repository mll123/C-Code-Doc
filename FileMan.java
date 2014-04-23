/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scodog;

import java.io.*;

/**
 *
 * @author Mike
 */
public class FileMan {
    private String FileName, Code="";
    private File MyCFile;
    private BufferedReader CodeReader;

    public FileMan(String FileNameArg)
    {
        this.FileName = FileNameArg;
        this.MyCFile = new File(FileName);
    }
    
    public File getCFile()
    {
        return MyCFile;
    }
    
    public String getCCode()
    {
        String myCode="";
        
        try
        {
            CodeReader=new BufferedReader(new FileReader(MyCFile));
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
        
        try
        {
            while ((Code=CodeReader.readLine())!=null)
            {
                myCode = myCode+Code;
            }
         
         /* myCode = CodeReader.readLine();*/
        }
        catch(IOException ReadLineIOE)
        {
            System.out.println(ReadLineIOE.getMessage());
        }
        if (myCode == null)
            myCode = "No text in the first line"; 
        return myCode;
    }
}
