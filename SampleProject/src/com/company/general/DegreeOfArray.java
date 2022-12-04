package com.company.general;

import java.util.*;

public class DegreeOfArray {

    public static int findShortestSubArray(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else
                map.put(num, 1);
        }
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
            }

        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==max){
                set.add(entry.getKey());
            }
        }
        int start=-1;
        int last=-1;
        int diff=Integer.MAX_VALUE;
        for (Integer x : set) {
            start = -1;
            last = -1;
            for (int j = 0; j < nums.length; j++) {
                if (x == nums[j]) {
                    start = j;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (x == nums[j]) {
                    last = j;
                    break;
                }
            }
            diff = Math.min(diff, last - start + 1);
        }

        return diff;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
