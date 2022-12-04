package com.company.general;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> result=new ArrayList<>();
        int[] maxFrequency=new int[26];
        for(String w: words2){
            int[] frequency = getFrequencyCount(w);
            for(int j=0;j<26;j++){
                maxFrequency[j]=Math.max(frequency[j],maxFrequency[j]);
            }
        }
        for(String w: words1){
            int flag=0;
            int[] frequency = getFrequencyCount(w);
            for(int j=0;j<26;j++){
                if(maxFrequency[j]<frequency[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                result.add(w);
        }
        return result;
    }


    public int[] getFrequencyCount(String w){
        int[] res=new int[26];
        for(char c: w.toCharArray()){
            res[c-'a']++;
        }
        return res;
    }

    public static void main(String[] args) {
        WordSubsets w=new WordSubsets();
        w.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","o"});
    }
}
