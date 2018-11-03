package com.gearcalc.gearratiocalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.gearcalc")
public class GearRatioCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GearRatioCalculatorApplication.class, args);
    }


}
