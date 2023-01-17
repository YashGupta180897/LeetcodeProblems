package com.company.general;

public class Bring0sToLeft {

    public static void main(String[] args) {

        int[] arr={1,1,1,0,0,0};

        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]==1 && arr[right]==0){
                swap(arr,left,right);
            }
            if(arr[left]==0){
                left++;
            }
            if(arr[right]==1)
                right--;
        }

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
