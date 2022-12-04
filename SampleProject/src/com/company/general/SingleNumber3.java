package com.company.general;

import java.util.Arrays;

public class SingleNumber3 {


    public static int[] singleNumber(int[] nums) {

        int xor=0;
        for(int num:nums){
            xor^=num;
        }

        int rmsb=xor & -xor;
        int X=0,Y=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & rmsb)==0)
                X^=nums[i];
            else
                Y^=nums[i];
        }
        System.out.println(X+" "+Y);
        return new int[]{X,Y};
    }


    public static void main(String[] args) {

        int[] nums = {2,2,1,1, 4,5};
        int arr[]=singleNumber(nums);
    }
}
