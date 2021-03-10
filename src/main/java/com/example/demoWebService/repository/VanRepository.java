package com.example.demoWebService.repository;

import com.example.demoWebService.Entity.Car;
import com.example.demoWebService.Entity.Van;
import org.springframework.data.repository.CrudRepository;

public interface VanRepository extends CrudRepository<Van, Long> {

    public Van findByPlateNumber(String plateNumber);

}
