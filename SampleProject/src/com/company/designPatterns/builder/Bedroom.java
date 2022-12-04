package com.company.designPatterns.builder;

public class Bedroom {

    int ceiling_height;
    double area;
    int noOfWardrobes;
    boolean balcony;

    public Bedroom(int ceiling_height, double area, int noOfWardrobes, boolean balcony) {
        this.ceiling_height = ceiling_height;
        this.area = area;
        this.noOfWardrobes = noOfWardrobes;
        this.balcony = balcony;
    }
}
