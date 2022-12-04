package com.company.general;

import java.util.Arrays;

public class ValidPairSum {


    static long ValidPair(int a[], int n)
    {
        // Your code goes here

        Arrays.sort(a);
        long count=0L;
        int startIndex=0;
        int endIndex=n-1;
        while(endIndex>startIndex){
            if(a[endIndex]+a[startIndex]>0){
                count+=endIndex-startIndex;
                endIndex--;
            }
            else
                startIndex++;
        }
        return count;
    }

    public static void main(String[] args) {

        String s="   fly me   to   the moon  ";
        System.out.println(s.lastIndexOf(32));
        int count=0;
        s=s.trim();
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i)==32)
                break;
            count++;
        }
        System.out.println(count);
    }
}
