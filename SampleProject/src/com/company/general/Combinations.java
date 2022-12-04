package com.company.general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result=new ArrayList<>();
        List<Boolean> fruit=new ArrayList<>();
        fruit.add(true);
        fruit.add(Boolean.parseBoolean("FalSe"));
        fruit.add(Boolean.TRUE);
        System.out.println(fruit.size());
        System.out.println(fruit.get(1) instanceof Boolean);
        //backTrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> comb, int n, int k, int start){
        if(comb.size()==k){
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int i=start;i<=n;i++){
            comb.add(i);
            backTrack(result, comb, n, k, i+1);
            comb.remove(comb.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations c=new Combinations();
        System.out.println(c.combine(4,2));
    }
}
