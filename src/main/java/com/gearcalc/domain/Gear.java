package com.gearcalc.domain;


public class Gear {

    private String gearNumber;
    private double ratio;

    public Gear() {}

    public Gear(String gearNumber, double ratio) {
        this.gearNumber = gearNumber;
        this.ratio = ratio;
    }

    public String getGearNumber() {
        return gearNumber;
    }

    public void setGearNumber(String gearNumber) {
        this.gearNumber = gearNumber;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
