package com.gearcalc.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VmaxOnGearParamsTest {

    private VmaxOnGearParams params;

    @Before
    public void init() {
        params = new VmaxOnGearParams(6500, 1.0, 2.93, 2001.2);
    }

    @Test
    public void getVmaxOnGear() {
        assertEquals(266.3, params.getVmaxOnGear(), 0.5);
    }
}