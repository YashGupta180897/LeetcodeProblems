package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class ListNodeRemoveDuplicate {
    int val;
    ListNodeRemoveDuplicate next;
    ListNodeRemoveDuplicate() {}
    ListNodeRemoveDuplicate(int val) { this.val = val; }
    ListNodeRemoveDuplicate(int val, ListNodeRemoveDuplicate next) { this.val = val; this.next = next; }
}

class RemoveDuplicateFromSortedLinkedList {

    public ListNodeRemoveDuplicate deleteDuplicates(ListNodeRemoveDuplicate head) {
        ListNodeRemoveDuplicate temp1=head;
        if(temp1==null)
            return head;
        ListNodeRemoveDuplicate temp2=head.next;
        Set<Integer> set=new HashSet<>();
        set.add(temp1.val);
        while(temp2!=null){
            if(!set.add(temp2.val)){
                head.next=temp2.next;
            }
            else{
                set.add(temp2.val);
                head=head.next;
            }
            temp2=temp2.next;
        }
        return temp1;
    }

    public static void main(String[] args) {

    }
}
