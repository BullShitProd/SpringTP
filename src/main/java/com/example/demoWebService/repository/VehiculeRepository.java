package com.example.demoWebService.repository;

import com.example.demoWebService.Entity.Vehicule;
import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
}
