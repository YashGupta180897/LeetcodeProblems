package com.company.general;

public class ThirdMax {

    public static int thirdMax(int[] nums) {

        int firstMax=Integer.MIN_VALUE;
        int secondMax=firstMax;
        int thirdMax=firstMax;
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE)
                flag=1;
            if(nums[i]>firstMax) {
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax = nums[i];
            }
            else if(nums[i]<firstMax && nums[i]>secondMax){
                thirdMax=secondMax;
                secondMax=nums[i];
            }
            else if(nums[i]<secondMax && nums[i]>thirdMax) {
                thirdMax = nums[i];
            }
        }
        if(thirdMax==Integer.MIN_VALUE && ((flag==0) || (secondMax==thirdMax)))
            thirdMax=firstMax;
        return thirdMax;
    }

    public static void main(String[] args) {
        int[] nums = {1, Integer.MIN_VALUE};
        System.out.println( thirdMax(nums));
    }
}
