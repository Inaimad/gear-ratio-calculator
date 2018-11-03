package com.gearcalc.service;

import com.gearcalc.GearRatioCalculatorApplication;
import com.gearcalc.entities.Car;
import com.gearcalc.entities.SpeedResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GearRatioCalculatorApplication.class)
public class CarServiceTest {

    @Autowired
    private CarService carService;


    @Test
    public void getVmaxPerGear() {
        Car car = carService.getCarById(1);
        SpeedResponse speedResponse = carService.getVmaxPerGear(car);
        System.out.println(speedResponse);
    }

    @Test
    public void getAllCars() {
        List<Car> cars = carService.getAllCars();
        System.out.println(cars);
        assertNotNull(cars);
    }

    @Test
    public void getCarById() {
        Car car = carService.getCarById(1);
        System.out.println(car);
        assertNotNull(car);
    }

    @Test
    public void getAllByPlatform() {
        List<Car> cars = carService.getAllByPlatform("E46");
        System.out.println(cars);
        assertNotNull(cars);
    }

    @Test
    public void getAllPlatforms() {
        List<String> platforms = carService.getAllPlatforms();
        System.out.println(platforms);
        assertNotNull(platforms);
    }

    @Test
    public void getAllCarTypes() {
        List<String> carTypes = carService.getAllCarTypes();
        assertNotNull(carTypes);
    }
}