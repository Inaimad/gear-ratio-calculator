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

    public List<Wheel> getAllWheels() {
        return wheelRepository.findAll();
    }

    public Wheel getWheelById(int wheelId) {
        return wheelRepository.getOne(wheelId);
    }

}
