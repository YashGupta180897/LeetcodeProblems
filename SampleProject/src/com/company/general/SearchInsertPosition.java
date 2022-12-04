package com.company.general;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums={1,3,5,7,9,11};

        System.out.println(searchInsert(nums,6));
    }
}
