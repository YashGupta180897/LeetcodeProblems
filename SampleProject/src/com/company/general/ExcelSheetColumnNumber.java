package com.company.general;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int sum=0;
        int count=1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            sum+=(int)(columnTitle.charAt(i)-64)*count;
            count*=26;
        }
        return sum;
    }
    public static void main(String[] args) {

        System.out.println(titleToNumber("BZ"));
    }
}
