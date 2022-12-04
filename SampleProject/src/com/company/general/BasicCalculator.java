package com.company.general;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char operator='+';
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' ')
                continue;
            if(arr[i]==')'){
                int localSum=0;
                while(stack.peek()!=40){
                    localSum+=stack.pop();
                }
                stack.pop();
                stack.push(localSum);
            }
            else if(arr[i]=='+' || arr[i]=='-'){
                operator=arr[i];
            }
            else{
                if(operator=='-' && Character.isDigit(arr[i])) {
                    stack.push(-(int) (arr[i] - '0'));
                    operator='+';
                }
                else if(Character.isDigit(arr[i]))
                    stack.push((int)(arr[i]-'0'));
                else
                    stack.push((int)arr[i]);
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {

        BasicCalculator bc=new BasicCalculator();
        System.out.println(bc.calculate("2147483647"));
    }
}
