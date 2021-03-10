package com.example.demoWebService.Entity;


import com.example.demoWebService.Utils.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany
    private List<Rent> rents;

    public Vehicule(){super();}

    public Vehicule(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rents = null;
    }

    public boolean isRent(Date beginDate, Date endDate) {

        for(Rent rent: rents) {

            if(DateUtils.isWithinRange(rent.getBenginRent(), rent.getEndRent(), beginDate) ||
            DateUtils.isWithinRange(rent.getBenginRent(), rent.getEndRent(), endDate)) {
                return true;
            }

        }

        return false;
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

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "Vehicule [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
    }


}
