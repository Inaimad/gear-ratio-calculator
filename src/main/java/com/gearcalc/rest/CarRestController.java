package com.gearcalc.rest;

import com.gearcalc.entities.Car;
import com.gearcalc.dto.SpeedResponse;
import com.gearcalc.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@Slf4j
public class CarRestController {


    private CarService carService;


    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/calculateSpeed/carId", method = RequestMethod.GET, params = "carId")
    public @ResponseBody SpeedResponse getVmaxPerCarId(String carId) {

        log.info("CarRestController || getVmaxPerGear || - Passed car id was: {}", carId);
        int parsedId = Integer.parseInt(carId);

        return carService.getVmaxPerCarId(parsedId);
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public @ResponseBody List<Car> getAllCars() {
        log.info("CarRestController || getAllCars || - method invoked");
        return carService.getAllCars();
    }

    @RequestMapping(value = "/platform/getAll", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCarPlatforms() {
        log.info("CarRestController || getAllPlatforms || - method invoked");
        return carService.getAllPlatforms();
    }

    @RequestMapping(value = "/type/getAll", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCarTypes() {
        log.info("CarRestController || getAllCarTypes || - method invoked");
        return carService.getAllCarTypes();
    }

    @RequestMapping(value = "/getByPlatform", method = RequestMethod.GET, params = "platform")
    public @ResponseBody List<Car> getCarsByPlatform(String platform) {
        log.info("CarRestController || getCarsByPlatform || - Passed platform was: {}", platform);
        return carService.getAllByPlatform(platform);
    }

}
