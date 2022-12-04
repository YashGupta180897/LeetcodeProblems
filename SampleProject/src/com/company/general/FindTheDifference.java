package com.company.general;

public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int firstSum=0;
        int secondSum=0;
        for(int i=0;i<s.length();i++){
            firstSum+=s.charAt(i);
            secondSum+=t.charAt(i);
        }
        secondSum+=t.charAt(s.length());
        return (char)(secondSum-firstSum);
    }

    public static char findTheDifference2(String s, String t) {
        int xor=0;
        for(int i=0;i<s.length();i++){
            xor^=s.charAt(i);
            xor^=t.charAt(i);
        }
        xor^=t.charAt(s.length());
        return (char)xor;
    }
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
        System.out.println(findTheDifference2("abcd","abcde"));

    }
}
