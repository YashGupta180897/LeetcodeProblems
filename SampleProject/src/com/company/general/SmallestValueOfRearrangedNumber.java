package com.company.general;

import java.util.Arrays;

public class SmallestValueOfRearrangedNumber {

    public static long smallestNumber(long num) {
        String number=String.valueOf(num);
        char[] charArray=number.toCharArray();
        Arrays.sort(charArray);
        if(num<0){
            StringBuilder sb=new StringBuilder("-");
            for(int i=number.length()-1;i>=1;i--){
                sb.append(charArray[i]);
            }
            return Long.parseLong(sb.toString());

        }
        else{
            if(charArray[0]=='0'){
                int temp=1;
                while(charArray[temp]=='0')
                    temp++;
                if(temp==number.length()-1)
                    return 0;
                swap(charArray,temp);
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i < charArray.length;i++){
                sb.append(charArray[i]);
            }
            return Long.parseLong(sb.toString());
        }
    }

    private static void swap(char[] arr, int temp){

        char ch=arr[temp];
        arr[temp]='0';
        arr[0]=ch;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
    }
}
