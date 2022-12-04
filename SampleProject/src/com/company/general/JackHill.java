package com.company.general;

import java.util.Scanner;

public class JackHill {



    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int time=sc.nextInt();

        int diff=b-a;
        int ans=0;
        if(diff>=time)
            ans=a+time;
        else
        {
            if((time/diff)%2==0)
                ans=a+time%diff;
            else
                ans=b-time%diff;
        }
        System.out.println(ans);
    }
}
