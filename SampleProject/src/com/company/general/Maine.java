package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class Maine {

    public static void main(String[] args) {
        /*Class1 c=new Class1();
        c.show();
        c.cal(2,3);
        System.out.println(c.x);
        System.out.println(c.y);*/

        List a=new ArrayList();
        a.add("Alice");
        a.add(1);
        System.out.println(a.get(0) instanceof Object);
        System.out.println(a.get(1) instanceof Integer);
        a.add("bob");
        ArrayList b=new ArrayList();
        b.add("a");
        b.add("c");
        a.addAll(b);
        System.out.println(a);
    }
}
