package com.company.general;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        int[] lis=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){
            lis[i]=1;
            for(int j=i+1;j<=nums.length-1;j++){
                if(nums[i]<nums[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int max=0;
        for(int i:lis){
            if(i>max)
                max=i;
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
