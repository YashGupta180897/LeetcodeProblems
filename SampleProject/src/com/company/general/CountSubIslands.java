package com.company.general;

public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        boolean isSubTree=true;
        int count=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[i].length;j++){
                if(grid2[i][j]==1){
                    isSubTree=true;
                    isSubTree=searchIsland(grid2,grid1,i,j,isSubTree);
                    if(isSubTree)
                        count++;
                }
            }
        }
        return count;
    }

    private boolean searchIsland(int[][] grid2, int[][] grid1, int i, int j, boolean isSubtree){
        if(i<0 || j<0 || i>=grid2.length || j>=grid2[i].length || grid2[i][j]==0)
            return true;

        if(grid2[i][j]==1 && grid1[i][j]!=1)
            return false;

        grid2[i][j]=0;

        boolean p=searchIsland(grid2,grid1,i+1,j,isSubtree);
        boolean q=searchIsland(grid2,grid1,i-1,j,isSubtree);
        boolean r=searchIsland(grid2,grid1,i,j-1,isSubtree);
        boolean s=searchIsland(grid2,grid1,i,j+1,isSubtree);

        return p && q && r && s;
    }

    public static void main(String[] args) {
        CountSubIslands is=new CountSubIslands();
        System.out.println(is.countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));

    }
}
