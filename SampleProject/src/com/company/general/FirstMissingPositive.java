package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        List<Integer> positiveNumbers= new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]>0)
                positiveNumbers.add(nums[i]);
        }

        for (int i=0;i<positiveNumbers.size();i++) {
            int j=positiveNumbers.get(i);
            if (j <= length)
                nums[j - 1] = j;
        }
        int ans=0;
        for(int i=0;i<length;i++){
            if(nums[i]!=(i+1)){
                ans=i+1;
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2,1};
        System.out.println(firstMissingPositive(nums));

    }
}
