package com.company.general;

import java.util.Arrays;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int cmax=nums[0];
        int omax=nums[0];

        for(int i=0;i< nums.length;i++){
            if(cmax>=0)
                cmax+=nums[i];
            else
                cmax=nums[i];

            if(cmax>omax)
                omax=cmax;
        }
        return omax;


    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println( maxSubArray(nums));

    }
}
