package com.company.general;

public class UniquePaths2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1)
            return 0;
        if(obstacleGrid[0][0]==1)
            return 0;

        for(int i=1;i<n;i++){
            if(obstacleGrid[i][0]==1){
                obstacleGrid[i][0]=0;
                break;
            }
            obstacleGrid[i][0]=1;
        }
        for(int i=1;i<m;i++){
            if(obstacleGrid[0][i]==1){
                obstacleGrid[0][i]=0;
                break;
            }
            obstacleGrid[0][i]=1;
        }
        obstacleGrid[0][0]=1;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }
                else{
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];

    }

    public static void main(String[] args) {

        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,1},{0,0},{0,0},{1,0},{0,0},{0,0},{0,1},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,1},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0}}));
    }
}
