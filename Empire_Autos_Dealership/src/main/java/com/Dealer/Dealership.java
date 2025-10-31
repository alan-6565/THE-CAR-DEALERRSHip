package com.Dealer;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    //Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = DealershipFileManager.getDealership();
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    //Methods
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getMake().toLowerCase().equals(make) && vehicle.getModel().toLowerCase().equals(model)){
                filteredVehicles.add(vehicle);
            }
        }
       return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().toLowerCase().equals(color)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }
}
