package com.example.demoWebService.Entity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rent;

    public Vehicule(){super();}

    public Vehicule(String plateNumber, String brand, int price, boolean rent) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rent = rent;
    }

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

    @Override
    public String toString() {
        return "Vehicule [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
    }
}
