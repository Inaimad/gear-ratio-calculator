package com.gearcalc.entities;


import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class SpeedResponse {

    private Map<String, Double> speedPerGearMap;

    public SpeedResponse() {
        speedPerGearMap = new HashMap<>();
    }

    public Map<String, Double> getSpeedPerGearMap() {
        return speedPerGearMap;
    }

    public void setSpeedPerGearMap(Map<String, Double> speedPerGearMap) {
        this.speedPerGearMap = speedPerGearMap;
    }
}
