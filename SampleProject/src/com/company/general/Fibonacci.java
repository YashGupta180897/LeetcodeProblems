package com.company.general;

public class Fibonacci {

    public static int fib(int n) {
        if(n<=1)
            return n;
        return fib(n-1) + fib(n-2) ;
    }

    public static int loopFib(int n){

        int[] arr=new int[n];
        arr[0]=0;
        arr[1]=1;
        int sum=1;
        for(int i=2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
            sum+=arr[i];
        }
        return sum;

    }
    public static void main(String[] args) {

        System.out.println(fib(4));
        System.out.println(loopFib(5));
    }
}
