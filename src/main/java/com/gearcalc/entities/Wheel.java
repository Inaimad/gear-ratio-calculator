package com.gearcalc.entities;


import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "width")
    private double width;

    @Column(name = "profile")
    private double profile;

    @Column(name = "diameter")
    private int diameterInInches;

    public Wheel() {

    }

    public Wheel(int width, int profile, int diameterInInches) {
        this.width = width;
        this.profile = profile;
        this.diameterInInches = diameterInInches;
    }

    public double getWheelCircumference() {
        return 2 * Math.PI * (this.getTotalWheelDiameter() / 2);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getDiameterInInches() {
        return diameterInInches;
    }

    public void setDiameterInInches(int diameterInInches) {
        this.diameterInInches = diameterInInches;
    }


    private double getTotalWheelDiameter() {
        double totalProfile = this.getWidth() * (this.getProfile() / 100);
        double diamaterInMm = this.getDiameterInInches() * 2.56;
        return (totalProfile * 2) + (diamaterInMm * 10);
    }
}
