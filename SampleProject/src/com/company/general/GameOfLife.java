package com.company.general;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        int rows=board.length;
        int col=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                int neighbors=countNeighbors(board, i ,j);
                if(board[i][j]==1){
                    if(neighbors==2 || neighbors==3)
                        board[i][j]=3;
                }
                else if(board[i][j]==0){
                    if(neighbors==3)
                        board[i][j]=2;
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==2 || board[i][j]==3)
                    board[i][j]=1;
                else
                    board[i][j]=0;
            }
        }

    }

    private int countNeighbors(int[][] board, int i, int j){
        int count=0;
        if(i>0 && ((board[i-1][j]==1 || board[i-1][j]==3)))
            count++;
        if(i+1<board.length && ((board[i+1][j]==1) || (board[i+1][j]==3)))
            count++;
        if(j>0 && ((board[i][j-1]==1) || (board[i][j-1]==3)))
            count++;
        if(j+1<board[0].length && ((board[i][j+1]==1) || (board[i][j+1]==3)))
            count++;
        if(i>0 && j>0 && ((board[i-1][j-1]==1) || (board[i-1][j-1]==3)))
            count++;
        if(i+1<board.length && j>0 && ((board[i+1][j-1]==1) || (board[i+1][j-1]==3)))
            count++;
        if(i>0 && j+1<board[0].length && ((board[i-1][j+1]==1) || (board[i-1][j+1]==3)))
            count++;
        if(i+1<board.length && j+1<board[0].length && ((board[i+1][j+1]==1) || (board[i+1][j+1]==3)))
            count++;

        return count;
    }

    public static void main(String[] args) {
        GameOfLife gof=new GameOfLife();
        gof.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
