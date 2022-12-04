package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i=0;
        int j=0;
        int flen=firstList.length;
        int slen=secondList.length;

        if(flen == 0 || slen == 0)
            return new int[][]{};

        List<int[]> list=new ArrayList<>();
        while(i<flen && j<slen){
            int max=Math.max(firstList[i][0],secondList[j][0]);
            int min=Math.min(firstList[i][1],secondList[j][1]);
            if(max<=min){
                list.add(new int[]{max,min});
            }
            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;
        }
        int[][] result=new int[list.size()][2];
        for(i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
