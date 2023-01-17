package com.company.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList=new ArrayList<>();
        backTrack(resultList, new HashSet<>(), nums);
        return resultList;
    }

    public void backTrack(List<List<Integer>> resultList, Set<Integer> set, int[] nums){

        if(set.size()==nums.length){
            resultList.add(new ArrayList<>(set));
            return;
        }
        for(int num:nums){
            if(set.contains(num))
                continue;
            set.add(num);
            backTrack(resultList,set,nums);
            set.remove(set.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations p=new Permutations();
        System.out.println(p.permute(new int[]{1,2,3}));
    }
}
