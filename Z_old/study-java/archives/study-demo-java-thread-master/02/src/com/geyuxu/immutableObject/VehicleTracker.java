package com.geyuxu.immutableObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class VehicleTracker {

    private Map<String,Location> locMap = new ConcurrentHashMap<>();

    public void updateLocation(String vehicleId,Location newLocation){
        locMap.put(vehicleId,newLocation);
    }
}
