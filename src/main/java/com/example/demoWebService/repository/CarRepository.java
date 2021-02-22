package com.example.demoWebService.repository;

import com.example.demoWebService.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
