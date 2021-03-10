package com.example.demoWebService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Car extends Vehicule {

    int numberOfSeats;

    public Car() {
        super();
    }

    public Car(String plateNumber, String brand, int price, int numberOfSeats) {
        super(plateNumber, brand, price);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}