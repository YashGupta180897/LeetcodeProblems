package com.company.general;

public class TowerOfHanoi {

    public static void towerOfHanoi(int numberOfDiscs, char from, char to, char intermediate){

        if(numberOfDiscs==1){
            System.out.println("Moving disc 1 from "+from+ " to "+to);
        }
        else {
            towerOfHanoi(numberOfDiscs - 1, from, intermediate, to);
            System.out.println("Moving disc " + numberOfDiscs + " from " + from + " to " + to);
            towerOfHanoi(numberOfDiscs - 1, intermediate, to, from);
        }
    }

    public static void main(String[] args) {
        towerOfHanoi(4,'A', 'C', 'B');
    }
}
