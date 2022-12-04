package com.company.linkedlist;

public class LinkedList {

    private ListNode head;

    public String toString(){

        StringBuilder result= new StringBuilder("{");
        ListNode curr=this.head;

        while(curr!=null){
            result.append(curr.val);
            curr=curr.next;
        }
        return result.toString();
    }
}
