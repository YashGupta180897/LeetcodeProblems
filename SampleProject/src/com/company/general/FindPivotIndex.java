package com.company.general;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        int[] leftSum=new int[nums.length];
        leftSum[0]=0;
        for(int i=1;i<nums.length;i++){
            leftSum[i]=leftSum[i-1]+nums[i-1];
            System.out.print(leftSum[i]+" ");
        }

        for(int i=0;i<nums.length;i++){
            int rightSum=nums[nums.length-1]+ leftSum[nums.length-1]-leftSum[i]-nums[i];
            System.out.println(rightSum);
            if(leftSum[i]==rightSum)
                return i;

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr={2,1,-1};
        System.out.println(pivotIndex(arr));

    }
}
