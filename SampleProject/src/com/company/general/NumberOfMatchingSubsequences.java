package com.company.general;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {


    public static int numMatchingSubseq(String s, String[] words) {

        int count=0;
        Map<String,Integer> map=new HashMap<>();
        for (String word : words) {
            int j = 0;
            int k = 0;
            int wlen = word.length();
            int slen = s.length();
            if(map.containsKey(word)) {
                count += map.get(word);
                continue;
            }
            else
                map.put(word,0);
            while ((j < s.length() && k < word.length()) || (wlen > 0 && slen > 0)) {
                if (word.charAt(k) == s.charAt(j)) {
                    k++;
                }
                if (word.charAt(wlen-1) == s.charAt(slen-1)) {
                    wlen--;
                }
                slen--;
                j++;
                if (k == word.length() || wlen == 0) {
                    count++;
                    map.put(word,1);
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {


        String s="ziyyxhtfbmgvnmvsqusddpvmrfskzaexergyqpjjusjfbzakugrjkglikryksufbftcjsmlzjmuwqdvlndetuzsyacmzdyulnrmv";
        String[] arr=new String[]{"n","kugrjkglikryksufbftcjsmlzjmuwqdvlndetuzsyacmzdyul","muwqdvlndetuzsyacmzdyuln","vmrfskzaexergyqpjjusjfbzakugrjk","skzaexergyqpjjusjfbzakugrjkglikryksufbftcjsmlz","pywquphugcnfuvrduhrcoxxratptwmqmxwttykvkoskejgjhdy","rutbpwjugodzrgwzkvjzaafusqnsoiyvgszstwtlabgoeygfrx","ruhodvpdipmlacbuiuwmhpuvooraxrunwwlzctzsgacjupowdb","effkefvkcztipbojcttajvlexwuazmzqtfwubehuawmivyhzpw","geguatbhflhixqeikcnaxyugmepetztyblyrwfwnhzxofjonqs"};

        String s1="sssssssssssssssssssssssssssssssssssssssssssl";
        String[] arr1=new String[]{"sl","sl","sl"};
        System.out.println(numMatchingSubseq(s1,arr1));
    }
}
