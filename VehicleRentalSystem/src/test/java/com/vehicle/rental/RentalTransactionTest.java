package com.vehicle.rental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class RentalTransactionTest {

    private Customer customer;
    private Vehicle car;
    private RentalTransaction rentalTransaction;

    @BeforeEach
    void setUp() {
        customer = new Customer("Janelle Poku", "jnyp@gmail.com");
        car = new Car("Z001", "Mercedes-Maybach Exelero", 10000.0, true, "Petrol");
        rentalTransaction = new RentalTransaction(customer, car, 3);
    }

    @Test
    void testCalculateTotalCost() {
        assertEquals(30000.0, rentalTransaction.calculateTotalCost(), "Total cost for 3 days should be 30000.0");
    }

    @Test
    void testGetRentalDate() {
        Date rentalDate = rentalTransaction.getRentalDate();
        assertNotNull(rentalDate, "Rental date should not be null");
        assertTrue(rentalDate.before(new Date()) || rentalDate.equals(new Date()),
                "Rental date should be before or equal to the current date");
    }

    @Test
    void testToString() {
        String expected = "RentalTransaction{customer=Customer{name='Janelle Poku', email='jnyp@gmail.com', rentedVehicles=0}, vehicle=Car{fuelType='Petrol', vehicleId='Z001', model='Mercedes-Maybach Exelero', baseRentalRate=10000.0}, days=3, rentalDate="
                + rentalTransaction.getRentalDate() + "}";
        assertEquals(expected, rentalTransaction.toString(), "toString should match the expected format");
    }
}