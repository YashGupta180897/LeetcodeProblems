package com.company.general;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HouseRobber2 {

    public int rob(int[] nums) {

        int n=nums.length;
        return Math.max(helpRob(Arrays.copyOfRange(nums, 0, n-1)), helpRob(Arrays.copyOfRange(nums, 1, n)));

    }

    public int helpRob(int[] nums){
        int rob1=0;
        int rob2=0;
        for(int n:nums){
            int temp=Math.max(rob1+n,rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        HouseRobber2 h=new HouseRobber2();
        System.out.println(h.rob(new int[]{2,1,1,2}));
    }
}
