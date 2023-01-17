package com.company.general;

public class StringReplace {


    public static String solution(String riddle) {
        // Implement your solution here
        if(riddle==null || !riddle.contains("?"))
            return riddle;

        StringBuilder sb=new StringBuilder(riddle);
        char prev='\0';
        for(int i=0;i<riddle.length();i++){
            char curr=riddle.charAt(i);
            if(curr=='?'){
                char temp='a';
                char next='\0';
                if(i!=riddle.length()-1)
                    next=riddle.charAt(i+1);
                while(prev==temp || temp==next){
                    temp++;
                }
                prev=temp;
                sb.replace(i,i+1, String.valueOf(temp));
            }
            else
                prev=curr;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(solution("rd?e?wg??"));
    }
}
