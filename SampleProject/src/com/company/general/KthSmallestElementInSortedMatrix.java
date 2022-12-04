package com.company.general;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];

        while(low<=high){
            int mid=(low+high)/2;
            int count=0;
            for (int[] ints : matrix) {
                count += getCount(mid, ints);
            }
            if(count<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }

    private int getCount(int ele, int[] matrix) {

        int n=matrix.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[mid]>ele)
                high=mid-1;
            else
                low=mid+1;

        }
        return low;

    }

    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix k=new KthSmallestElementInSortedMatrix();
        System.out.println(k.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
}
