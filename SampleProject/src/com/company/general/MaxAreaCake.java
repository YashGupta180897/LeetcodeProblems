package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAreaCake {
    private int maxDiff(int length, int[] arr){
        int max=0;
        List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.add(0);
        list.add(length);
        Collections.sort(list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1)-list.get(i)>max)
                max=list.get(i+1)-list.get(i);
        }
        return max;
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        int horizontalMaxDiff = maxDiff(h,horizontalCuts);
        int verticalMaxDiff = maxDiff(w,verticalCuts);
        return (int)(((long) horizontalMaxDiff * verticalMaxDiff)%((int)(Math.pow(10,9)+7)));
    }

    public static void main(String[] args) {
        MaxAreaCake m=new MaxAreaCake();
        int[] horizontal={2};
        int[] vertical={2};
        System.out.println(m.maxArea(1000000000,1000000000,horizontal,vertical));
    }
}
