package com.parking.objs;

import java.util.SortedSet;

public  abstract class ParkingLotMaster {

    protected int capacity;
    protected SortedSet<ParkingSpot> emptySpots;
    protected SortedSet<ParkingSpot> parkedSpots;

    public ParkingLotMaster() {
        super();
    }

    private boolean isParkingLotEmpty() {
        return parkedSpots.size() == 0 ? true : false;
    }

    private boolean isParkingLotFull() {
        return emptySpots.size() == 0 ? true : false;
    }

    public ParkingTicket park(Vehicle v) {
        if (isParkingLotFull()) {
            return null;
        }
        ParkingSpot nearestSpot = emptySpots.first();
        emptySpots.remove(nearestSpot);
        nearestSpot.setParkedVehicle(v);
        parkedSpots.add(nearestSpot);
        return new ParkingTicket(nearestSpot);
    }

    public String unPark(ParkingTicket t) {
        if (isParkingLotEmpty()) {
            return "Sorry, no vehicles parked";
        }
    
        ParkingSpot spotToUnpark;
        for (ParkingSpot parkingSpot : parkedSpots) {
            if (parkingSpot.getDistance() == t.getParkingLocation()) {
                spotToUnpark = parkingSpot;
                parkedSpots.remove(spotToUnpark);
                emptySpots.add(spotToUnpark);
                spotToUnpark.setParkedVehicle(null);
                return "Slot number " + spotToUnpark.getDistance() + " is free";
            }
        }
        return "Not found";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String displayStatus() {
        if (parkedSpots.size() == 0)
            return "No vehicles are parked";
        StringBuilder sb = new StringBuilder();
        sb.append("Slot No\t\tRegistration No\t\tColor");
        for (ParkingSpot spot : parkedSpots) {
            sb.append("\n");
            sb.append(spot.getDistance() + "\t\t" + spot.getParkedVehicle().getNumberPlate() + "\t\t"
                    + spot.getParkedVehicle().getColor());
            
        }
        return sb.toString();
    }

}