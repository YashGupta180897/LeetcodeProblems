package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();

        int startR=0,startC=0,endR=matrix.length-1,endC=matrix[0].length-1;
        while(startR<=endR && startC<=endC){

            for(int i=startC;i<=endC;i++){
                result.add(matrix[startR][i]);
            }
            for(int i=startR+1;i<=endR;i++){
                result.add(matrix[i][endC]);
            }
            for(int i=endC-1;i>=startC;i--){
                if(startR==endR)
                    break;
                result.add(matrix[endR][i]);
            }
            for(int i=endR-1;i>startR;i--){
                if(startC==endC)
                    break;
                result.add(matrix[i][startC]);
            }
            startC++;
            startR++;
            endC--;
            endR--;
        }

        return result;

    }

    public static void main(String[] args) {
        SpiralMatrix sm=new SpiralMatrix();
        System.out.println(sm.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
/*
1   2   3     4
5   6   7     8
9   10  11   12
13  14  15   16

 */