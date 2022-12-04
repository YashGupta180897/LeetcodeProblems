package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class MinumumConsecutiveCardsToPick {

    public static int minimumCardPickup(int[] cards) {

        int ans=Integer.MAX_VALUE;
        int left=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<cards.length;i++){
            while(set.contains(cards[i])){
                ans=Math.min(i-left+1,ans);
                set.remove(cards[left]);
                left++;
            }
            set.add(cards[i]);
        }
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6}));
    }
}
