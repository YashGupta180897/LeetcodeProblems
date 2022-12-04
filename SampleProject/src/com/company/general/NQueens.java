package com.company.general;

import java.util.*;

public class NQueens {

    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {

        String[][] board=new String[n][n];
        for(String[] row:board)
            Arrays.fill(row,".");
        result=new ArrayList<>();
        backTrack(board, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
        return result;
    }

    private void backTrack(String[][] board, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, int row){

        int n=board.length;
        if(row==n){
            for(int i=0;i<n;i++){
                List<String> list=new ArrayList<>();
                for(int j=0;j<n;j++){
                    list.add(board[i][j]);
                }
                result.add(list);
            }
        }
        int c;
        for(c=0;c<n;c++) {
            if (col.contains(c) || posDiag.contains(row + c) || negDiag.contains(row - c))
                continue;

            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            board[row][c] = "Q";
            backTrack(board, col, posDiag, negDiag, row + 1);

            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
            board[row][c] = ".";
        }
    }

    public static void main(String[] args) {
        NQueens q=new NQueens();
        System.out.println(q.solveNQueens(4));
    }
}
