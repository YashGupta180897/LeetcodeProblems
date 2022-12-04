package com.company.general;

public class SumOfOffLengthSubArray {


    public static int sumOddLengthSubarrays(int[] arr) {

        int n=arr.length;
        int counter=0;
        if(n%2==0)
            counter=n/2;
        else
            counter = (n / 2) + 1;
        int count=1;
        while(counter>0){
            for(int i=0;i<n;i++)
            counter--;
        }
        return 0;

    }
    public static void main(String[] args) {

        System.out.println(sumOddLengthSubarrays(new int[]{1,2,3,4,5}));
    }
}
