package com.example.demoWebService.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demoWebService.Entity.Car;
import com.example.demoWebService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class CarRentalService {

//    private List<Car> cars = new ArrayList<Car>();
//
//    CarRepository carRepository;
//
//    @Autowired
//    public CarRentalService(CarRepository carRepository) {
////        cars.add(new Car("11AA22", "Ferrari", 1000));
////        cars.add(new Car("33BB44", "Porshe", 2222));
//        this.carRepository = carRepository;
//    }
//
//    @RequestMapping(value = "/cars", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public List<Car> listOfCars(){
//
//        List<Car> cars = new ArrayList<Car>();
//        carRepository.findAll().forEach(cars::add);
//        return cars;
//    }
//
//    @PostMapping("/cars")
//    public void addCar(@RequestBody Car car) throws Exception{
//
//        carRepository.save(car);
//
//    }
//
//
//    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
//
//        List<Car> cars = new ArrayList<Car>();
//        carRepository.findAll().forEach(cars::add);
//
//        for(Car car : cars) {
//            if(car.getPlateNumber().equals(plateNumber)) {
//                return car;
//            }
//        }
//
//        return null;
//
//    }


//    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public Rent rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
//                   @RequestBody Rent rendUser,
//                   @RequestParam(value="rent", required = true)boolean rent) throws Exception {
//
//        for (Car car : cars) {
//            if (car.getPlateNumber().equals(plateNumber)) {
//                car.setRent(rent);
//
//                if (car.isRent()) {
//                    car.getRents().add(rendUser);
//                    return car.getRents().get(car.getRents().size() -1);
//
//                } else {
//                    return null;
//                }
//            }
//        }
//        return null;
//    }

}
