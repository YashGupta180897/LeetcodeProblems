package com.company.general;

import java.util.*;

public class CountUnreachablePairOfNodes {

    long ans=0;
    public long countPairs(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjList=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        constructAdjList(n,edges,adjList);
        int total=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)) {
                ans = 0;
                dfs(i, visited, adjList);
                total += ans * (n - ans);
            }
        }
        return total/2;
    }

    private void  dfs(int currNode, Set<Integer> visited,Map<Integer, List<Integer>> map){
        visited.add(currNode);
        ans++;
        List<Integer> l=map.get(currNode);
        for (Integer integer : l) {
            if(!visited.contains(integer))
                dfs(integer, visited, map);
        }
    }

    private void constructAdjList(int n, int[][] edges, Map<Integer, List<Integer>> map){
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] edge:edges){
            int s1=edge[0];
            int s2=edge[1];

            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
    }

    public static void main(String[] args) {

        int n=3;
        CountUnreachablePairOfNodes c=new CountUnreachablePairOfNodes();
        System.out.println(c.countPairs(n,new int[][]{{0,1},{0,2},{1,2}}));
    }
}
