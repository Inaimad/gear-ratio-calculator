package com.gearcalc.service;

import com.gearcalc.GearRatioCalculatorApplication;
import com.gearcalc.common.CarBuilderFactory;
import com.gearcalc.entities.Wheel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GearRatioCalculatorApplication.class)
public class WheelServiceTest {

    private Wheel wheel;

    @Before
    public void init() {
        wheel = CarBuilderFactory.buildWheel();
    }

    @Test
    public void getTotalWheelDiameter() {
        double result = getTotalWheelDiameter(wheel);
        assertEquals(639.3, result, 0.1);
    }

    private double getTotalWheelDiameter(Wheel wheel) {
        double totalProfile = wheel.getWidth() * (wheel.getProfile() / 100);
        double diamaterInMm = wheel.getDiameterInInches() * 2.56;
        return (totalProfile * 2) + (diamaterInMm * 10);
    }

}