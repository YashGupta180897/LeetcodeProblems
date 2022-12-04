package com.company.general;

public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        k=n-k;
        return quickSelect(nums,0,n-1,k);

    }

    public int quickSelect(int[] nums, int left, int right, int k){
        int pivot=nums[right];
        int pivotIndex=left;
        for(int i=left;i<=right;i++){
            if(nums[i]<=pivot){
                int tmp=nums[pivotIndex];
                nums[pivotIndex]=nums[i];
                nums[i]=tmp;
                pivotIndex++;
            }

        }
        pivotIndex--;

        if(pivotIndex<k)
            return quickSelect(nums,pivotIndex+1,right,k);
        else if (pivotIndex>k)
            return quickSelect(nums,left,pivotIndex-1,k);
        else
            return nums[pivotIndex];
    }

    public static void main(String[] args) {
        KthLargestInArray k=new KthLargestInArray();
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
