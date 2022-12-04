package com.company.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {

        List<Integer> ans=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);


        int lastIndex=map.get(s.charAt(0));
        int start=0;
        for(int i=0;i<s.length();i++){
            int index=map.get(s.charAt(i));
            lastIndex=Math.max(lastIndex,index);
            if(i==lastIndex){
                ans.add(index-start+1);
                start=index+1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
