package com.company.general;

public class HouseRobber {


    public int rob(int[] nums) {

        int rob1=0;
        int rob2=0;
        for(int n:nums){
            int temp=Math.max(rob1+n,rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        HouseRobber h=new HouseRobber();
        System.out.println(h.rob(new int[]{2,1,1,2}));
    }
}
