package com.example.demoWebService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Entity
public class Car {

    private long id;
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rent;

//    private ArrayList<Rent> rents;


    public Car() {
        super();
    }

    public Car(String plateNumber, String brand, int price) {
        super();
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        rent = false;
//        rents = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

//    public ArrayList<Rent> getRents() {
//        return rents;
//    }

//    public void setRents(ArrayList<Rent> rents) {
//        this.rents = rents;
//    }

    @Override
    public String toString() {
        return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
    }

}