package com.company.general;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else if(ch==')' && !stack.empty() && stack.peek()=='(')
                stack.pop();
            else if(ch=='}' && !stack.empty() && stack.peek()=='{')
                stack.pop();
            else if(ch==']' && !stack.empty() && stack.peek()=='[')
                stack.pop();
            else if(ch==')' && !stack.empty() && stack.peek()!='('){
                flag=false;
                break;
            }
            else if(ch=='}' && !stack.empty() && stack.peek()!='{'){
                flag=false;
                break;
            }
            else if(ch==']' && !stack.empty() && stack.peek()!='['){
                flag=false;
                break;
            }
            else if (ch==')' || ch=='}' || ch==']') {
                flag=false;
                break;
            }
        }
        if(!stack.empty())
            flag=false;
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isValid("}"));

    }
}
