package com.company.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Matchsticks2Square {

    public static boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i:matchsticks){
            sum+=i;
        }
        int sideLength=sum/4;
        if(sum%4!=0)
            return false;

        matchsticks=Arrays.stream(matchsticks).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        IntStream.range(1,100);


        int[] arr=new int[]{sideLength,sideLength,sideLength,sideLength};

        return makeSquareHelper(matchsticks,0,arr);

    }

    private static boolean makeSquareHelper(int[] matchsticks, int i, int[] arr) {
        if(i==matchsticks.length)
            return arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0;

        for(int j=0;j<4;j++){
            if(matchsticks[i]>arr[j])
                continue;
            arr[j]-=matchsticks[i];
            if(makeSquareHelper(matchsticks,i+1,arr))
                return true;
            arr[j]+=matchsticks[i];

        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr={0,0,0,1};
        System.out.println(makesquare(arr));
    }
}
