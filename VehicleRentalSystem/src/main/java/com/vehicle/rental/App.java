package com.vehicle.rental;

public class App {
    public static void main(String[] args) {
        try {
            // Initialize Customers
            Customer customer1 = new Customer("Janelle Poku", "jnyp@gmail.com");
            Customer customer2 = new Customer("Karen Mensah", "karenmsh@gmail.com");

            // Initialize Vehicles
            Vehicle car = new Car("Z001", "Mercedes-Maybach Exelero", 10000, true, "Petrol");
            Vehicle motorcycle = new Motorcycle("Y001", "Bimota Tesi H2", 2000, true, true);
            Vehicle truck = new Truck("X001", "Chevrolet Colorado", 8000, true, 7500);

            // Initialize Agency
            RentalAgency agency = new RentalAgency();
            agency.addVehicle(car);
            agency.addVehicle(motorcycle);
            agency.addVehicle(truck);

            // Rent Vehicles
            agency.rentVehicle(car, customer1, 3);
            agency.rentVehicle(motorcycle, customer2, 2);

            // Update Location and Check for Boundary Violations
            car.updateLocation(91.0, 180.0); // This should trigger BoundaryViolationException
        } catch (BoundaryViolationException e) {
            System.out.println(e.getMessage());
        }
    }
}
