package com.gearcalc.service;

import com.gearcalc.GearRatioCalculatorApplication;
import com.gearcalc.entities.Wheel;
import com.gearcalc.repositories.WheelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GearRatioCalculatorApplication.class)
public class WheelServiceTest {


    @Autowired
    private WheelRepository wheelRepository;

    @Autowired
    private WheelService wheelService;

    private Wheel wheel;

    @Before
    public void init() {
        wheel = wheelRepository.getOne(1);
    }


    @Test
    public void getTotalWheelDiameter() {
        assertNotNull(wheel);

        double result = getTotalWheelDiameter(wheel);
        assertEquals(639.3, result, 0.1);
    }

    @Test
    public void getWheelCircumference() {
        double wheelCircum = wheelService.getWheelCircumference(wheel);
        assertEquals(2008.42, wheelCircum, 0.1);
    }

    private double getTotalWheelDiameter(Wheel wheel) {
        double totalProfile = wheel.getWidth() * (wheel.getProfile() / 100);
        double diamaterInMm = wheel.getDiameterInInches() * 2.56;
        return (totalProfile * 2) + (diamaterInMm * 10);
    }

}