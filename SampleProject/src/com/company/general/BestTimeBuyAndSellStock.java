package com.company.general;

import java.math.BigInteger;

public class BestTimeBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int profit=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(buy>prices[i]){
                buy=prices[i];
            }
            else if(profit<prices[i]-buy)
                profit=prices[i]-buy;
        }

        return profit;
    }
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));

        StringBuilder sb=new StringBuilder();
        sb.insert(0,"0");

    }
}
