package com.company.general;

public class MooreVotingAlgo {



    public static int majorityElement(int[] nums) {

        int majorityCount=0;
        int majorityElement=0;
        for(int num: nums){
            if(majorityCount==0)
                majorityElement=num;
            if(num == majorityElement){
                majorityCount++;
            }
            else {
                majorityCount--;
            }
        }

        return majorityCount;

    }
    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,1};
        System.out.println(majorityElement(nums));
    }
}
