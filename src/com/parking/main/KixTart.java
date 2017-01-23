package com.parking.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class KixTart {

    public static void main(String[] args) {
        Scanner in = null;
        if (args != null && args.length > 0)
            try {
                in = new Scanner(new BufferedReader(new FileReader(args[0])));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else
            in = new Scanner(System.in);
        ParkingLotService.init(in);
    }
}
