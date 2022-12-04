package com.company.general;

public class JumpGame2 {

    public static int jump(int[] nums) {

        int[] dp=new int[nums.length];
        dp[nums.length-1]=0;
        for(int i=nums.length-2;i>= 0;i--){
            dp[i]=dp[i+nums[i]]+1;
        }

        return dp[0];

    }

    public static int jump2(int[] nums) {

        int left=0;
        int right=0;
        int res=0;
        while(right<nums.length-1){
            int farthest=0;
            for(int i=left;i<=right;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            left=right+1;
            right=farthest;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(jump2(new int[]{2,2,1,1,4}));

    }
}
