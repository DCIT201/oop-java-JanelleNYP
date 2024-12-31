# Vehicle Rental Management System Documentation

## Overview

The Vehicle Rental Management System is a comprehensive project designed to demonstrate the principles of Object-Oriented Programming (OOP), including abstraction, inheritance, encapsulation, polymorphism, and composition. This system is built as a Maven project and follows a well-structured package hierarchy for clarity and maintainability.

The system manages a fleet of vehicles for rental purposes, processes rental transactions, and enforces specific business rules. It also includes advanced features such as a loyalty program, a rating system, and custom exception handling.

---

## Core Features

### 1. Abstraction

The system uses the `Vehicle` abstract class as the base for all vehicle types. This class defines the following abstract methods:

- `calculateRentalCost(int days)`
- `isAvailableForRental()`

### 2. Inheritance

Concrete vehicle classes inherit from the `Vehicle` class:

- **Car**
- **Motorcycle**
- **Truck**

Each class implements unique rental characteristics, such as:

- Different base rental rates
- Specific rental rules
- Unique additional features

### 3. Encapsulation

All fields in the classes are private, with controlled access provided through public getter and setter methods. Input validation is enforced in setters to ensure data integrity.

### 4. Polymorphism

The system demonstrates polymorphism through:

- Method overriding: Each vehicle class overrides methods from the `Vehicle` class to implement specific behaviors.
- Method overloading: Methods with the same name but different parameter lists are used for flexible functionality.
- The `Rentable` interface, which defines:
- `rent(Customer customer, int days)`
- `returnVehicle()`

### 5. Composition

Supporting classes such as `Customer`, `RentalAgency`, and `RentalTransaction` are composed to add functionality:

- **Customer**: Manages rental history and tracks current rentals.
- **RentalAgency**: Manages the vehicle fleet, processes rentals, and generates reports.
- **RentalTransaction**: Tracks details of each rental, such as the vehicle rented, customer details, and rental duration.

---

## Advanced Features

### 1. Custom Exceptions

A custom exception, `BoundaryViolationException`, is implemented to handle scenarios where a user exceeds predefined rental boundaries. The exception provides detailed information about the user and the vehicle's location.

#### Example:

```java
public class BoundaryViolationException extends Exception {
public BoundaryViolationException(String message) {
super(message);
}
}
```

### 2. Loyalty Program

The loyalty program rewards customers based on their rental history. It is implemented using an interface to ensure flexibility and reusability.

### 3. Rating System

The rating system allows customers to rate vehicles and their rental experience. This feedback is used to improve service quality.

---

## Class Structure

### Abstract Class: Vehicle

```java
public abstract class Vehicle {
private String vehicleId;
private String model;
private double baseRentalRate;
private boolean isAvailable;

public Vehicle(String vehicleId, String model, double baseRentalRate) {
this.vehicleId = vehicleId;
this.model = model;
this.baseRentalRate = baseRentalRate;
this.isAvailable = true;
}

public abstract double calculateRentalCost(int days);
public abstract boolean isAvailableForRental();

// Getters and setters with validation
}
```

### Concrete Classes

#### Car

Implements `calculateRentalCost` and adds features specific to cars.

#### Motorcycle

Overrides methods for motorcycle-specific rules.

#### Truck

Handles unique rental costs and availability checks for trucks.

### Supporting Classes

#### Customer

Tracks rental history and implements eligibility checks.

#### RentalAgency

Manages the fleet and processes rentals.

#### RentalTransaction

Stores details of individual rentals.

---

## Testing

The project includes comprehensive unit tests for each class and feature using JUnit 5. Test cases cover:

- Encapsulation validation
- Inheritance and polymorphic behavior
- Abstraction implementations
- Custom exception scenarios

### Example Test Case

```java
@Test
public void testCarRentalCost() {
Car car = new Car("CAR123", "Toyota Corolla", 50.0);
double cost = car.calculateRentalCost(5);
assertEquals(250.0, cost, 0.01);
}
```

---

## Evaluation Criteria

- **OOP Principles Implementation**: 20%
- **Code Quality**: 5%
- **Testing Coverage**: 5%
- **Design Creativity**: 5%
- **Documentation**: 5%

---

## Submission

- The project is organized as a Maven project.
- The package structure is meaningful and intuitive.
- Comprehensive unit tests are included.
- The code is clean, well-documented, and adheres to Java naming conventions.

---

## Tools Used

- **JDK 11**
- **Maven**
- **JUnit 5**
- **IntelliJ IDEA**

---

## Conclusion

The Vehicle Rental Management System successfully demonstrates advanced OOP principles through a real-world application. With features like custom exceptions, a loyalty program, and a rating system, it provides a robust and scalable solution for managing vehicle rentals.

I had fun working on this project.
