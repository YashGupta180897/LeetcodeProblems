package com.company.general;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] arr1=new int[26];

        for(int i=0;i<magazine.length();i++){
            arr1[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++){
            arr1[ransomNote.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a","aaa"));
    }
}
