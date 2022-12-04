package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class SumOfUnique {

    public int sumOfUnique(int[] nums) {

        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        int sum=0;
        for(int n:nums){
            if(!set2.contains(n) && !set1.add(n)){
                set1.remove(n);
                set2.add(n);
            }
            else if(!set2.contains(n)){
                set1.add(n);
            }
        }

        for(int n:set1){
            sum+=n;
        }
        return sum;
    }


    public static void main(String[] args) {
        SumOfUnique s=new SumOfUnique();
        System.out.println(s.sumOfUnique(new int[]{1,1,1,1,1}));
    }
}
