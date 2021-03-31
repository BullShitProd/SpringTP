package com.example.demoWebService.Service;

import com.example.demoWebService.Entity.Car;
import com.example.demoWebService.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.carRepository.save(new Car("11AA22", "Ferrari", 1000, 2));
        this.carRepository.save(new Car("33BB44", "Porche", 100, 4));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars(){

        List<Car> cars = new ArrayList<Car>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @PostMapping("/cars")
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
       Car car = carRepository.findByPlateNumber(plateNumber);
       return car;

        //for(Car car : cars) {
        //   if(car.getPlateNumber().equals(plateNumber)) {
        //         return car;
        //   }
        // }

        // return null;
   }


}
