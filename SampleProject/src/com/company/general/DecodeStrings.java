package com.company.general;

import java.util.Collections;
import java.util.Stack;

public class DecodeStrings {

    public static String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=']')
                stack.push(s.charAt(i));
            else{
                StringBuilder temp= new StringBuilder();
                while(stack.peek()!='['){
                    temp.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder num= new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.insert(0, stack.pop());
                }
                System.out.println(num);
                temp = new StringBuilder(String.join("", Collections.nCopies(Integer.parseInt(num.toString()), temp.toString())));
                for(int j=0;j<temp.length();j++){
                    stack.push(temp.charAt(j));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop().toString());
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
