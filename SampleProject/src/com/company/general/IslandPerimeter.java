package com.company.general;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return callBfs(grid,i,j,0);
                }
            }
        }
        return 0;
    }

    public int callBfs(int[][] grid, int i, int j,int count){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
            return count+1;

        grid[i][j]=0;
        count=callBfs(grid,i+1,j,count);
        count=callBfs(grid,i-1,j,count);
        count=callBfs(grid,i,j+1,count);
        count=callBfs(grid,i,j-1,count);

        return count;

    }

    public static void main(String[] args) {
        IslandPerimeter is=new IslandPerimeter();
        System.out.println(is.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
