package com.company.general;

public class Test {
    private static int counter = 0;

    Test(int x){
        counter = x;
    }
    public static void main(String[] args) {
        //Test tTest = new Test();
        System.out.println(counter);
    }
}