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
    private String filename;
    
    public LoadSrcCode(String filename)
    {
        this.filename = filename;
    }
    
    public File getCFile()
    {
        File MyCFile;
        
        MyCFile = new File(filename);
        return MyCFile;
    }
}
