package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=2)
            return nums.length;
        int prevDiff=nums[1]-nums[0];
        List<Integer> list=new ArrayList<>();
        int counter=0;
        if(prevDiff!=0){
            counter=2;
            list.add(nums[0]);
        }
        else
            counter=1;

        for(int i=2;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
            if((prevDiff>=0 && diff<0) || (diff>0 && prevDiff<=0)){
                list.add(nums[i-1]);
                counter++;
                prevDiff=diff;
                if(i== nums.length-1)
                    list.add(nums[i]);
            }
        }
        System.out.println(list);
        return counter;
    }

    public static void main(String[] args) {
        int[] arr={1,17,5,10,13,15,10,10,16,8};
        System.out.println(wiggleMaxLength(arr));

        double d;
        //System.out.println(String.valueOf(d));
    }
}
