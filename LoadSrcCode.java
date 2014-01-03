/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccodedoc;

import java.io.*;

/**
 *
 * @author Mike
 */
public class LoadSrcCode {
    private String filename, code="";
    private File MyCFile;
    private BufferedReader codeReader;

    public LoadSrcCode(String filename)
    {
        this.filename = filename;
        this.MyCFile = new File(filename);
    }
    
    public File getCFile()
    {
        return MyCFile;
    }
    
    public String getCcode()
    {
        String myCode="";
        
        try
        {
            codeReader=new BufferedReader(new FileReader(MyCFile));
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
        
        try
        {
            while ((code=codeReader.readLine())!=null)
            {
                myCode = myCode+code;
            }
        }
        catch(IOException readLineIOE)
        {
            System.out.println(readLineIOE.getMessage());
        }
        
        return myCode;
    }
}
