package com.company.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Set<Character> setR=new HashSet<>();
        Set<Character> setC=new HashSet<>();
        Map<Integer,Set<Character>> map=new HashMap<>();
        for(int i=0;i<9;i++){
            setR.clear();
            setC.clear();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') {
                    if (!setR.add(board[i][j]))
                        return false;
                }
                if(board[j][i]!='.') {
                    if (!setC.add(board[j][i]))
                        return false;
                }
                if(board[i][j]!='.') {
                    if (map.get(j / 3 + i / 3 * 3) == null) {
                        Set<Character> set = new HashSet<>();
                        set.add(board[i][j]);
                        map.put(j / 3 + i / 3 * 3, set);
                    } else {
                        if (!map.get(j / 3 + i / 3 * 3).add(board[i][j]))
                            return false;
                    }
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {

        ValidSudoku v=new ValidSudoku();
        System.out.println(v.isValidSudoku(new char[][]
                {{'.','.','.','.','.','.','5','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'9','3','.','.','2','.','4','.','.'},
                        {'.','.','7','.','.','.','3','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','3','4','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','.'},
                        {'.','.','.','.','.','5','2','.','.'}}));
    }
}
