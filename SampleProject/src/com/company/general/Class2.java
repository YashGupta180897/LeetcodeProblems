package com.company.general;

import java.text.NumberFormat;
import java.util.*;

public class Class2{


    public static void main(String[] args) {
        Object i=new ArrayList<>().iterator();
        System.out.println(i instanceof List);
        System.out.println(i instanceof Iterator);
        System.out.println(i instanceof ListIterator);

        TreeSet map=new TreeSet();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("four");
        map.add("one");
        System.out.println(map);

        NumberFormat.getCurrencyInstance();

        /*List<String> MyList = Collections.singletonList("Value1");
        MyList.add("value2");
        System.out.println(MyList);*/

        List<String> list = Arrays.asList("foo", "bar");

        list.add("baz");
        System.out.println(list);

    }

}
