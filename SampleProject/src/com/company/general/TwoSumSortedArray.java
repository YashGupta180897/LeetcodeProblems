package com.company.general;

public class TwoSumSortedArray {

    public int[] twoSum(int[] nums, int target) {

        int[] ans=new int[2];
        int left=0;
        int right=nums.length-1;
        int sum=0;
        for(int i=0;i<nums.length/2+1;i++){
            sum=nums[left]+nums[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else{
                ans[0]=left;
                ans[1]=right;
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        TwoSumSortedArray t=new TwoSumSortedArray();
        int[] arr={1,2,4};
        int[] ans=t.twoSum(arr,6);

    }
}
