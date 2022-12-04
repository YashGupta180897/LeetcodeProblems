package com.company.general;

public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=2)
            return nums.length;
        int prevDiff=nums[1]-nums[0];
        int counter = prevDiff != 0 ? 2 : 1;
        for(int i=2;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
            if((prevDiff>=0 && diff<0) || (diff>0 && prevDiff<=0)){
                counter++;
                prevDiff=diff;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr={3,3,3,2,5};
        System.out.println(wiggleMaxLength(arr));

        double d;
        //System.out.println(String.valueOf(d));
    }
}
