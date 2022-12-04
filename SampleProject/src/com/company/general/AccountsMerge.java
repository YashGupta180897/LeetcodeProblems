package com.company.general;

import java.util.*;

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        while(x!=parent[x]){
            x=parent[x];
        }
        return x;
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB)
            return;

        if(rank[parentA]>=rank[parentB]){
            rank[parentA]+=rank[parentB];
            parent[parentB]=parentA;
        }
        else{
            rank[parentB]+=rank[parentA];
            parent[parentA]=parentB;
        }
    }


}

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int accountListSize = accounts.size();
        UnionFind unionFind = new UnionFind(accountListSize);

        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < accountListSize; i++) {

            List<String> tempList = accounts.get(i);
            int accountSize = tempList.size();
            for (int j = 1; j < accountSize; j++) {
                String email = tempList.get(j);

                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    unionFind.union(i, emailGroup.get(email));
                }
            }
        }
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int parent = unionFind.find(group);
            if (!components.containsKey(parent)) {
                components.put(parent, new ArrayList<>());
            }
            components.get(parent).add(email);
        }

        List<List<String>> finalResult = new ArrayList<>();

        for (int group : components.keySet()) {
            List<String> emails = components.get(group);
            Collections.sort(emails);
            emails.add(0, accounts.get(group).get(0));
            finalResult.add(emails);
        }

        return finalResult;


    }

    public static void main(String[] args) {

        AccountsMerge ac=new AccountsMerge();
        List<List<String>> finalResult = new ArrayList<>();
        List<String> list1=new ArrayList<>(Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"));
        List<String> list2=new ArrayList<>(Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"));
        List<String> list3=new ArrayList<>(Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"));
        List<String> list4=new ArrayList<>(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
        List<String> list5=new ArrayList<>(Arrays.asList("David","David4@m.co","David1@m.co","David3@m.co"));
        finalResult.add(list1);
        finalResult.add(list2);
        finalResult.add(list3);
        finalResult.add(list4);
        finalResult.add(list5);
        System.out.println(ac.accountsMerge(finalResult));
    }

}

