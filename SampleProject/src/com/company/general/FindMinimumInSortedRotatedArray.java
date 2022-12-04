package com.company.general;

public class FindMinimumInSortedRotatedArray {

    public static int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=5001;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[left]<=nums[mid] && nums[right]>=nums[mid]){
                min=nums[left];
                break;
            }
            if(mid==0 || nums[mid-1]>nums[mid])
                return Math.min(nums[mid], nums[mid + 1]);

            if(nums[left]>nums[mid])
                right=mid-1;

            else if(nums[right]<nums[mid])
                left=mid+1;

        }
        return min;
    }


    public static void main(String[] args) {

        System.out.println(findMin(new int[]{2,3,4,5,1}));
    }
}
