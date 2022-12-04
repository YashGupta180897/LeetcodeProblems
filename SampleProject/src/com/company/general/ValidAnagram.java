package com.company.general;

public class ValidAnagram {

    public static boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        int[] arr=new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-97]++;
            arr[s2.charAt(i)-97]--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0)
                return false;
        }
        return true;


    }
    public static void main(String[] args) {

        System.out.print(isAnagram("mmnn","aazz"));
    }
}
