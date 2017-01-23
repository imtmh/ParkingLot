package com.parking.objs;

import java.util.TreeSet;

public class ParkingLotImpl extends ParkingLotMaster {
    public ParkingLotImpl(int capacity) {
        this.capacity = capacity;
        emptySpots = new TreeSet<ParkingSpot>();
        parkedSpots = new TreeSet<ParkingSpot>();
        for (int i = 1; i <= capacity; i++) {
            emptySpots.add(new ParkingSpot(i));
        }
    }

    public String getSlotNumberForRegistrationNumber(String reg) {
        for (ParkingSpot spot : parkedSpots) {
            if (spot.getParkedVehicle().getNumberPlate().equals(reg)) {
                return "" + spot.getDistance();
            }
        }
        return "Not Found";
    }

    public String getCarRegistrationNumsWithColor(String color) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (ParkingSpot spot : parkedSpots) {
            if (spot.getParkedVehicle().getColor().toLowerCase().equals(color.toLowerCase())) {
                if (count++ != 0)
                    sb.append(", ");
                sb.append(spot.getParkedVehicle().getNumberPlate());
            }
        }
        return sb.toString();
    }

    public String getCarParkingSlotsWithColor(String color) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (ParkingSpot spot : parkedSpots) {
            if (spot.getParkedVehicle().getColor().toLowerCase().equals(color.toLowerCase())) {
                if (count++ != 0)
                    sb.append(", ");
                sb.append(spot.getDistance());
            }
        }
        return sb.toString();
    }
}
