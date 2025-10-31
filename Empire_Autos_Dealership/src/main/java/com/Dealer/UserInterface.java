package com.Dealer;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner read = new Scanner(System.in);

    public void init() {
        this.dealership = new Dealership("Empire Dealership", "123 Streety St", "510-555-5555");
    }

    public void display() {
        init();
        boolean running = false;
        System.out.println("Press enter to Start the program");
        System.out.println("Press any other key to exit");
        String start = read.nextLine();

        if (start.isEmpty()) {
            System.out.println("Starting the program...");

            running = true;
        } else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }

        // Start menu implementation
        while (running) {
            System.out.println("Welcome to THE  Empire Dealership Management System");
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make / model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by vehicle type");
            System.out.println("7) View all vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("0) Exit");
            System.out.println("Please select an option: ");
            System.out.print("> ");

            String choiceStr = read.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
                if (choice < 0 || choice > 9) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

              switch (choice) {
                  case 1:
                      processGetByPriceRequest();
                      break;

                  case 2:
                      processGetByMakeModelRequest();
                      break;
                  case 3:
                      processGetByYearRequest();
                      break;
                  case 4:
                      processGetByColorRequest();
                      break;
                  case 5:
                      processGetByMileageRequest();
                      break;
//                case 6:
//                    processGetByVehicleTypeRequest();
//                    break;
//                case 7:
//                    processGetAllVehiclesRequest();
//                    break;
//                case 8:
//                    processAddVehicleRequest();
//                    break;
//                case 9:
//                    processRemoveVehicleRequest();
//                    break;
//                case 0:
//                    System.out.println("Exiting the program...");
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
              }
        }
    }

    private void processGetByMileageRequest() {
        System.out.println("Enter min Mileage: ");
        while (!read.hasNextInt()){
            System.out.println("Invalid input please enter the minimum Mileage of the car");
            System.out.println("Enter min Mileage: ");
            read.next();
        }

        int min = read.nextInt();
        read.nextLine();

        System.out.println("Enter max Mileage: ");
        while (!read.hasNextInt()){
            System.out.println("Invalid input please enter the maximum Mileage of the car");
            System.out.println("Enter max Mileage: ");
            read.next();
        }

        int max = read.nextInt();
        read.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMileage(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("Enter Color: ");
        while (!read.hasNextLine()){
            System.out.println("Invalid input please enter the Color of the car");
            System.out.println("Enter Color: ");
            read.nextLine().toLowerCase();
        }
        String color = read.nextLine().toLowerCase();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("Enter min Year: ");
        while (!read.hasNextInt()){
            System.out.println("Invalid input please enter the minimum Year of the car");
            System.out.println("Enter min Year: ");
            read.next();
        }

        int min = read.nextInt();
        read.nextLine();

        System.out.println("Enter max Year: ");
        while (!read.hasNextInt()){
            System.out.println("Invalid input please enter the maximum Year of the car");
            System.out.println("Enter max Year: ");
            read.next();
        }

        int max = read.nextInt();
        read.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter Make: ");
        while (!read.hasNextLine()){
            System.out.println("Invalid input please enter the make of the car");
            System.out.println("Enter Make: ");
            read.nextLine().toLowerCase();
        }
        String make = read.nextLine().toLowerCase();

        System.out.println("Enter Model: ");
        while (!read.hasNextLine()){
            System.out.println("Invalid input please enter the make of the car");
            System.out.println("Enter Model: ");
            read.nextLine();
        }
        String model = read.nextLine().toLowerCase();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        while (!read.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter minimum price: ");
            read.next();
        }
        double minPrice = read.nextDouble();
        read.nextLine();

        System.out.print("Enter maximum price: ");
        while (!read.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter maximum price: ");
            read.next();
        }
        double maxPrice = read.nextDouble();
        read.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-10s %-6d %-10s %-10s %-15s %-10s %-10d %-10.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }
}
