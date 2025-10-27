package com.Dealer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    public static ArrayList<Vehicle> getDealership() {
        ArrayList<Vehicle> List = new ArrayList<Vehicle>();
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            boolean isHeader = true;
            while ((input = bufReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header
                    continue;
                }
                if (input.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                    //44901|2012|Honda|Civic|SUV|Gray|103221|6995.00
                    String[] info = input.split("\\|");
                    int vin = Integer.parseInt(info[0]);
                    int year = Integer.parseInt(info[1]);
                    String make = info[2];
                    String model = info[3];
                    String vehicleType = info[4];
                    String color = info[5];
                    int odometer = Integer.parseInt(info[6]);
                    double price = Double.parseDouble(info[7]);

                    Vehicle entry = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    List.add(entry);

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List;
    }

    public static ArrayList<Vehicle> saveDealership(){

        return null;
    }
}
