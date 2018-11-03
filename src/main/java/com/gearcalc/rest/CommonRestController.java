package com.gearcalc.rest;

import com.gearcalc.entities.Car;
import com.gearcalc.entities.GearBox;
import com.gearcalc.entities.SpeedResponse;
import com.gearcalc.entities.Wheel;
import com.gearcalc.service.CarService;
import com.gearcalc.service.GearBoxService;
import com.gearcalc.service.WheelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CommonRestController {


    private CarService carService;
    private WheelService wheelService;
    private GearBoxService gearBoxService;


    @Autowired
    public CommonRestController(CarService carService, WheelService wheelService, GearBoxService gearBoxService) {
        this.carService = carService;
        this.wheelService = wheelService;
        this.gearBoxService = gearBoxService;
    }


    @GetMapping("/test")
    public String testApplication() {
        return "App running OK!";
    }

    @RequestMapping(value = "/wheel/circumference", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Double getWheelCircumference(@RequestBody Wheel wheel) {

        log.info("Passed wheel object was: {}", wheel.toString());
        Double result = wheelService.getWheelCircumference(wheel);
        log.info("Wheel circumference was: {}", result.toString());

        return result;
    }

    @RequestMapping(value = "/calculateSpeed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody SpeedResponse getVmaxPerGear(@RequestBody Car car) {
        log.info("Passed Car object was: {}", car.toString());

        return carService.getVmaxPerGear(car);
    }

    @RequestMapping(value = "/wheel/getAll", method = RequestMethod.GET)
    public @ResponseBody List<Wheel> getAllWheels() {

        return wheelService.getAllWheels();
    }

    @RequestMapping(value = "/gearbox/getAll", method = RequestMethod.GET)
    public @ResponseBody List<GearBox> getAllGearBoxes() {

        return gearBoxService.getAllGearboxes();
    }

}
