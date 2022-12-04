package com.company.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temp) {

        Stack<Pair> stack=new Stack<>();

        int n=temp.length;
        int[] res=new int[n];

        for(int i=n-1;i>=0;i--){
            while(stack.size()>0 && stack.peek().getTemp()<=temp[i]){
                stack.pop();
            }
            if(stack.size()>0 && stack.peek().getTemp()>temp[i]){
                res[i]=stack.peek().getIndex()-i;
            }
            stack.push(new Pair(temp[i],i));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

class Pair{
    int temp;
    int index;

    Pair(int temp,int index){
        this.index=index;
        this.temp=temp;
    }

    public int getTemp() {
        return temp;
    }

    public int getIndex() {
        return index;
    }
}
