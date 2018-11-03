package com.gearcalc.entities;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "platform")
    private String platform;

    @Column(name = "transmission_type")
    private String transmissionType;

    @Column(name = "car_type")
    private String carType;

    @OneToOne
    @JoinColumn(name = "gearbox_id")
    private GearBox gearBox;

    @Column(name = "final_drive_ratio")
    private double finalDriveRatio;

    @Column(name = "redline")
    private int redLine;

    @OneToOne
    @JoinColumn(name = "wheel_id")
    private Wheel wheel;

    public Car() {
    }

    public Car(GearBox gearBox, double finalDriveRatio, int redLine, Wheel wheel) {
        this.gearBox = gearBox;
        this.finalDriveRatio = finalDriveRatio;
        this.redLine = redLine;
        this.wheel = wheel;
    }

    public Car(String model, String platform, String transmissionType, String carType, GearBox gearBox, double finalDriveRatio, int redLine) {
        this.model = model;
        this.platform = platform;
        this.transmissionType = transmissionType;
        this.carType = carType;
        this.gearBox = gearBox;
        this.finalDriveRatio = finalDriveRatio;
        this.redLine = redLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public double getFinalDriveRatio() {
        return finalDriveRatio;
    }

    public void setFinalDriveRatio(double finalDriveRatio) {
        this.finalDriveRatio = finalDriveRatio;
    }

    public int getRedLine() {
        return redLine;
    }

    public void setRedLine(int redLine) {
        this.redLine = redLine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
