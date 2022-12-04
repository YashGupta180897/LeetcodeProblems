package com.company.general;

public class MergeSort {


    void merge(int l[], int r[], int[] merger, int left, int right){

        int i=0;
        int j=0;
        int k=0;
        while(i< left && j<right){
            if(l[i]<r[j])
                merger[k++]=l[i++];
            else
                merger[k++]=r[j++];
        }

        while(i<left){
            merger[k++]=l[i++];
        }
        while(j<right){
            merger[k++]=r[j++];
        }


    }

    void mergeSort(int a[], int n){
        if(n<2)
            return;

        int mid=n/2;
        int[] l=new int[mid];
        int[] r=new int[n-mid];
        for(int i=0;i<mid;i++){
            l[i]=a[i];
        }
        for(int i=mid;i<n;i++){
            r[i-mid]=a[i];
        }

        mergeSort(l,mid);
        mergeSort(r,n-mid);
        merge(l,r,a,mid,n-mid);

    }
    public static void main(String[] args) {

        MergeSort ms=new MergeSort();
        int[] arr={4,3,2,1, 0, -1};
        ms.mergeSort(arr,6);
        for(int i: arr)
        {
            System.out.print(i);
        }
    }
}
