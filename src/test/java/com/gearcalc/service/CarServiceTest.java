package com.gearcalc.service;

import com.gearcalc.GearRatioCalculatorApplication;
import com.gearcalc.common.CarBuilderFactory;
import com.gearcalc.entities.Car;
import com.gearcalc.dto.SpeedResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GearRatioCalculatorApplication.class)
public class CarServiceTest {

    @Autowired
    private CarService carService;
    private Car car;

    @Before
    public void init() {
        car = CarBuilderFactory.buildE46328ci();
    }

    @Test
    public void testVmaxPerGearValuesShouldBeCorrect() {
        SpeedResponse speedResponse = carService.getVmaxPerGear(car);
        assertEquals(63.5, speedResponse.getSpeedPerGearMap().get("First"), 0.5);
        assertEquals(107.3, speedResponse.getSpeedPerGearMap().get("Second"), 0.5);
        assertEquals(161.0, speedResponse.getSpeedPerGearMap().get("Third"), 0.5);
        assertEquals(215.5, speedResponse.getSpeedPerGearMap().get("Fourth"), 0.5);
        assertEquals(267.3, speedResponse.getSpeedPerGearMap().get("Fifth"), 0.5);
        assertNotNull(speedResponse.getSpeedPerGearMap().get("Sixth"));
    }

}