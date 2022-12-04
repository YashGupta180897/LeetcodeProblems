package com.company.general;

import java.util.HashSet;
import java.util.Set;

public class FactorialToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        int quotient=numerator/denominator;
        int remainder=numerator%denominator;
        StringBuilder sb=new StringBuilder();
        sb.append(quotient);
        if(remainder==0)
            return sb.toString();
        sb.append(".");
        if(numerator<0 || denominator<0)
        {
            denominator=Math.abs(denominator);
            remainder=Math.abs(remainder);
        }
        boolean repeat=false;
        StringBuilder sb2= new StringBuilder();
        int repeatPosition = 0;
        Set<Integer> set=new HashSet<>();
        set.add(remainder);
        while(remainder!=0){
            remainder*=10;
            quotient=remainder/denominator;
            if(set.contains(remainder) && Long.parseLong(sb2.toString())!=0){
                repeat=true;
                repeatPosition = sb2.toString().indexOf(quotient+"");
                break;
            }
            if(quotient==0){
                set.add(remainder);
                sb2.append("0");
            }
            else{
                sb2.append(quotient);
                set.add(remainder);
                remainder%=denominator;
            }
        }
        if(repeat){
            sb.append(sb2.toString().substring(0,repeatPosition));
            sb.append("(");
            sb.append(sb2.toString().substring(repeatPosition,sb2.length()));
            sb.append(")");
        }
        else{
            sb.append(sb2);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-50,8));
    }
}
