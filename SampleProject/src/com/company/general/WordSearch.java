package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean flag;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    flag=callDFS(board,word,i,j,0);
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean callDFS(char[][] board, String word, int i, int j,int index) {

        if (index == word.length())
            return true;

        if(i<0 || j<0 || i>=board.length || j>=board[i].length || word.charAt(index)!=board[i][j]){
            return false;
        }

        char temp=board[i][j];
        board[i][j]=' ';
        boolean found= callDFS(board,word,i+1,j,index+1) || callDFS(board,word,i-1,j,index+1) ||
                callDFS(board,word,i,j-1,index+1) || callDFS(board,word,i,j+1,index+1);

        board[i][j]=temp;
        return found;
    }

    public static void main(String[] args) {

        WordSearch w=new WordSearch();
        System.out.println(
                w.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},
                        "ABCESEEEFS"));
    }
}
