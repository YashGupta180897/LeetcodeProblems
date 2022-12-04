package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=Math.abs(nums[i])-1;
            if(nums[x]<0)
                list.add(Math.abs(nums[i]));
            nums[x]=-Math.abs(nums[x]);
        }
        return list;
    }


    public static void main(String[] args) {
        FindAllDuplicates f=new FindAllDuplicates();
        System.out.println(f.findDuplicates(new int[]{10,2,5,10,9,1,1,4,3,7}));
    }
}
