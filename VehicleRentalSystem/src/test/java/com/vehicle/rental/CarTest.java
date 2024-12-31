package com.vehicle.rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Z001", "Mercedes-Maybach Exelero", 10000.0, true, "Petrol");
    }

    @Test
    void testCalculateRentalCost() {
        assertEquals(30000.0, car.calculateRentalCost(3), "Rental cost for 3 days should be 30000.0");
    }

    @Test
    void testIsAvailableForRental() {
        assertTrue(car.isAvailableForRental(), "Car should be available for rental");
        car.setAvailable(false);
        assertFalse(car.isAvailableForRental(), "Car should not be available for rental when set to unavailable");
    }

    @Test
    void testRentVehicle() {
        Customer customer = new Customer("Janelle Poku", "jnyp@gmail.com");
        car.rent(customer, 2);
        // In a real scenario, you'd check if the customer's rental list was updated
    }

    @Test
    void testReturnVehicle() {
        car.returnVehicle();
        // Check if the returned vehicle logic is correct (e.g., updating availability)
    }

    @Test
    void testToString() {
        String expected = "Car{fuelType='Petrol', vehicleId='Z001', model='Mercedes-Maybach Exelero', baseRentalRate=10000.0}";
        assertEquals(expected, car.toString());
    }
}