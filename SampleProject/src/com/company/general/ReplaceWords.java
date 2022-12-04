package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode{

    TrieNode[] links;
    boolean isEnd;
    String word;

    public TrieNode(){
        links=new TrieNode[26];
    }

    public TrieNode getLinks(char ch){
        return links[ch-'a'];
    }

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd(){
        isEnd=true;
    }

    public boolean getIsEnd(){
        return isEnd;
    }

    public void setWord(String word){
        if(isEnd)
            this.word=word;
        else
            this.word=null;
    }

    public String getWord(){
        return this.word;
    }
}


public class ReplaceWords {

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        insertNodes(dictionary);
        StringBuilder sb=new StringBuilder();
        String[] words=sentence.split("\\s");
        for(String word:words){
            word=replaceWord(word);
            sb.append(word);
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public String replaceWord(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
                break;
            if(node.containsKey(ch)){
                node=node.getLinks(ch);
                if(node.isEnd)
                    return node.getWord();
            }
        }
        return word;
    }

    public void insertNodes(List<String> dictionary){
        TrieNode node = root;
        for(String s:dictionary){
            node = root;
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(!node.containsKey(ch))
                    node.put(ch,new TrieNode());
                node=node.getLinks(ch);
            }
            node.setEnd();
            node.setWord(s);
        }
    }

    public static void main(String[] args) {
        ReplaceWords r=new ReplaceWords();
        List<String> list=new ArrayList<>(Arrays.asList("cat","rat","bat"));
        System.out.println(r.replaceWords(list,"the cattle was rattled by the battery"));
    }
}
