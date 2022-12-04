package com.company.general;

public class SingleNumber2 {

    public static int singleNumber(int[] nums) {


        int[] bitsSet=new int[32];
        for (int n : nums) {
            for (int j = 0; j < 32; j++) {
                int mask = 1 << j;
                if ((n & mask) != 0)
                    bitsSet[j] = (bitsSet[j] + 1) % 3;
            }
        }
        int result=0;
        for(int i=0;i<32;i++){
            if(bitsSet[i]>0){
                result |= (1 << i);
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1, 1,2,1};
        System.out.println(singleNumber(nums));
    }
}
