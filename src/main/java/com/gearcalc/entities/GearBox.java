package com.gearcalc.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GearBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double first;
    private double second;
    private double third;
    private double fourth;
    private double fifth;
    private double sixth;

    public GearBox() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getThird() {
        return third;
    }

    public void setThird(double third) {
        this.third = third;
    }

    public double getFourth() {
        return fourth;
    }

    public void setFourth(double fourth) {
        this.fourth = fourth;
    }

    public double getFifth() {
        return fifth;
    }

    public void setFifth(double fifth) {
        this.fifth = fifth;
    }

    public double getSixth() {
        return sixth;
    }

    public void setSixth(double sixth) {
        this.sixth = sixth;
    }

}
