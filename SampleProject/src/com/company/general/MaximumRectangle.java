package com.company.general;

import java.util.Stack;

public class MaximumRectangle {

    public int maximalRectangle(char[][] matrix) {

        int rows=matrix.length;
        int col=(rows>0)?matrix[0].length:0;
        int[][] dp=new int[rows][col];
        for(int j=0;j<col;j++){
            dp[0][j]=(matrix[0][j]-'0');
        }
        for(int i=1;i<rows;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=dp[i-1][j]+1;
                }
            }
        }
        int maxArea=0;
        for(int[] arr:dp){
            maxArea=Math.max(maxArea,callHistogramFunction(arr));
        }
        return maxArea;
    }

    private int callHistogramFunction(int[] dp){
        Stack<Integer> stack=new Stack<>();
        int area=0;
        int maxArea=0;
        int i;
        for(i=0;i<dp.length;){
            if(stack.isEmpty() || dp[i]>=dp[stack.peek()])
                stack.push(i++);
            else{
                int top=stack.pop();
                if(stack.isEmpty()){
                    area=dp[top]*i;
                }
                else{
                    area=dp[top]*(i-stack.peek()-1);
                }
            }
            maxArea=Math.max(maxArea,area);
        }
        while(!stack.isEmpty()){
            int top=stack.pop();
            if(stack.isEmpty()){
                area=dp[top]*i;
            }
            else{
                area=dp[top]*(i-stack.peek()-1);
            }
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximumRectangle m=new MaximumRectangle();
        System.out.println(m.maximalRectangle(new char[][]{{'0','0','1','0'},{'0','0','1','0'},{'0','0','1','0'},{'0','0','1','1'},{'0','1','1','1'},{'0','1','1','1'},{'1','1','1','1'}}));
    }
}
