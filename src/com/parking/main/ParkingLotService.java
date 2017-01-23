package com.parking.main;

import java.util.Scanner;

import com.parking.objs.ParkingLotImpl;
import com.parking.objs.ParkingTicket;
import com.parking.objs.Vehicle;

public class ParkingLotService {

    private static ParkingLotImpl parkingLot;

    public static void init(Scanner sc) {
        while (true) {
            String command = sc.nextLine();
            System.out.println(processCommand(command));
        }
    }

    private static String processCommand(String command) {
        String[] tokens = command.trim().split(" ");
        
        
        if (parkingLot == null && !tokens[0].equals("create_parking_lot")) {
            return "Please Create a parking lot to proceed (ex: 'create_parking_lot 6')";
        }
        
        switch (tokens[0]) {
        
            case "create_parking_lot":
                return createParkingLot(tokens[1]);
            
            case "park":
                return parkVehicle(tokens);
            
            case "leave":
                return parkingLot.unPark(new ParkingTicket(Integer.parseInt(tokens[1])));
            
            case "status":
                return parkingLot.displayStatus();
            
            case "registration_numbers_for_cars_with_colour":
                return parkingLot.getCarRegistrationNumsWithColor(tokens[1]);
            
            case "slot_number_for_registration_number":
                return parkingLot.getSlotNumberForRegistrationNumber(tokens[1]);
            
            case "slot_numbers_for_cars_with_colour":
                return parkingLot.getCarParkingSlotsWithColor(tokens[1]);
            
            default:

        }
        return "invalid command";
    }

    private static String createParkingLot(String capacity) {
        if (!isANumber(capacity)) {
            return "Please enter a number value for capacity";
        }
        if (parkingLot != null) {
            return "Parking lot is already initialized";
        }
        parkingLot = new ParkingLotImpl(Integer.parseInt(capacity));
        return "Created a parking lot with " + capacity + " slots";
    }

    private static boolean isANumber(String capacity) {
        return capacity.matches("[-+]?\\d*\\.?\\d+");
    }

    private static String parkVehicle(String[] tokens) {
        Vehicle v = new Vehicle(tokens[1], tokens[2]);
        ParkingTicket ticket = parkingLot.park(v);
        if (ticket == null)
            return "Sorry, parking lot is full";
        else
            return "Allocated slot number: " + ticket.getParkingLocation();
    }

}
