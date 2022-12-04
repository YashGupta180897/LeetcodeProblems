package com.company.general;

public class IsPowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if(n<0)
            return false;

        return (Math.log10(n)/Math.log10(3))%1==0;
    }
    public static void main(String[] args) {

        System.out.println(isPowerOfThree(243));
    }
}
