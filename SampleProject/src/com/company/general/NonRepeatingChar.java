package com.company.general;

public class NonRepeatingChar {

    public static void main(String[] args) {

        String s="tomato";
        int[] arr=new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        char c = 0;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1) {
                c = s.charAt(i);
                break;
            }
        }
        System.out.println(c);

    }
}
