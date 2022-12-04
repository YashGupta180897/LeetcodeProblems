package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueChar {



    public static int firstUniqChar(String s) {
        int index=-1;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i==s.lastIndexOf(ch) && !set.contains(ch)){
                index=i;
                break;
            }
            else{
                set.add(ch);
            }

        }
        return index;
    }

    public static void main(String[] args) {

        System.out.println(firstUniqChar("aabb"));
    }
}
