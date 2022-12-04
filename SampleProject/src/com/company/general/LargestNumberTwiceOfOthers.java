package com.company.general;

public class LargestNumberTwiceOfOthers {


    public static int dominantIndex(int[] nums) {

        int max=0;
        int secondMax=0;
        int index =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secondMax=max;
                max=nums[i];
                index=i;
            }
            else if(nums[i]<max && nums[i]>secondMax)
                secondMax=nums[i];
        }
        if((max/2)>=secondMax)
            return index;
        else
            return -1;
    }

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println(dominantIndex(arr));
    }
}
