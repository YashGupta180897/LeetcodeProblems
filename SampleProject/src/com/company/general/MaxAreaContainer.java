package com.company.general;

public class MaxAreaContainer {

    public static int maxArea(int[] height) {

        int low=0;
        int high=height.length-1;
        int maxArea=0;

        while(low<high){
            if(height[low]<height[high]){
                maxArea=Math.max(height[low]*(high-low),maxArea);
                low++;
            }
            else {
                maxArea=Math.max(height[high]*(high-low),maxArea);
                high--;
            }
        }
        return maxArea;

    }
    public static void main(String[] args) {

        int[] arr={8,1,2,3,4,5,6,7,8};
        System.out.println(maxArea(arr));
    }
}
