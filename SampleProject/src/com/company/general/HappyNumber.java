package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {

        Set<Integer> set=new HashSet<>();
        int sum=n;
        while(true){
            if(!set.add(sum))
                return false;
            n=sum;
            set.add(sum);
            sum=0;
            while(n!=0){
                int x=n%10;
                sum+=x*x;
                n/=10;
            }
            if(sum==1)
                return true;
        }
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }
}
