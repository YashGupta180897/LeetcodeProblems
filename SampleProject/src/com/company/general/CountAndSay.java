package com.company.general;

public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        for(int j=1;j<n;j++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(s.charAt(i));
                    count = 1;
                }
            }
            String ch=Integer.toString(1);
            sb.append(count);
            s=sb.append(s.charAt(s.length() - 1)).toString();
        }
        return s;
    }


    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }
}
