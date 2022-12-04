package com.company.general;

import java.util.Arrays;

public class FirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {

        int left=binarySearch(nums,target,true);
        int right=binarySearch(nums,target,false);
        return new int[]{left,right};
    }

    private int binarySearch(int[] nums, int target, boolean leftBias){

        int left=0;
        int right=nums.length-1;
        int i=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target)
                right=mid-1;
            else if(nums[mid]<target)
                left=mid+1;
            else{
                i=mid;
                if(leftBias)
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[] arr={5,7,7,8,8,8};
        FirstAndLastPosition f=new FirstAndLastPosition();
        System.out.println(Arrays.toString(f.searchRange(arr, 8)));
    }
}
