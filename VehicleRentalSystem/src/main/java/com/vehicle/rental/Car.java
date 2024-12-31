package com.vehicle.rental;

public class Car extends Vehicle implements Rentable {
    private String fuelType;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, String fuelType) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.fuelType = fuelType;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate();
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            System.out.println("You have successfully rented this car. Enjoy your ride " + customer.getName() + "!" );
        } else {
            System.out.println("Sorry, this car is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("You have returned the car. Thank you.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelType='" + fuelType + '\'' +
                ", vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                '}';
    }
}