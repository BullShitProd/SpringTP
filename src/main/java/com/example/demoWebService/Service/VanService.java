package com.example.demoWebService.Service;

import com.example.demoWebService.Entity.Van;
import com.example.demoWebService.repository.VanRepository;
import org.springframework.web.bind.annotation.RestController;


import com.example.demoWebService.Entity.Car;
import com.example.demoWebService.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VanService {

    VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
        this.vanRepository.save(new Van("1111", "Peugeot", 50, 10));
        this.vanRepository.save(new Van("2222", "Opel", 50, 10));
    }

    @RequestMapping(value = "/vans", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Van> listOfVans(){

        List<Van> vans = new ArrayList<Van>();
        vanRepository.findAll().forEach(vans::add);
        return vans;
    }

    @PostMapping("/van")
    public String addCar(@RequestBody Car car) throws Exception{
        carRepository.save(car);

        return "Add car success";
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
        List<Car> cars = new ArrayList<Car>();

        carRepository.findAll().forEach(cars::add);

        for(Car car : cars) {
            if(car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        return null;
    }


}
