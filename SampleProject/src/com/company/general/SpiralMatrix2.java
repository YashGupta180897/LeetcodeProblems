package com.company.general;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {

        int[][] matrix=new int[n][n];
        int startR=0;
        int endR=n-1;
        int startC=0;
        int endC=n-1;
        int x=1;
        while(startR<=endR && startC<=endC){

            for(int i=startC;i<=endC;i++){
                matrix[startR][i]=x++;
            }

            for(int i=startR+1;i<=endR;i++){
                matrix[i][endC]=x++;
            }

            for(int i=endC-1;i>=startC;i--){
                if(x>(n*n))
                    break;
                matrix[endR][i]=x++;
            }

            for(int i=endR-1;i>startR;i--){
                if(x>(n*n))
                    break;
                matrix[i][startC]=x++;
            }

            endR--;
            startR++;
            endC--;
            startC++;
        }

        return matrix;
    }


    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2=new SpiralMatrix2();
        spiralMatrix2.generateMatrix(2);
    }
}
