package com.company.general;

import java.util.*;

public class MaxSlidingWindow {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue=new LinkedList<>();
        int left=0;
        int right=0;
        List<Integer> list=new ArrayList<>();

        while(right<nums.length) {
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[right]){
                queue.pollLast();
            }
            queue.add(right);

            if(left>queue.getFirst())
                queue.pop();

            if((right+1)>=k){
                list.add(nums[queue.getFirst()]);
                left++;
            }
            right++;
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
}
