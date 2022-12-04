package com.company.linkedlist;


public class DeleteDuplicates {


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
