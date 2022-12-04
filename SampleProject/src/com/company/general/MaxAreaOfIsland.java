package com.company.general;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int area=callBFS(0,grid,i,j);
                    if(area>maxArea)
                        maxArea=area;
                }
            }
        }
        return maxArea;

    }

    public int callBFS(int area, int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
            return area;

        area++;
        grid[i][j]=0;
        area=callBFS(area,grid,i+1,j);
        area=callBFS(area,grid,i-1,j);
        area=callBFS(area,grid,i,j+1);
        area=callBFS(area,grid,i,j-1);

        return area;
    }

    public static void main(String[] args) {


        MaxAreaOfIsland max=new MaxAreaOfIsland();
        int area=max.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}});
        System.out.println(area);
    }
}
