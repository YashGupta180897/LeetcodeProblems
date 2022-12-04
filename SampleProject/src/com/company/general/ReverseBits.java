package com.company.general;

public class ReverseBits {

    public static int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));

        int rev=0;
        int j=0;
        for(int i=31;i>=0;i--){
            int imask= 1<<i ;
            if((n&imask)==imask) {
                int mask = 1 << j;
                rev |= mask;
             }
            j++;
        }
        return rev;
    }

    public static void main(String[] args) {

        //int x=reverseBits(57);

        System.out.println(Integer.parseInt("0100000000000000000000000000001",2));

    }
}
