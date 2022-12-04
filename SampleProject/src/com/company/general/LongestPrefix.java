package com.company.general;

public class LongestPrefix {

    static  String longestCommonPrefix(String[] strs) {

        int i=0;
        while(true){

            if(strs[0].length()<=i)
                break;
            char temp= strs[0].charAt(i);
            int flag=1;
            for(int j=1; j< strs.length; j++){

                if(strs[j].length()<=i){
                    flag=0;
                    break;
                }

                if(strs[j].charAt(i)!=temp) {
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                i++;
            }
            if(flag==0){
                break;
            }
        }
        if(i==0)
            return "";
        else
            return strs[0].substring(0,i);
    }

    public static void main(String[] args) {

        String[] strs= {"","",""};
        String s=longestCommonPrefix(strs);
        System.out.println(s);
    }
}
