package com.gearcalc.service;

import com.gearcalc.entities.GearBox;
import com.gearcalc.repositories.GearboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearBoxService {


    private GearboxRepository gearboxRepository;


    @Autowired
    public GearBoxService(GearboxRepository gearboxRepository) {
        this.gearboxRepository = gearboxRepository;
    }


    public List<GearBox> getAllGearboxes() {
        return gearboxRepository.findAll();
    }

    public GearBox getGearboxById(int id) {
        return gearboxRepository.getOne(id);
    }

}
