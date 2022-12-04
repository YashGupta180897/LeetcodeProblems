package com.company.designPatterns.builder;

public class Architect {

    public static void main(String[] args) {
        Bedroom room1=new BedroomBuilder().setArea(100).setBalcony(true).createBedroom();
    }
}
