package com.gearcalc.domain;

public class VmaxOnGearParams {

    private int redLine;
    private double gearRatio;
    private double finalRatio;
    private double wheelCircumference;

    public VmaxOnGearParams(int redLine, double gearRatio, double finalRatio, double wheelCircumference) {
        this.redLine = redLine;
        this.gearRatio = gearRatio;
        this.finalRatio = finalRatio;
        this.wheelCircumference = wheelCircumference;
    }

    public double getVmaxOnGear() {
        return (this.redLine / (this.gearRatio * this.finalRatio) * (this.wheelCircumference / 1000) * 60) / 1000;
    }

}
