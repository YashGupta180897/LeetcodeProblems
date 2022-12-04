package com.company.general;

import java.util.Arrays;
import java.util.Collections;

public class CheapestFlightWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(k>0){
            int[] temp=dist.clone();
            for(int[] flight:flights){
                int u=flight[0];
                int v=flight[1];
                int uv=flight[2];
                if(dist[u]==Integer.MAX_VALUE)
                    continue;
                if(dist[u]+uv<temp[v])
                    temp[v]=dist[u]+uv;
            }
            dist=temp;
            k--;
        }
        return (dist[dst]==Integer.MAX_VALUE?-1:dist[dst]);

    }

    public static void main(String[] args) {

    }
}
