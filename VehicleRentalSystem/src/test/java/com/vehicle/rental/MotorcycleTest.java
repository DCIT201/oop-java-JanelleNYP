package com.vehicle.rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("Y001", "Bimota Tesi H2", 2000.0, true, true);
    }

    @Test
    void testCalculateRentalCost() {
        assertEquals(6000.0, motorcycle.calculateRentalCost(3), "Rental cost for 3 days should be 6000.0");
    }

    @Test
    void testIsAvailableForRental() {
        assertTrue(motorcycle.isAvailableForRental(), "Motorcycle should be available for rental");
        motorcycle.setAvailable(false);
        assertFalse(motorcycle.isAvailableForRental(),
                "Motorcycle should not be available for rental when set to unavailable");
    }

    @Test
    void testRentVehicle() {
        Customer customer = new Customer("Janelle Poku", "jnyp@gmail.com");
        motorcycle.rent(customer, 2);
        // In a real scenario, you'd check if the customer's rental list was updated
    }

    @Test
    void testReturnVehicle() {
        motorcycle.returnVehicle();
        // Check if the returned vehicle logic is correct (e.g., updating availability)
    }

    @Test
    void testToString() {
        String expected = "Motorcycle{hasSidecar=true, vehicleId='Y001', model='Bimota Tesi H2', baseRentalRate=2000.0}";
        assertEquals(expected, motorcycle.toString());
    }
}