package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddStrings {

    public static String addStrings(String num1, String num2) {

        int carry=0;
        int sum=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder s=new StringBuilder();
        int val=0;
        while(i>=0 && j>=0){
            sum=num1.charAt(i)-'0'+num2.charAt(j)-'0'+carry;
            val=sum%10;
            carry=sum/10;
            s.append(val);
            i--;
            j--;
        }
            while(i>=0) {
                sum = num1.charAt(i) -'0'+ carry;
                val = sum % 10;
                carry = sum / 10;
                s.append(val);
                i--;
            }

            while(j>=0) {
                sum = num2.charAt(j) -'0' + carry;
                val = sum % 10;
                carry = sum / 10;
                s.append(val);
                j--;
            }
            if(carry!=0)
                s.append(carry);
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11",
                "123"));

        List<String> list=new ArrayList<>(Arrays.asList(" ","  Panda"," fish ", "HORSE  "," CAT"));

        List<String> realAnimals = list.stream().map(String::trim).
                filter(s -> !s.isEmpty()).map(String::toLowerCase).collect(Collectors.toList());

        System.out.println(realAnimals);

        int unsigned=Integer.parseUnsignedInt("4000000000");
        System.out.println(unsigned);
        int result=Integer.divideUnsigned(unsigned,2);
        System.out.println(result);

        String s="13_31#12_31";
        String[] arr=s.split("#");
        String[] arr2=arr[0].split("_");
    }
}
