/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scodog;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author Administrator
 */
public class GenDoc {
    private ArrayList<String> keywordslist;
    private ArrayList<String> datatypeslist;
    private ArrayList<String> functionslist;
    private boolean mainFunc;
    private boolean hasBeenMainFunc;
    public ArrayList<String> includeFileName;
    public ArrayList<String> variables;
    
    public GenDoc()
    {
        keywordslist=new ArrayList<String>();
        datatypeslist=new ArrayList<String>();
        includeFileName = new ArrayList<String>();
        variables = new ArrayList<String>();
        mainFunc = false;
        hasBeenMainFunc = false;
        
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
        if (S[0].equals("#include"))
            includeFileName.add(S[1]);
        //System.out.println("The length of S is "+S.length);
        return (S[0].equals("#include"));
    }
    
    boolean isMainFun(String Strline) 
    {
        String S[] = Strline.split("\\(",2);
        return (S[0].equals("int main"));
    }
    
    boolean isAssignStm(String StrLine)
    {
        //String S[] = StrLine.split(" ",0);
        String PatStr = ".*=.*";
        Pattern MyPat = Pattern.compile(PatStr);
        Matcher MyMatch = MyPat.matcher(StrLine);
        if (MyMatch.matches())
        {
                String S[] = StrLine.split("=",2);
                String T[] = S[0].split(" ",2);
                variables.add(T[1]);
        }
        return MyMatch.matches();
    }
    
    public String genText(String CodeLine)
    {
        String myText="False";
        if (isIncludeDirective(CodeLine))
        {
            myText="Doc has \"include\" directive";
            myText=myText+" and the include filename is "+includeFileName.get(0);
        }

        if (isMainFun(CodeLine)) //Hunt for main function
        {
            if (!mainFunc) {
                mainFunc = true;
                hasBeenMainFunc = true;
            }
            else
            {
                myText="Error: Double nested main function detected!!";
            }
            myText="The main function does the following: ";
        }
        
        if (mainFunc)
        {
            if (isAssignStm(CodeLine))
            {
                myText = "Assignment statement.";
                myText = myText + " Variable "+ variables.get(variables.size() - 1);
                myText = myText + " gets a value.";
            }
                    
        }
        return myText;
    }
}
