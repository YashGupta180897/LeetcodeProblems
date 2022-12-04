package com.company.general;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        StringBuilder s=new StringBuilder();
        for (int j : num) {
            s.append(j);
        }
        int i=s.length()-1;
        int sum=0;
        int carry=0;
        int val=0;
        LinkedList<Integer> l=new LinkedList<>();
        while(i>=0){
            sum=s.charAt(i)-'0'+ (k%10) + carry;
            k/=10;
            val=sum%10;
            carry=sum/10;
            l.addFirst(val);
            i--;
        }
        while(k!=0){
            sum=(k%10) + carry;
            k/=10;
            val=sum%10;
            carry=sum/10;
            l.addFirst(val);
        }
        if(carry!=0)
            l.addFirst(carry);

        return l;

    }

    public static void main(String[] args) {

        int num[]={1,2,3,4,5};
        for(int i:num){
            System.out.print("\f"+i);
        }
        //System.out.println(addToArrayForm(num,45));

    }
}

