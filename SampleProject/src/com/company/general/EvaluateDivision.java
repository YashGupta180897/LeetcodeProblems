package com.company.general;


import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String,List<GraphNode>> graph = buildGraph(equations,values);
        double[] result=new double[queries.size()];

        int i=0;
        for(List<String> query: queries){
            String src=query.get(0);
            String dst=query.get(1);
            result[i++]=dfs(src,dst,new HashSet<>(),graph);
        }
        return result;
    }

    private double dfs(String src, String dst, Set<String> visited, Map<String, List<GraphNode>> graph) {

        if(!graph.containsKey(src) || !graph.containsKey(dst))
            return -1;
        if(src.equals(dst))
            return 1;

        visited.add(src);
        for(GraphNode node: graph.get(src)){
            if(!visited.contains(node.key)){
                double ans=dfs(node.key,dst,visited,graph);
                if(ans!=-1)
                    return ans*node.val;
            }
        }
        return -1;
    }

    private Map<String, List<GraphNode>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String,List<GraphNode>> graph=new HashMap<>();
        int i=0;
        for(List<String> equation: equations){
            String src=equation.get(0);
            String dst=equation.get(1);
            graph.putIfAbsent(src,new ArrayList<>());
            graph.putIfAbsent(dst,new ArrayList<>());
            graph.get(src).add(new GraphNode(dst,values[i]));
            graph.get(dst).add(new GraphNode(src,1/values[i]));
            i++;
        }
        return graph;
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        List<String> list1=new ArrayList<>(Arrays.asList("a","b"));
        List<String> list2=new ArrayList<>(Arrays.asList("b","c"));
        equations.add(list1);
        equations.add(list2);

        List<List<String>> queries = new ArrayList<>();
        List<String> list3=new ArrayList<>(Arrays.asList("a","c"));
        List<String> list4=new ArrayList<>(Arrays.asList("b","a"));
        List<String> list5=new ArrayList<>(Arrays.asList("a","e"));
        List<String> list6=new ArrayList<>(Arrays.asList("a","a"));
        List<String> list7=new ArrayList<>(Arrays.asList("e","e"));
        queries.add(list3);
        queries.add(list4);
        queries.add(list5);
        queries.add(list6);
        queries.add(list7);

        EvaluateDivision ed=new EvaluateDivision();
        System.out.println(Arrays.toString(ed.calcEquation(equations, new double[]{2.0, 3.0}, queries)));

    }
}

class GraphNode{
    String key;
    double val;
    GraphNode(String k,double v){
        key=k;
        val=v;
    }
}

