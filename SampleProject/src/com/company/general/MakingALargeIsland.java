package com.company.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {


    public int largestIsland(int[][] grid) {

        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        int islandId =2;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int area=0;
                if(grid[i][j]==1) {
                    area=callDfs(grid, i, j, islandId, area);
                    map.put(islandId,area);
                    islandId++;
                }
                if(area>max)
                    max=area;
            }
        }

        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area=0;
                if(grid[i][j]==0){
                    area=checkNeighbours(grid,i,j,map);
                }
                if(area>max)
                    max=area;
            }
        }
        return max;
    }

    private int checkNeighbours(int[][] grid, int i, int j, Map<Integer,Integer> map) {
        int area=1;
        Set<Integer> set=new HashSet<>();
        if(i>0 && grid[i-1][j]!=0 && !set.contains(grid[i-1][j])) {
            int x=map.get(grid[i - 1][j]);
            area += x;
            set.add(grid[i-1][j]);
        }
        if(j>0 && grid[i][j-1]!=0 && !set.contains(grid[i][j-1])){
            int x=map.get(grid[i][j-1]);
            area += x;
            set.add(grid[i][j-1]);
        }
        if(i<grid.length-1 && grid[i+1][j]!=0 && !set.contains(grid[i+1][j])){
            int x=map.get(grid[i+1][j]);
            area += x;
            set.add(grid[i+1][j]);
        }
        if(j<grid[i].length-1 && grid[i][j+1]!=0 && !set.contains(grid[i][j+1])){
            int x=map.get(grid[i][j+1]);
            area += x;
            set.add(grid[i][j+1]);
        }
        return area;
    }

    private int callDfs(int[][] grid, int i, int j, int islandId, int area) {

        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]!=1)
            return area;

        grid[i][j]=islandId;
        area++;
        area=callDfs(grid, i+1, j, islandId, area);
        area=callDfs(grid, i-1, j, islandId, area);
        area=callDfs(grid, i, j+1, islandId, area);
        area=callDfs(grid, i, j-1, islandId, area);

        return area;
    }

    public static void main(String[] args) {

        MakingALargeIsland m=new MakingALargeIsland();
        System.out.println(m.largestIsland(new int[][]{{1,1},{1,0}}));
    }


}
