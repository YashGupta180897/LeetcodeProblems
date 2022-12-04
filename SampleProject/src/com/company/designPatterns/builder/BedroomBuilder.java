package com.company.designPatterns.builder;

public class BedroomBuilder {
    private int ceiling_height;
    private double area;
    private int noOfWardrobes;
    private boolean balcony;

    public BedroomBuilder setCeiling_height(int ceiling_height) {
        this.ceiling_height = ceiling_height;
        return this;
    }

    public BedroomBuilder setArea(double area) {
        this.area = area;
        return this;
    }

    public BedroomBuilder setNoOfWardrobes(int noOfWardrobes) {
        this.noOfWardrobes = noOfWardrobes;
        return this;
    }

    public BedroomBuilder setBalcony(boolean balcony) {
        this.balcony = balcony;
        return this;
    }

    public Bedroom createBedroom() {
        return new Bedroom(ceiling_height, area, noOfWardrobes, balcony);
    }
}