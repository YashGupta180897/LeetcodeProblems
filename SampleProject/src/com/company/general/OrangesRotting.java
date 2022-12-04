package com.company.general;

public class OrangesRotting {

    public int orangesRotting(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        int countOf1;
        int countOf3;
        while(true){
            countOf1=0;
            countOf3=0;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]==1){
                        setOranges(grid,i,j);
                        countOf1++;
                    }
                }
            }
            if(countOf1==0)
                break;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]==3){
                        grid[i][j]=2;
                        countOf3++;
                    }
                }
            }
            if(countOf3==0)
                return -1;
            count++;
        }

        return count;

    }

    public void setOranges(int[][] grid, int i, int j){
        if(i>0 && grid[i-1][j]==2)
            grid[i][j]=3;
        else if(j>0 && grid[i][j-1]==2)
            grid[i][j]=3;
        else if(i<grid.length-1 && grid[i+1][j]==2)
            grid[i][j]=3;
        else if(j<grid[0].length-1 && grid[i][j+1]==2)
            grid[i][j]=3;
    }

    public static void main(String[] args) {
        System.out.println(new OrangesRotting().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
