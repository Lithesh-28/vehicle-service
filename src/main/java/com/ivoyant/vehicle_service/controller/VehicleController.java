package com.ivoyant.vehicle_service.controller;


import com.ivoyant.vehicle_service.entity.Vehicle;
import com.ivoyant.vehicle_service.service.VehicleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@Slf4j
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        log.info("Fetching all vehicles");
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        log.info("Found {} vehicles", vehicles.size());
        return vehicles;
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {
        log.info("Fetching vehicle with id "+ id);
        Vehicle vehicle = vehicleService.getVehicleById(id);
        log.info("Found vehicle " + vehicle.toString());
        return vehicle;
    }

    @PostMapping
    public Vehicle addVehicle(@Valid @RequestBody Vehicle vehicle) {
        log.info("Adding vehicle");
        Vehicle vehicle1 = vehicleService.addVehicle(vehicle);
        log.info("Vehicle added Successfully " + vehicle1.toString());
        return vehicle1;
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Integer id, @Valid @RequestBody Vehicle vehicle) {
        log.info("Vehicle Updating with id .."+ id);
        Vehicle vehicle1 = vehicleService.updateVehicle(id, vehicle);
        log.info("Vehicle Updated Successfully " + vehicle1.toString());
        return vehicle1;
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        log.info("Deleting vehicle with id " + id);
        vehicleService.deleteVehicle(id);
        log.info("Vehicle deleted Successfully");
        return "Vehicle deleted successfully";
    }
}

