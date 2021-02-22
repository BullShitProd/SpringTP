package com.example.demoWebService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Entity
public class Car extends Vehicule {

    int numberOfSeats;

    public Car() {
        super();
    }

    public Car(String plateNumber, String brand, int price, boolean rent, int numberOfSeats) {
        super(plateNumber, brand, price, rent);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}