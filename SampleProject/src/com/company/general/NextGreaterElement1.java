package com.company.general;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Integer num:nums2){
            while(!stack.isEmpty() && stack.peek()<num)
                map.put(stack.pop(),num);

            stack.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;

    }
    public static void main(String[] args) {

        nextGreaterElement(new int[]{2,3,4,5,1}, new int[]{5,2,3,1});
    }
}
