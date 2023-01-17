package com.company.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PipeLine {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q=Integer.parseInt(br.readLine());
        List<List<Integer>> queries=new ArrayList();
        for(int i=0;i<Q;i++){
            List<Integer> list=new ArrayList<>();
            String s=br.readLine();
            String[] split=s.split(" ");
            list.add(Integer.valueOf(split[0]));
            list.add(Integer.valueOf(split[1]));
            queries.add(list);
        }
        // Output the solution to the console
        System.out.println(codeHere(queries));
    }
    public static String codeHere(List<List<Integer>> queries) {
        // Use this function to write your solution;
        StringBuilder sb=new StringBuilder();
        int Q=queries.size();
        Map<Integer, Integer> frequency=new HashMap<>();
        Map<Integer, Stack<Integer>> group=new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<Q;i++){
            List<Integer> currList=queries.get(i);
            if(currList.get(0)==1){
                int x=currList.get(1);
                int freq=frequency.getOrDefault(x, 0)+1;
                frequency.put(x, freq);
                maxFreq=Math.max(maxFreq, freq);
                group.computeIfAbsent(freq, z->new Stack<>()).push(x);
            }
            else{

                int x=group.get(maxFreq).pop();
                frequency.put(x, frequency.get(x)-1);
                if(group.get(maxFreq).size()==0)
                    maxFreq--;
                sb.append(x+" ");
            }
        }
        sb.deleteCharAt(sb.toString().length()-1);
        return sb.toString();
    }
}
