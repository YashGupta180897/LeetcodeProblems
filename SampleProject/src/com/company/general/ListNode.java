package com.company.general;

import java.util.List;

public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode sorted=new ListNode();
        ListNode temp=sorted;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                temp.next=new ListNode(l2.val);
                temp=temp.next;
                l2=l2.next;
            }
            else{
                temp.next=new ListNode(l1.val);
                temp=temp.next;
                l1=l1.next;
            }
        }
        if(l2==null){
            while(l1!=null){
                temp.next=new ListNode(l1.val);
                l1=l1.next;
                temp=temp.next;
            }
        }
        if(l1==null){
            while(l2!=null){
                temp.next=new ListNode(l2.val);
                l2=l2.next;
                temp=temp.next;
            }
        }
        return sorted.next;
    }

    public static ListNode removeElements(ListNode head, int val) {


        ListNode prev=null;
        ListNode after=null;
        ListNode curr=head;
        while(curr!=null){
            if(prev==null && curr.val==val) {
                after = curr.next;
                curr.next=null;
                curr=after;
                head=curr;
            }
            else if(curr.val==val){
                prev.next=curr.next;
                curr=curr.next;
            }
            else{
                prev=curr;
                curr=curr.next;
            }

        }
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int start, int end){
        ListNode prev, curr, leftStart, rightEnd, startCurr, after;
        curr=head;
        prev=null;
        startCurr=prev;
        int startIndex=1;
        while(startIndex!=start && curr!=null){
            startCurr = curr;
            curr=curr.next;
            startIndex++;
        }
        leftStart=curr;
        while(startIndex!=end && curr!=null){
            curr=curr.next;
            startIndex++;
        }
        rightEnd=curr;
        ListNode rightNext=null;
        if(curr.next!=null)
            rightNext=curr.next;

        curr=leftStart;
        while(curr!=rightEnd && curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }

        curr.next=prev;
        if(startCurr!=null)
            startCurr.next=curr;
        else
            head=curr;

        leftStart.next=rightNext;

        return head;

    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null)
            return null;

        ListNode curr=head.next;
        ListNode prev=head;
        ListNode first=null;
        int flag=0;
        while(curr!=null){
            if(prev.val==curr.val){
                prev.next=curr.next;
                curr=prev.next;
                flag=1;
            }
            else{
                if(flag==1 && first==null){
                    head=curr;
                    flag=0;
                }
                else if(flag==1){
                    first.next=curr;
                    flag=0;
                }
                else
                    first=prev;
                prev=curr;
                curr=curr.next;
            }


        }
        if(flag==1 && first==null)
            return null;
        else if(flag==1){
            first.next=curr;
        }
        return head;
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
        l2.val=2;
        l3.val=2;
        l4.val=2;
        l5.val=3;
        l6.val=5;
        l7.val=6;

        l1.next=l2;
        l2.next=l3;
        /*l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;*/
        System.out.println(deleteDuplicates(l1).toString());

    }
}