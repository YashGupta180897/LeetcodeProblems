package com.company.general;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {

    Stack<Pairs> stack;
    public StockSpanner() {
        stack=new Stack<>();
    }

    public int next(int price) {

        int span=1;
        while(stack.size()>0 && stack.peek().getPrice()<=price){
            span+=stack.peek().getSpan();
            stack.pop();
        }
        stack.add(new Pairs(price,span));
        return span;
    }


    /*public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }*/
}

class Pairs{

    private int price;
    private int span;

    Pairs(int price,int span){
        this.price=price;
        this.span=span;
    }

    public int getPrice(){
        return price;
    }

    public int getSpan(){
        return span;
    }
}

