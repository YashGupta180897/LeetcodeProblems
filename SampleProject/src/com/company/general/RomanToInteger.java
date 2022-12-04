package com.company.general;

public class RomanToInteger {
    static int romanToInt(String s) {

        int num=0;
        int length=s.length();
        for(int i=0;i<length;i++){


            if(s.charAt(i)=='I'){
                if((i+1)!=length && s.charAt(i+1)=='V'){
                    num+=4;
                    i++;
                }
                else if((i+1)!=length && s.charAt(i+1)=='X'){
                    num+=9;
                    i++;
                }
                else
                    num=num+1;
            }

            else if(s.charAt(i)=='V')
                num+=5;

            else if(s.charAt(i)=='X'){
                if((i+1)!=length && s.charAt(i+1)=='L'){
                    num+=40;
                    i++;
                }
                else if((i+1)!=length && s.charAt(i+1)=='C'){
                    num+=90;
                    i++;
                }

                else
                    num=num+10;
            }



            else if(s.charAt(i)=='L')
                num+=50;


            else if(s.charAt(i)=='C'){
                if((i+1)!=length && s.charAt(i+1)=='D'){
                    i++;
                    num+=400;
                }
                else if((i+1)!=length && s.charAt(i+1)=='M'){
                    num+=900;
                    i++;
                }
                else
                    num=num+100;
            }



            else if(s.charAt(i)=='D')
                num+=500;
            else if(s.charAt(i)=='M')
                num+=1000;


        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
