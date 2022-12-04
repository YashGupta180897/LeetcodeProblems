package com.company.general;
import java.util.*;

public class MinimumFuelConsumption {

    ArrayList<ArrayList<Integer>> adjList;

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 11
        adjList=new ArrayList();
        int len=A.length+1;
        for(int i=0;i<len;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<len-1;i++){
            adjList.get(A[i]).add(B[i]);
            adjList.get(B[i]).add(A[i]);
        }

        int[] vertices = new int[len+1];
        int[] inDegree=new int[len+1];

        boolean[] vis=new boolean[len+1];

        dfs(0,vis,vertices);
        vis=new boolean[len+1];
        Queue<Integer> q=new LinkedList<>();
        int ans=0;
        q.add(0);
        vis[0]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:adjList.get(node)){
                if(!vis[i]){
                    ans+=(vertices[i]-1)/5+1;
                    q.add(i);
                    vis[i]=true;
                }
            }
        }
        return ans;
    }


    int dfs(int vertice, boolean[] vis, int[] vertices){
        vis[vertice]=true;
        int val=1;
        for(int node:adjList.get(vertice)){
            if(!vis[node]){
                val+=dfs(node,vis,vertices);
            }
        }
        vertices[vertice]=val;
        return val;
    }
}
