package test.com.parking.main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.parking.objs.ParkingLotImpl;
import com.parking.objs.ParkingLotMaster;
import com.parking.objs.Vehicle;

@RunWith(JUnit4.class)
public class ParkingLotTest {

    @Test
    public void testCreateParkingLot() {
        ParkingLotImpl parkingLot1 = new ParkingLotImpl(5);
        Vehicle vehicle1 = new Vehicle("SomeCarNumber1", "SomeColor1");
        assertEquals(1, parkingLot1.park(vehicle1).getParkingLocation());
        assertEquals("1", parkingLot1.getSlotNumberForRegistrationNumber("SomeCarNumber1"));
    }

    @Test
    public void testParkVehicle() {
        ParkingLotImpl parkingLot = new ParkingLotImpl(5);
        Vehicle v = new Vehicle("SomeCarNumber2", "SomeColor2");
        parkingLot.park(v);
        assertEquals("1", parkingLot.getSlotNumberForRegistrationNumber("SomeCarNumber2"));
    }
    @Test
    public void testParkingFull() {
        ParkingLotMaster parkingLot = new ParkingLotImpl(1);
        Vehicle v = new Vehicle("SomeCarNumber2", "SomeColor2");
        parkingLot.park(v);
        Vehicle v2 = new Vehicle("SomeCarNumber2", "SomeColor2");
        assertEquals(null, parkingLot.park(v2));
    }
    
    @Test
    public void testLeaveParkedVehicle() {
        ParkingLotImpl parkingLot = new ParkingLotImpl(5);
        Vehicle v = new Vehicle("SomeCarNumber3", "SomeColor3");
        parkingLot.park(v);
        assertEquals("1", parkingLot.getSlotNumberForRegistrationNumber("SomeCarNumber3"));
    }
    
    @Test
    public void testStatus() {
        ParkingLotMaster parkingLot = new ParkingLotImpl(5);
        Vehicle v = new Vehicle("SomeCarNumber4", "SomeColor4");
        parkingLot.park(v);
        Vehicle v2 = new Vehicle("SomeCarNumber41", "SomeColor4");
        parkingLot.park(v2);
        String statusString = parkingLot.displayStatus();
        assertEquals(3, statusString.split("\n").length);
    }
    @Test
    public void testGetCarRegistrationNumsWithColor() {
        ParkingLotImpl parkingLot = new ParkingLotImpl(5);
        Vehicle v = new Vehicle("SomeCarNumber5", "SomeColor5");
        parkingLot.park(v);
        assertEquals("SomeCarNumber5", parkingLot.getCarRegistrationNumsWithColor("SomeColor5"));
    }
    @Test
    public void testGetSlotNumberForRegistrationNumber() {
        ParkingLotImpl parkingLot = new ParkingLotImpl(5);
        Vehicle v = new Vehicle("SomeCarNumber6", "SomeColor6");
        parkingLot.park(v);
        assertEquals("1", parkingLot.getSlotNumberForRegistrationNumber("SomeCarNumber6"));
    }
    @Test
    public void testGetCarParkingSlotsWithColor() {
        ParkingLotImpl parkingLot = new ParkingLotImpl(5);
        Vehicle v7 = new Vehicle("SomeCarNumber7", "White");
        parkingLot.park(v7);
        Vehicle v8 = new Vehicle("SomeCarNumber8", "White");
        parkingLot.park(v8);
        assertEquals("1, 2", parkingLot.getCarParkingSlotsWithColor("White"));
    }

}
