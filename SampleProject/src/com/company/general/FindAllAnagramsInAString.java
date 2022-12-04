package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        int[] sArray=new int[26];
        int[] pArray=new int[26];
        List<Integer> list=new ArrayList<>();
        if(p.length()>s.length())
            return list;
        for(int i=0;i<p.length();i++){
            pArray[p.charAt(i)-'a']++;
            sArray[s.charAt(i)-'a']++;
        }
        int left=0;
        int right=p.length();
        for(int i=right;i<s.length();i++){
            if(Arrays.equals(sArray,pArray))
                list.add(left);
            sArray[s.charAt(left)-'a']--;
            left++;
            sArray[s.charAt(i)-'a']++;
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
