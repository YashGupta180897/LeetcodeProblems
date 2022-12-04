package com.company.general;

public class ClimbingStairs {

    public static int climbStairs(int n) {

        if(n==1)
            return 1;
        int first=1;
        int second=1;
        int third=1;

        for(int i=n-3;i>=0;i--){

            third=first+second;
            first=second;
            second=third;
        }
        return third+first;
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }
}
