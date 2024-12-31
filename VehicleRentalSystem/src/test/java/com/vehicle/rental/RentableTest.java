package com.vehicle.rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentableTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Z001", "Mercedes-Maybach Exelero", 10000.0, true, "Petrol");
    }

    @Test
    void testRent() {
        Customer customer = new Customer("Janelle Poku", "jnyp@gmail.com");
        System.out.println("Before rent: " + car.isAvailableForRental());
        car.rent(customer, 3);
        System.out.println("After rent: " + car.isAvailableForRental());
        // In a real scenario, you'd check if the customer's rental list was updated
        assertFalse(car.isAvailableForRental(), "Car should not be available for rental after being rented");
    }

    @Test
    void testReturnVehicle() {
        car.setAvailable(false); // Ensure the car is rented before returning
        System.out.println("Before return: " + car.isAvailableForRental());
        car.returnVehicle();
        System.out.println("After return: " + car.isAvailableForRental());
        // Check if the returned vehicle logic is correct (e.g., updating availability)
        assertTrue(car.isAvailableForRental(), "Car should be available for rental after being returned");
    }
}