package com.gearcalc.entities;

import com.gearcalc.common.CarBuilderFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WheelTest {

    private Wheel wheel;

    @Before
    public void init() {
        wheel = CarBuilderFactory.buildWheel();
    }

    @Test
    public void getWheelCircumference() {
        assertEquals(2008.4, wheel.getWheelCircumference(), 0.1);
    }
}