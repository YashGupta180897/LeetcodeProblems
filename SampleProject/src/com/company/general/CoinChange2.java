package com.company.general;

public class CoinChange2 {

    public int change(int amount, int[] coins) {

        int[][] mat=new int[coins.length][amount+1];
        for(int i=coins.length-1;i>=0;i--){
            mat[i][amount]=1;
            for(int j=amount-1;j>=0;j--){
                if(coins[i]<=(amount-j))
                    mat[i][j]=mat[i][j+coins[i]];
                mat[i][j]+=(i<coins.length-1?mat[i+1][j]:0);
            }
        }
        return mat[0][0];
    }

    public static void main(String[] args) {

        CoinChange2 c=new CoinChange2();
        System.out.println(c.change(5,new int[]{1,2,5}));
    }
}
