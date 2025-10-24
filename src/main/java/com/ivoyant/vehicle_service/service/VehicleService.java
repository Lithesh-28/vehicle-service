package com.ivoyant.vehicle_service.service;


import com.ivoyant.vehicle_service.entity.Vehicle;
import com.ivoyant.vehicle_service.exception.InvalidIdException;
import com.ivoyant.vehicle_service.exception.VehicleNotFoundException;
import com.ivoyant.vehicle_service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicle(){
        return repository.findAll();
    }

    public Vehicle getVehicleById(Integer id){
        return repository.findById(id)
                .orElseThrow(()->new VehicleNotFoundException("Vehicle not found with id" + id));
    }

    public Vehicle addVehicle(Vehicle vehicle){
        if (vehicle.getId() != 0) {
            throw new InvalidIdException("ID should not be provided when creating a new vehicle. It will be auto-generated.");
        }
        return repository.save(vehicle);
    }

    public Vehicle updateVehicle(Integer id, Vehicle vehicleDetails){
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(()->new VehicleNotFoundException("Vehicle not found with id" + id));

        vehicle.setMake(vehicleDetails.getMake());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setAvailable(vehicleDetails.isAvailable());

        return repository.save(vehicle);
    }

    public void deleteVehicle(Integer id) {
        if(!repository.existsById(id)) {
            throw new VehicleNotFoundException("Vehicle not found with id " + id);
        }
        repository.deleteById(id);
    }
}
