package com.gearcalc.service;

import com.gearcalc.domain.VmaxOnGearParams;
import com.gearcalc.entities.Car;
import com.gearcalc.domain.Gear;
import com.gearcalc.entities.GearBox;
import com.gearcalc.dto.SpeedResponse;
import com.gearcalc.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public SpeedResponse getVmaxPerGear(Car car) {
        SpeedResponse speedResponse = new SpeedResponse();
        double wheelCircumference = car.getWheel().getWheelCircumference();

        for (Gear gear : setGears(car.getGearBox())) {
            String tempGearNumber = gear.getGearNumber();
            double tempGearRatio = gear.getRatio();
            VmaxOnGearParams params =
                    new VmaxOnGearParams(car.getRedLine(), tempGearRatio, car.getFinalDriveRatio(), wheelCircumference);

            speedResponse.getSpeedPerGearMap().put(tempGearNumber,
                    params.getVmaxOnGear());
        }
        return speedResponse;
    }

    public SpeedResponse getVmaxPerCarId(int carId) {
        Car car = getCarById(carId);
        return getVmaxPerGear(car);
    }

    private List<Gear> setGears(GearBox gearBox) {
        List<Gear> formattedGears = new ArrayList<>();
        formattedGears.add(new Gear("First", gearBox.getFirst()));
        formattedGears.add(new Gear("Second", gearBox.getSecond()));
        formattedGears.add(new Gear("Third", gearBox.getThird()));
        formattedGears.add(new Gear("Fourth", gearBox.getFourth()));
        formattedGears.add(new Gear("Fifth", gearBox.getFifth()));
        formattedGears.add(new Gear("Sixth", gearBox.getSixth()));

        return formattedGears;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.getOne(id);
    }

    public List<Car> getAllByPlatform(String passedPlatform) {
        return carRepository.findAllByPlatform(passedPlatform);
    }

    public List<String> getAllPlatforms() {
        return carRepository.findAllPlatforms();
    }

    public List<String> getAllCarTypes() {
        return carRepository.findAllCarTypes();
    }

}
