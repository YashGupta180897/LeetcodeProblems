package com.company.general;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {




    public String getPermutation2(int n, int k) {
        List<Integer> list=new ArrayList<>();
        int fact=1;
        for(int i=1;i<=n;i++) {
            list.add(i);
            fact*=i;
        }
        k--;
        fact/=n;
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>0;i--){
            int curr=k/fact;
            sb.append(list.get(curr));
            list.remove(curr);
            k%=fact;
            fact/=i;
        }
        sb.append(list.get(0));
        return sb.toString();

    }

        public String getPermutation(int n, int k) {

        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(resultList,new ArrayList<>(),nums);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<resultList.get(k-1).size();i++){
            sb.append(resultList.get(k-1).get(i));
        }
        return sb.toString();
    }

    public void backTrack(List<List<Integer>> resultList, List<Integer> list, int[] nums){

        if(list.size()==nums.length){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for(int num:nums){
            if(list.contains(num))
                continue;
            list.add(num);
            backTrack(resultList,list,nums);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence ps=new PermutationSequence();

        System.out.println(ps.getPermutation2(3,3));
    }
}
