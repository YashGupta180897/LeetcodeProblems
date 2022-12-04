package com.company.general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class JumpGame6 {


    public static int maxResult(int[] nums, int k) {
        int i=1;
        int sum=nums[0];
        while(i<nums.length){
            int minNegative=Integer.MIN_VALUE;
            int c=i+k;
            if(c<nums.length){
                int negativeIndex=-1;
                for( int j=i;j<c;j++){
                    if(nums[j]>0){
                        sum+=nums[j];
                        i=j;
                        break;
                    }
                    else{
                        if(minNegative<nums[j]) {
                            minNegative = nums[j];
                            negativeIndex=j;
                            i=j;
                        }
                    }
                }
                if(nums[i]<=0){
                    i=negativeIndex;
                    sum+=minNegative;
                }
            }
            else{
                int flag=0;
                for(;i<nums.length;i++){
                    if(nums[i]>0){
                        flag=0;
                        sum+=nums[i];
                    }
                    else
                        flag=1;
                }
                if(flag==1)
                    sum+=nums[i-1];
            }
            i++;

        }
        return sum;
    }
    public static void main(String[] args) {

        Map<Integer,Integer> map=new HashMap<>();

        String s="HACKER EARTH";
        String t=s.substring(3,10);
        System.out.println(t);
        LinkedList<String> q=new LinkedList<>();
        q.add("Alice");
        q.add("BOB");
        //q.add(3,"Mike");
        q.add("abc");
        System.out.println(q);
        int[] arr={10,-5,-2,4,0,3,-5};


        //System.out.println(maxResult(arr,8));
    }
}
