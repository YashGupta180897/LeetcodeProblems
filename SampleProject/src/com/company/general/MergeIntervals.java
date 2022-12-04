package com.company.general;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        LinkedList<int[]> merged=new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        for(int[] interval:intervals){
            if(!merged.isEmpty() && interval[0]<merged.getLast()[1]){
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
            }
            else
                merged.add(interval);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

    }
}
