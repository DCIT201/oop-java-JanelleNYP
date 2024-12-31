package com.vehicle.rental;

public class TestVehicle extends Vehicle implements Rentable {
    public TestVehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
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
            System.out.println("You have successfully rented this vehicle. Enjoy your ride " + customer.getName() + "!");
        } else {
            System.out.println("Sorry, this vehicle is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("You have returned the vehicle. Thank you.");
    }
}