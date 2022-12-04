package com.company.general;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {


    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set=new HashSet<>();
        int len=s.length();
        int l=0;
        int res=0;
        for(int r=0;r<len;r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res=Math.max(r-l+1,res);
        }
        return res;
    }


    public static int lengthOfLongestSubstring2(String s) {

        Set<Character> set=new HashSet<>();
        int len=s.length();
        if(len==0 || len==1)
            return len;
        int maxCount=1;
        for(int i=0;i<len;i++){
            int count=1;
            set.clear();
            set.add(s.charAt(i));
            for(int j=i+1;j<len;j++){
                if(!set.add(s.charAt(j))){
                    maxCount=Math.max(maxCount,count);
                    break;
                }
                set.add(s.charAt(j));
                count++;
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcdeacdef"));
    }
}
