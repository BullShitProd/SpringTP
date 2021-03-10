package com.example.demoWebService.Entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Van extends Vehicule {

    float maxWeight;

    public Van() {super();}

    public Van(String plateNumber, String brand, int price, boolean rent, float maxWeight, List<Rent> rents) {
        super(plateNumber, brand, price);
        this.maxWeight = maxWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }
}
