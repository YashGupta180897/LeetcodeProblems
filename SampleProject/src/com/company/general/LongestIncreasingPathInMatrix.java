package com.company.general;

public class LongestIncreasingPathInMatrix {

    private int[][] DIRECTIONS=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {

        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] cache=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=callDfs2(matrix,cache,i,j,m,n,0);
                max=Math.max(count,max);
            }
        }
        return max;
    }

    private int callDfs(int[][] matrix,int[][] cache, int i, int j,int m,int n) {

        if(cache[i][j]>0)
            return cache[i][j];

        int max=0;

        for(int[] direction:DIRECTIONS){
            int x=i+direction[0];
            int y=j+direction[1];
            if(x>-1 && y>-1 && x<n && y<m && matrix[i][j]<matrix[x][y]){
                int longestPath=callDfs(matrix,cache,x,y,m,n);
                max=Math.max(max,longestPath);
            }
        }
        cache[i][j] = max+1;
        return cache[i][j];
    }

    private int callDfs2(int[][] matrix,int[][] cache, int i, int j,int m,int n,int prev) {

        if(i<0 || j<0 || i>=n || j>=m || matrix[i][j]<prev)
            return 0;

        if(cache[i][j]>0)
            return cache[i][j];

        int max=0;

        int longestPath=callDfs2(matrix,cache,i-1,j,m,n,matrix[i][j]);
        max=Math.max(max,longestPath);
        longestPath=callDfs2(matrix,cache,i+1,j,m,n,matrix[i][j]);
        max=Math.max(max,longestPath);
        longestPath=callDfs2(matrix,cache,i,j-1,m,n,matrix[i][j]);
        max=Math.max(max,longestPath);
        longestPath=callDfs2(matrix,cache,i,j+1,m,n,matrix[i][j]);
        max=Math.max(max,longestPath);


        cache[i][j] = max+1;
        return cache[i][j];
    }

    public static void main(String[] args) {

        LongestIncreasingPathInMatrix l=new LongestIncreasingPathInMatrix();
        System.out.println(l.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
