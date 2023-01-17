package com.company.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestApp {

    public static void main(String[] args) {

        String s="ewqdfewfqede";
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.putIfAbsent(ch,0);
            map.put(ch,map.get(ch)+1);
        }
        Iterator itr=map.entrySet().iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        /*for(Map.Entry<Character, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }*/

    }
}

//Select e.* from employee e, salary s where e.empId=s.empId order by s.salary desc limit 1 offset 1;
