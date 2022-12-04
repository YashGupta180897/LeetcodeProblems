package com.company.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HousingNames {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int arr[]=new int[number];
        for(int i=0;i<number;i++){
            arr[i]=Integer.parseInt(sc.next());
        }

        List<Integer> listOdd=new ArrayList<>();
        List<Integer> listEven=new ArrayList<>();
        for(int i:arr){
            if(i%2==0)
                listEven.add(i);
            else
                listOdd.add(i);
        }
        Collections.sort(listEven);
        listOdd.sort(Collections.reverseOrder());
        listOdd.addAll(listEven);

        for(int i: listOdd) {
            System.out.print(i+" ");
        }


    }
}
