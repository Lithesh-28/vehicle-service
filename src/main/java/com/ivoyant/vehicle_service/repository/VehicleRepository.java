package com.ivoyant.vehicle_service.repository;

import com.ivoyant.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}
