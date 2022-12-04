package com.company.general;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count=0;
        Map<Integer,Integer> mapSum = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                mapSum.putIfAbsent(sum, 0);
                mapSum.put(sum, mapSum.get(sum) + 1);
            }
        }
        for(int i : nums3){
            for(int j: nums4) {
                int sum = i+j;
                if (mapSum.containsKey(-sum))
                    count += mapSum.get(-sum);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }
}
