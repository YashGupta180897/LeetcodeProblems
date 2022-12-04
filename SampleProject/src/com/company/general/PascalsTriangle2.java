package com.company.general;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<rowIndex;i++){
            list.add(computation(rowIndex,i));
        }
        list.add(1);
        return list;
    }

    public BigInteger factorial(int n){
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public int computation(int n, int r){
        return factorial(n).divide(factorial(r)).divide(factorial(n-r)).intValue();
    }
    public static void main(String[] args) {


        PascalsTriangle2 p=new PascalsTriangle2();
        System.out.println(p.getRow(33));
    }
}
