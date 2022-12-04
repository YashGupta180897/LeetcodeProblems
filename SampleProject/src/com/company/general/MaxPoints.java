package com.company.general;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

    public static int maxPoints(int[][] points) {
        Map<Double, Integer> map=new HashMap<>();
        int max=0;
        if(points.length==1)
            return 1;
        for(int i=0;i<points.length-1;i++){
            int y1=points[i][1];
            int x1=points[i][0];
            map.clear();
            for(int j=i+1;j<points.length;j++){
                int y2=points[j][1];
                int x2=points[j][0];
                double slope=0;
                if(x2-x1==0)
                    slope=Integer.MAX_VALUE;
                else if((y2-y1)==0)
                    slope=0;
                else
                    slope=(double)(y2-y1)/(x2-x1);
                map.put(slope,map.getOrDefault(slope,1)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max;

    }


    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{2,3},{3,3},{-5,3}}));

    }
}
