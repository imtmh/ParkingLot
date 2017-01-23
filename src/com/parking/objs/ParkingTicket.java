package com.parking.objs;

import java.util.Date;

public class ParkingTicket {
    private Vehicle parkedVehicle;
    private Date parkedAt;
    private Date vacatedAt;
    private int parkingLocation;

    public ParkingTicket(ParkingSpot nearestSpot) {
        this.setParkingLocation(nearestSpot.getDistance());
        this.parkedVehicle = nearestSpot.getParkedVehicle();
    }

    public ParkingTicket(int parseInt) {
        this.parkingLocation = parseInt;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public Date getParkedAt() {
        return parkedAt;
    }

    public void setParkedAt(Date parkedAt) {
        this.parkedAt = parkedAt;
    }

    public Date getVacatedAt() {
        return vacatedAt;
    }

    public void setVacatedAt(Date vacatedAt) {
        this.vacatedAt = vacatedAt;
    }

    @Override
    public String toString() {
        return "Allocated slot number: " + parkingLocation;
    }

    public int getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(int parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

}
