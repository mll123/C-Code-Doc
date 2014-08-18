/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scodog;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class GenDoc {
    private ArrayList<String> keywordslist;
    private ArrayList<String> datatypeslist;
    private ArrayList<String> functionslist;
    
    public GenDoc()
    {
        keywordslist=new ArrayList<String>();
        datatypeslist=new ArrayList<String>();
        
        /*---------------------------------------------------*/
        if (!(keywordslist.add("if"))){
            System.out.println("Problem adding keyword - if");
        }
        if (!(keywordslist.add("while"))){
            System.out.println("Problem adding keyword - while");
        }
        if (!(keywordslist.add("for"))){
            System.out.println("Problem adding keyword - for");
        }    
            
        /*--------------------------------------------------*/
        
        if (!(datatypeslist.add("int"))){
            System.out.println("Problem adding keyword - int");
        }
        if (!(datatypeslist.add("double"))){
            System.out.println("Problem adding keyword - double");
        }
        if (!(datatypeslist.add("float"))){
            System.out.println("Problem adding keyword - float");
        }
        if (!(datatypeslist.add("String"))){
            System.out.println("Problem adding keyword - String");
        }
        if (!(datatypeslist.add("char"))){
            System.out.println("Problem adding keyword - char");
        }

        
    }
    
    boolean isIncludeDirective(String Sline){
        //char sq=S.charAt(0);
        String S[] = Sline.split(" ",2);
        return (S[0].equals("#include"));
    }
    
    boolean isMainFun(String Strline) 
    {
        String S[] = Strline.split("\\(",2);
        return (S[0].equals("int main"));
    }
    
    public String genText(String CodeLine)
    {
        String myText="False";
        
        if (isMainFun(CodeLine))
        {
            myText="Doc has main function";
        }
        if (isIncludeDirective(CodeLine))
        {
            myText="Doc has directive";
        }
        return myText;
    }
}
