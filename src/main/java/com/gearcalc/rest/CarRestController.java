package com.gearcalc.rest;

import com.gearcalc.entities.Car;
import com.gearcalc.entities.SpeedResponse;
import com.gearcalc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarRestController {


    private CarService carService;


    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/calculateSpeed/carId", method = RequestMethod.GET, params = "carId")
    public @ResponseBody SpeedResponse getVmaxPerGear(String carId) {

        int intId = Integer.parseInt(carId);
        return carService.getVmaxPerCarId(intId);
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public @ResponseBody
    List<Car> getAllCars() {

        return carService.getAllCars();
    }

    @RequestMapping(value = "/platform/getAll", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCarPlatforms() {

        return carService.getAllPlatforms();
    }

    @RequestMapping(value = "/type/getAll", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCarTypes() {

        return carService.getAllCarTypes();
    }

    @RequestMapping(value = "/getByPlatform", method = RequestMethod.GET, params = "platform")
    public @ResponseBody List<Car> getCarsByPlatform(String platform) {

        return carService.getAllByPlatform(platform);
    }

}
