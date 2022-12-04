package com.company.general;

public class JumpGame {

    public static boolean canJump(int[] nums) {

        int end=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=end)
                end=i;
        }

        return end==0;
    }

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{3,2,1,0,4}));

    }
}
