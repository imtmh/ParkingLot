package com.parking.objs;

import java.util.Date;

public class ParkingSpot implements Comparable<ParkingSpot> {

    private int distance;
    private Vehicle parkedVehicle;
    private Date parkedAt;
    private Date vacatedAt;

    public ParkingSpot(int distance) {
        this.distance = distance;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(ParkingSpot o) {
        if (o.distance == this.distance)
            return 0;
        return this.distance > o.distance ? 1 : -1;
    }
}