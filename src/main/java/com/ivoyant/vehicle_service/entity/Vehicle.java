package com.ivoyant.vehicle_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Make is required")
    @Size(max = 50, message = "Make must be less than 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Make can only contain alphabets and spaces")
    private String make;

    @NotBlank(message = "Model is required")
    @Size(max = 50, message = "Model must be less than 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Model can only contain alphabets and spaces")
    private String model;

    @Min(value = 1900, message = "Year must be no earlier than 1900 and cannot be null")
    @Max(value = 2100, message = "Year must be reasonable")
    private int year;

    @Positive(message = "Price must be greater than zero and it should also be not null")
    private double price;

    @NotNull(message = "Available should be present")
    private boolean available;

}
