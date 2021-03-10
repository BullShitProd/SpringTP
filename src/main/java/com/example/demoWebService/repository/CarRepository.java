package com.example.demoWebService.repository;

import com.example.demoWebService.Entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    public Car findByPlateNumber(String plateNumber);

}
