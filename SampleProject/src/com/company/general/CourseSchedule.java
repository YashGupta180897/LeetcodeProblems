package com.company.general;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int courses, int[][] pre) {

        if(pre==null || pre.length==0)
            return true;
        Map<Integer, List<Integer>> map=new HashMap<>();
        int[] noPrereqs = new int[courses];

        for(int[] edge:pre){
            int a=edge[0];
            int b=edge[1];
            noPrereqs[a]++;
            map.putIfAbsent(b,new ArrayList<>());
            map.get(b).add(a);
        }

        Queue<Integer> available=new LinkedList<>();
        for(int i=0;i<courses;i++){
            if(noPrereqs[i]==0)
                available.offer(i);
        }

        while(!available.isEmpty()){
            int cur=available.poll();
            List<Integer> list=map.get(cur);
            courses--;
            if(list!=null){
                for(int num:list){
                    noPrereqs[num]--;
                    if(noPrereqs[num]==0)
                        available.offer(num);
                }
            }
        }
        return courses==0;
    }

    public static void main(String[] args) {

        System.out.println(canFinish(4,new int[][]{{1,0},{2,0},{3,1},{3,2}}));

    }
}
