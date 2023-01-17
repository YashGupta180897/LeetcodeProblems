package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class Maine {

    public static void fun(String s)
    {
        System.out.println("String");
    }
    public static void fun(Object o)
    {
        System.out.println("Object");
    }
    public static void fun(Integer i)
    {
        System.out.println("Integer");
    }

    public static void main(String args[])
    {
        ArrayList list=new ArrayList();
        list.add(1);
        list.add("ve");
        System.out.println(list);
    }

}
