package com.company.general;

public class LargeNumberString {

    public String largeNumber(String[] str){

        mergeSort(str, 0, str.length-1);
        StringBuilder sb=new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();

    }

    private void mergeSort(String[] str, int left, int right){
        if(left<right){

            int mid=(left+right)/2;

            mergeSort(str, left, mid);
            mergeSort(str, mid+1, right);

            merge(str, left, mid, right);
        }
    }

    private void merge(String[] str, int left, int mid, int right){
        int n1=mid-left+1;
        int n2=right-mid;

        String[] l=new String[n1];
        String[] r=new String[n2];

        for(int i=0;i<n1;i++){
            l[i]=str[left+i];
        }

        for(int i=0;i<n2;i++){
            r[i]=str[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=left;
        while(i<n1 && j<n2){
            String o1=l[i]+r[j];
            String o2=r[j]+l[i];
            if(Integer.parseInt(o1)>=Integer.parseInt(o2)){
                str[k++]=l[i++];
            }
            else
                str[k++]=r[j++];
        }

        while(i<n1){
            str[k++]=l[i++];
        }

        while(j<n2){
            str[k++]=r[j++];
        }
    }

    public static void main(String[] args) {
        LargeNumberString l=new LargeNumberString();
        System.out.println(l.largeNumber(new String[]{"456", "3", "335", "324", "9", "342"}));

    }
}
