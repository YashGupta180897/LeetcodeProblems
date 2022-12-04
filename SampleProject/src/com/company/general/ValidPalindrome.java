package com.company.general;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        String rep=s.replaceAll("[^A-Za-z0-9]","");
        System.out.println(rep);
        StringBuilder sb=new StringBuilder();
        for(int i=rep.length()-1;i>=0;i--){
            sb.append(rep.charAt(i));
        }
        return rep.equalsIgnoreCase(sb.toString());

    }

    public static void main(String[] args) {

        isPalindrome("A man, a plan, a canal: Panama");

    }
}
