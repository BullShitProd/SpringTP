package com.example.demoWebService.repository;

import com.example.demoWebService.Entity.Car;
import com.example.demoWebService.Entity.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {
}
