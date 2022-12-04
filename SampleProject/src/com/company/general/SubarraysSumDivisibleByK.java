package com.company.general;

import java.util.HashMap;
import java.util.Map;

public class SubarraysSumDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int total=0;
        for (int num : nums) {
            sum += num;
            int temp=sum;
            if(sum<0)
                temp=sum+k*(Math.abs(sum)/k+1);
            if (map.containsKey((temp % k)))
                total += map.get(temp % k);
            map.put(temp % k, map.getOrDefault(temp % k, 0) + 1);

        }
        return total;
    }

    public static void main(String[] args) {

        SubarraysSumDivisibleByK s=new SubarraysSumDivisibleByK();
        System.out.println(s.subarraysDivByK(new int[]{-1,-9,-4,0},9));
    }
}
