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
    private boolean ifBlock;
    private boolean whileBlock;
    private boolean forBlock;
    public ArrayList<String> includeFileName;
    public ArrayList<String> variables;
    public ArrayList<String> ifStmts;
    public ArrayList<String> whileStmts;
    public ArrayList<String> forStmts;
    public ArrayList<String> ifStmtBlks;
    public ArrayList<String> whileStmtBlks;
    public ArrayList<String> forStmtBlks;
    public ArrayList<String> FunctionCalls;
    public ArrayList<String> FunctionArgs;
    
    public GenDoc()
    {
        keywordslist=new ArrayList<String>();
        datatypeslist=new ArrayList<String>();
        includeFileName = new ArrayList<String>();
        variables = new ArrayList<String>();
        ifStmts = new ArrayList<String>();
        whileStmts = new ArrayList<String>();
        forStmts = new ArrayList<String>();
        ifStmtBlks = new ArrayList<String>();
        whileStmtBlks = new ArrayList<String>();
        forStmtBlks = new ArrayList<String>();
        FunctionCalls = new ArrayList<String>();
        FunctionArgs = new ArrayList<String>();
        mainFunc = false;
        hasBeenMainFunc = false;
        ifBlock = false;
        whileBlock = false;
        forBlock = false;
        
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
                //String T[] = S[0].split(" ",2);
                String V[] = S[0].split(" ",0);
                /*
                String pat = "\\t";
                Pattern extraPat = Pattern.compile(pat);
                Matcher extraMatch = extraPat.matcher(V[V.length - 1]);
                int i = 0;
                while (extraMatch.matches())
                {
                    i++;
                }
                System.out.print("Assignment testing for "+V[V.length -1]);
                System.out.println(" i = "+i);
                */
                variables.add((V[V.length - 1]).replaceAll("^\\s+", ""));
        }
        return MyMatch.matches();
    }
    
    boolean isIfSentence(String StrLine)
    {
        String PatStr = ".*if.*";
        Pattern MyPat = Pattern.compile(PatStr);
        Matcher MyMatch = MyPat.matcher(StrLine);
        if (MyMatch.matches())
            ifStmts.add(StrLine.substring((StrLine.indexOf("(")+1),StrLine.indexOf(")")));
        return MyMatch.matches();
    }
    
    boolean isWhileLoop(String StrLine)
    {
        String PatStr =".*while.*";
        Pattern MyPat = Pattern.compile(PatStr);
        Matcher MyMatch = MyPat.matcher(StrLine);
        if (MyMatch.matches())
            whileStmts.add(StrLine.substring((StrLine.indexOf("(")+1),StrLine.indexOf(")")));
        return MyMatch.matches();
    }
    
    boolean isFunctionCall(String StrLine)
    {
        String PatStr = ");";
        //Pattern MyPat = Pattern.compile(PatStr);
        //Matcher MyMatch = MyPat.matcher(StrLine);
        //if (MyMatch.matches())
        if (StrLine.contains(PatStr))
        {
            FunctionCalls.add(StrLine.substring(0, StrLine.indexOf("(")));
            FunctionArgs.add(StrLine.substring(StrLine.indexOf("("), StrLine.indexOf(")")+1));
        }
        return StrLine.contains(PatStr);
    }
    
    public String genText(String CodeLine)
    {
        String myText="";
        System.out.println("The code Line being processed now is "+ CodeLine);
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
            if (ifBlock)
            {
               //System.out.println("Hello' Code Line "+CodeLine);
                String neg1 = "\\s*\\{\\s*";
                String neg2 = ".*return.*";
                String neg3 = ".*\\}.*";
                Pattern myP1 = Pattern.compile(neg1);
                Matcher myM1 = myP1.matcher(CodeLine);
                Pattern myP2 = Pattern.compile(neg2);
                Matcher myM2 = myP2.matcher(CodeLine);
                Pattern myP3 = Pattern.compile(neg3);
                Matcher myM3 = myP3.matcher(CodeLine);
                
                if (!(myM1.matches())&&!(myM2.matches())&&!(myM3.matches()))
                {
                    System.out.println("Mike-Hello: The if exec code is "+CodeLine);
                    ifStmtBlks.add(CodeLine);
                //System.out.println("Mike : Here is the deal: " + ifStmtBlks.get(ifStmtBlks.size() - 1));
                    myText = "statement execution for if condition ";
                    myText = myText + ifStmts.get(ifStmts.size() - 1);
                } else
                {
                    System.out.println("Mike-Hello: The if exec code NOT EXECUTED is "+CodeLine);
                }
                /*Check for end of if block here*/
                String PatStr = ".*\\}.*";
                Pattern P = Pattern.compile(PatStr);
                Matcher M = P.matcher(CodeLine);
                if (M.matches())
                {
                    myText = myText + "End of IF statement block";
                    ifBlock = false;
                }
            }

            if (isAssignStm(CodeLine))
            {
                myText = myText + "Assignment statement.";
                myText = myText + " Variable "+ variables.get(variables.size() - 1);
                myText = myText + " gets a value.";
            }
            
            if (isIfSentence(CodeLine))
            {
                ifBlock = true;
                myText = myText + "\"if\" sentence condition: ";
                myText = myText + ifStmts.get(ifStmts.size() - 1);
            }
            
            if (isWhileLoop(CodeLine))
            {
                whileBlock = true;
                myText = myText + "\"while\" loop condition: ";
                myText = myText + whileStmts.get(whileStmts.size() - 1);
            }
            
            if (isFunctionCall(CodeLine))
            {
                myText = myText + " Function call made to ";
                myText = myText + FunctionCalls.get(FunctionCalls.size() - 1);
                myText = myText + " with arguments: ";
                myText = myText + FunctionArgs.get(FunctionArgs.size() - 1);
            }
                    
        }
        
        
        return myText;
    }
    
    
}
