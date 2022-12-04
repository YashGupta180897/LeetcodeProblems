package com.company.general;

import java.util.*;

public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> strList=new ArrayList<>();
        Map<Character,Character> map=new TreeMap<>();
        Set<Character> set=new HashSet<>();
        for(String w:words){
            int flag=0;
            map.clear();
            set.clear();
            for(int i=0;i<w.length();i++){
                char ch=w.charAt(i);
                char p=pattern.charAt(i);

                if(map.containsKey(ch)){
                    if(map.get(ch)!=p) {
                        flag=1;
                        break;
                    }

                }
                else{
                    if(set.contains(p)){
                        flag=1;
                        break;
                    }
                    map.put(ch,p);
                    set.add(p);
                }
            }
            if(flag==0)
                strList.add(w);
        }
        return strList;
    }

    public static void main(String[] args) {


        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));
    }
}
