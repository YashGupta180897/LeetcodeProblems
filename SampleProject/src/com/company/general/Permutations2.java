package com.company.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        backTrack(resultList,map,new ArrayList<>(),nums);
        return resultList;
    }

    private void backTrack(List<List<Integer>> resultList, Map<Integer,Integer> map, List<Integer> list, int[] nums){
        if(list.size()==nums.length){
            resultList.add(new ArrayList<>(list));
            return;
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num=entry.getKey();
            if(entry.getValue()>0){
                list.add(num);
                map.put(num,map.get(num)-1);
                backTrack(resultList,map,list,nums);
                list.remove(list.size()-1);
                map.put(num,map.get(num)+1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations2 p=new Permutations2();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
    }
}
