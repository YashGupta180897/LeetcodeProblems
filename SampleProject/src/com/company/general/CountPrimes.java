package com.company.general;

import java.util.Arrays;

public class CountPrimes {

    public static int countPrimes(int n) {

        if(n==0 || n==1)
            return 0;
        int count=0;
        boolean[] toVisit=new boolean[n+1];
        Arrays.fill(toVisit,true);
        for(int i=2;i*i<n;i++){
            if(toVisit[i]){
                for(int j=i*i;j<=n;j+=i)
                    toVisit[j]=false;
            }
        }
        for(boolean flag:toVisit){
            if(flag)
                count++;
        }
        return count-2;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
