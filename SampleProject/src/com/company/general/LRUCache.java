package com.company.general;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node3 head;
    Node3 tail;
    int capacity;
    Map<Integer,Node3> map;
    public LRUCache(int capacity) {
        head=new Node3(0,0);
        tail=new Node3(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node3 node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            map.remove(tail.prev.key);
        }
        insert(new Node3(key,value));
    }

    private void remove(Node3 node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;

    }

    private void insert(Node3 node){
        map.put(node.key,node);
        Node3 tempNode=head.next;
        node.prev=head;
        head.next=node;
        tempNode.prev=node;
        node.next=tempNode;
    }

    public static void main(String[] args) {

        LRUCache lru=new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);

    }
}

class Node3{

    int key;
    int value;
    Node3 prev,next;

    Node3(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
