package com.company.linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class NextLargerNodes {
    public static int[] nextLargerNodes(ListNode head) {

        ListNode curr=head;
        int len=0;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] arr=new int[len];
        curr=head;
        while(curr!=null){
            while(!stack.isEmpty() && stack.peek()<curr.val)
                map.put(stack.pop(),curr.val);
            stack.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        for(int i=0;i<len;i++){
            arr[i]=map.getOrDefault(curr.val,0);
            curr=curr.next;
        }
        return arr;

    }

    public static void main(String[] args) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();
        ListNode l3=new ListNode();
        ListNode l4=new ListNode();
        ListNode l5=new ListNode();
        ListNode l6=new ListNode();
        ListNode l7=new ListNode();

        l1.val=1;
        l2.val=7;
        l3.val=5;
        l4.val=1;
        l5.val=9;
        l6.val=2;
        l7.val=5;

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        System.out.println(nextLargerNodes(l1));

    }
}
