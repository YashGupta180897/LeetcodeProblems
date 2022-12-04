package com.company.general;

public class CountHillsAndValleys {


    public static int countHillValley(int[] nums) {

        int count=0;
        int prev=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]==nums[i-1])
                continue;

            int curr=nums[i];
            int next=nums[i+1];
            while(curr==next){
                i++;
                if(i>nums.length-2)
                    break;
                next=nums[i+1];
            }

            if(curr==next)
                continue;

            if((curr>prev && curr>next) || (prev>curr && next>curr))
                count++;

            prev=curr;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countHillValley(new int[]{5,7,7,1,7}));
    }
}
