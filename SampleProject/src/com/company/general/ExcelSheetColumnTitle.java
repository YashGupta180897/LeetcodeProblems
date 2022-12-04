package com.company.general;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {

        int mod=1;
        StringBuilder ans= new StringBuilder();
        while(columnNumber>26){
            mod=columnNumber%26;
            if(mod!=0) {
                ans.insert(0, (char) (mod + 64));
                columnNumber /= 26;
            }
            else {
                ans.insert(0, 'Z');
                columnNumber /= 26;
                columnNumber-=1;
            }
        }
        ans.insert(0, (char) (columnNumber + 64));
        return ans.toString();
    }

    public static void main(String[] args) {


        BigDecimal first=BigDecimal.ONE;
        BigDecimal second=BigDecimal.TEN;
        System.out.println(first.compareTo(second));

        System.out.println(convertToTitle(2147483647));


    }
}
