package com.company.general;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        String[] tempArr = new String[strs.length];
        for(int i=0;i<strs.length;i++) {
            tempArr[i]=strs[i];
            char[] ch=tempArr[i].toCharArray();
            Arrays.sort(ch);
            tempArr[i]=String.valueOf(ch);
        }
        Map<String,List<Integer>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=tempArr[i];
            if(map.containsKey(s)) {
                List<Integer> l=map.get(s);
                l.add(i);
                map.put(s, l);
            }
            else{
                List<Integer> l=new ArrayList<>();
                l.add(i);
                map.put(s,l);
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry:map.entrySet()){
            List<String> l=new ArrayList<>();
            for(int i=0;i<entry.getValue().size();i++){
                l.add(strs[entry.getValue().get(i)]);
            }
            list.add(l);
        }
        return list;

    }

    public static void main(String[] args) {


        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
