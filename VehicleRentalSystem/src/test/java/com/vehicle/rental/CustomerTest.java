package com.vehicle.rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Janelle Poku", "jnyp@gmail.com");
    }

    @Test
    void testGetName() {
        assertEquals("Janelle Poku", customer.getName(), "Customer name should be 'Janelle Poku'");
    }

    @Test
    void testGetEmail() {
        assertEquals("jnyp@gmail.com", customer.getEmail(), "Customer email should be 'jnyp@gmail.com'");
    }

    @Test
    void testRentVehicle() {
        Vehicle car = new Car("Z001", "Mercedes-Maybach Exelero", 10000.0, true, "Petrol");
        customer.rentVehicle(car);
        assertTrue(customer.getRentedVehicles().contains(car), "Customer should have rented the vehicle");
    }

    @Test
    void testGetRentedVehicles() {
        assertTrue(customer.getRentedVehicles().isEmpty(), "Customer should have no current rentals initially");
        Vehicle car = new Car("Z001", "Mercedes-Maybach Exelero", 10000.0, true, "Petrol");
        customer.rentVehicle(car);
        assertEquals(1, customer.getRentedVehicles().size(), "Customer should have one rented vehicle");
    }

    @Test
    void testToString() {
        String expected = "Customer{name='Janelle Poku', email='jnyp@gmail.com', rentedVehicles=0}";
        assertEquals(expected, customer.toString(), "Customer toString should match the expected format");
    }
}