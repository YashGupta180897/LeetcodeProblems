package com.company.general;

public class TrappingRainWater {

    public int trap(int[] height) {

        int n=height.length;
        int sum=0;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=height[0];
        rightMax[n-1]=height[n-1];
        for(int i=1;i<n-1;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
            rightMax[n-i-1]=Math.max(height[n-i-1],rightMax[n-i]);
        }
        for(int i=1;i<n-2;i++){
            int level=Math.min(leftMax[i],rightMax[i]);
            int water=level-height[i];
            if(water>0)
                sum+=water;
        }

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater t=new TrappingRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
