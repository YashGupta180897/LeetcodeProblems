package com.company.general;

import com.company.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwoSumUnSortedArray {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            int num=nums[i];
            int rem=target-num;
            if(map.containsKey(rem)){
                int index=map.get(rem);
                if(index==i)
                    continue;
                return new int[]{i,index};
            }
        }

        return new int[]{};
    }
    public static void main(String[] args) {

        LinkedList<TreeNode> list=new LinkedList();
    }
}
