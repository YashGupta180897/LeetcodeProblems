package com.company.general;

public class StringToInteger {

    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0)
            return 0;
        char sign='+';
        StringBuilder sb=new StringBuilder();
        int i=0;
        if(s.charAt(0)=='-'){
            sign='-';
            sb.append(sign);
            i=1;
        }
        else if(s.charAt(0)=='+')
            i=1;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            if(Long.parseLong(sb.toString())>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(Long.parseLong(sb.toString())<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        if(sb.length()==0 || (sb.length()==1 && (sb.charAt(0)=='-' || sb.charAt(0)=='+')))
            return 0;
        return Integer.parseInt(sb.toString());
    }
}
