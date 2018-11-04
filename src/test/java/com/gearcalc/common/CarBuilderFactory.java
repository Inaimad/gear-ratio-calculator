package com.gearcalc.common;

import com.gearcalc.entities.Car;
import com.gearcalc.entities.GearBox;
import com.gearcalc.entities.Wheel;

public class CarBuilderFactory {

    private CarBuilderFactory() {}

    public static Car buildE46328ci() {
        Car e46 = new Car();
        e46.setCarType("COUPE");
        e46.setFinalDriveRatio(2.93);
        e46.setId(1);
        e46.setModel("328ci");
        e46.setPlatform("E46");
        e46.setRedLine(6500);
        e46.setTransmissionType("MANUAL");
        e46.setWheel(buildWheel());
        e46.setGearBox(buildGearbox());

        return e46;
    }

    public static Wheel buildWheel() {
        return new Wheel(255, 35, 18);
    }

    public static GearBox buildGearbox() {
        GearBox gearBox = new GearBox();
        gearBox.setId(1);
        gearBox.setFirst(4.21);
        gearBox.setSecond(2.49);
        gearBox.setThird(1.66);
        gearBox.setFourth(1.24);
        gearBox.setFifth(1.00);
        gearBox.setSixth(0);

        return gearBox;
    }
}
