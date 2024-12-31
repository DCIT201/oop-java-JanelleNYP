package com.vehicle.rental;

public class Motorcycle extends Vehicle implements Rentable {
    private boolean hasSidecar;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean hasSidecar) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.hasSidecar = hasSidecar;
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
            System.out.println("You have successfully rented this motorcycle. Enjoy your ride " + customer.getName() + "!");
        } else {
            System.out.println("Sorry, this motorcycle is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        System.out.println("You have returned the motorcycle. Thank you.");
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSidecar=" + hasSidecar +
                ", vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                '}';
    }
}
