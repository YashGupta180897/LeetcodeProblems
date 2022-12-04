package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int s1l=s1.length();
        int s2l=s2.length();
        int s3l=s3.length();

        StringBuilder sb=new StringBuilder(s3);
        String[] chs2=s2.split("");
        for(int i=0;i<s2l;i++) {
            int x=s3.indexOf(chs2[i]);

            s3=s3.replaceFirst(chs2[i], "");
        }

        return s1.equals(s3);
    }
    public static void main(String[] args) {

        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
