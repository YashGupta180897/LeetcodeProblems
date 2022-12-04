package com.company.general;

import java.util.*;

public class SubsetsWithoutDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> result=new HashSet<>();
        Arrays.sort(nums);
        generateSubsets(result,new ArrayList(),nums,0);
        return new ArrayList(result);

    }

    public void generateSubsets(Set<List<Integer>> result, List<Integer> current, int[] nums, int index){

        result.add(current);
        for(int i=index;i<nums.length;i++){
            List<Integer> list=new ArrayList<>(current);
            list.add(nums[i]);
            generateSubsets(result,list,nums,i+1);
        }
    }

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,8};
        SubsetsWithoutDuplicates s=new SubsetsWithoutDuplicates();
        System.out.println(s.subsetsWithDup(arr));
    }
}
