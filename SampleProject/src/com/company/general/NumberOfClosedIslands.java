package com.company.general;

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int count=0;
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    count+=findIsland(grid,i,j);
                }
            }
        }
        return count;
    }

    public int findIsland(int[][] grid, int i, int j){

        if(grid[i][j]==1 || grid[i][j]==-1)
            return 1;

        if(i==0 || j==0 || i==grid.length-1 || j==grid[i].length-1)
            return 0;

        grid[i][j]=-1;
        int p=findIsland(grid,i+1,j);
        int q=findIsland(grid,i-1,j);
        int r=findIsland(grid,i,j+1);
        int s=findIsland(grid,i,j-1);

        if(p==1 && q==1 && r==1 && s==1)
            return 1;
        return 0;
    }

    public static void main(String[] args) {

        NumberOfClosedIslands is=new NumberOfClosedIslands();
        System.out.println(is.closedIsland(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
