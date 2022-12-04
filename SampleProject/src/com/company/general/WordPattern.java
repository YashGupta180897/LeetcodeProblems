package com.company.general;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        if(pattern==null || s==null)
            return false;
        Map<Character,String> map=new TreeMap<>();
        Set<String> set=new HashSet<>();
        String[] arr=s.split("\\s+");
        if(arr.length!=pattern.length())
            return false;

        for(int i=0;i<pattern.length();i++) {
            char x = pattern.charAt(i);
            String temp = arr[i];
            if (map.containsKey(x)) {
                if (!map.get(x).equals(temp))
                    return false;
            } else {
                if (set.contains(temp))
                    return false;
                map.put(x, temp);
                set.add(temp);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(wordPattern("abca", "dog cat cat dog"));
    }
}
