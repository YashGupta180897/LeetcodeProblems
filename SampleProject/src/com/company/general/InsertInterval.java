package com.company.general;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> merged=new LinkedList<>();
        int flag=0;
        for(int[] interval:intervals){
            if(merged.isEmpty() && interval[0]>newInterval[0]){
                merged.add(newInterval);
                merged.add(interval);
            }
            else
                merged.add(interval);

            if(!merged.isEmpty() && merged.getLast()[1]>=newInterval[0]){
                merged.getLast()[1]=Math.max(merged.getLast()[1],newInterval[1]);
                flag=1;
            }
            else if(!merged.isEmpty() && merged.getLast()[0]>newInterval[0]){
                merged.add(newInterval);
                flag=1;
            }
        }
        if(flag==0)
            merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {5, 6}}, new int[]{3, 4})));
    }
}
