package com.gearcalc.service;

import com.gearcalc.entities.Wheel;
import com.gearcalc.repositories.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelService {


    private WheelRepository wheelRepository;


    @Autowired
    public WheelService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }


    private double getTotalWheelDiameter(Wheel wheel) {
        double totalProfile = wheel.getWidth() * (wheel.getProfile() / 100);
        double diamaterInMm = wheel.getDiameterInInches() * 2.56;
        return (totalProfile * 2) + (diamaterInMm * 10);
    }

    public double getWheelCircumference(Wheel wheel) {
        return 2 * Math.PI * (getTotalWheelDiameter(wheel) / 2);
    }

    public List<Wheel> getAllWheels() {
        return wheelRepository.findAll();
    }

    public Wheel getWheelById(int wheelId) {
        return wheelRepository.getOne(wheelId);
    }

}
