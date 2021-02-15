package com.example.demoWebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<Car>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "Ferrari", 1000));
        cars.add(new Car("33BB44", "Porshe", 2222));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars(){
        return cars;
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        cars.add(car);
    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{

        for(Car car : cars) {
            if(car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        return null;

    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Rent rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
                   @RequestParam(value="rent", required = true)boolean rent) throws Exception {

        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                car.setRent(rent);
                car.getRents().add(new Rent("11/11/2017", "1/1/2018"));

                if (car.isRent()) {
                    return car.getRents().get(car.getRents().size() -1);

                } else {
                    return null;
                }
            }
        }
        return null;
    }


}
