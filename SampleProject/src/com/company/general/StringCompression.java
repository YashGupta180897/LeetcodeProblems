package com.company.general;

public class StringCompression {

    public static int compress(char[] chars) {
        String s = new String(chars);
        int len=s.length();
        int count = 1;
        int x=0;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                if(count==1){
                    x++;
                    continue;
                }
                char[] charc = Integer.toString(count).toCharArray();
                chars[x++]=s.charAt(i);
                for(int j=0;j<charc.length;j++){
                    chars[x++]=charc[j];
                }
                count = 1;
            }
        }
        if(x<len-1){
            char[] charc = Integer.toString(count).toCharArray();
            chars[x++]=s.charAt(len-1);
            for(int j=0;j<charc.length;j++){
                chars[x++]=charc[j];
            }
            return x;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
