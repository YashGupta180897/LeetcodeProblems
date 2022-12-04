package com.company.general;

import java.util.*;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        Map<Character,Character> map=new TreeMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            char y=t.charAt(i);
            if(map.containsKey(x))
            {
                if(map.get(x)!=y)
                    return false;
            }
            else
            {
                if(set.contains(y))
                    return false;
                else {
                    set.add(y);
                    map.put(x,y);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg","add"));
    }
}