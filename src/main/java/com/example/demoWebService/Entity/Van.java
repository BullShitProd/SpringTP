package com.example.demoWebService.Entity;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule {

    float maxWeight;

    public Van() {super();}

    public Van(String plateNumber, String brand, int price, boolean rent, float maxWeight) {
        super(plateNumber, brand, price, rent);
        this.maxWeight = maxWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }
}
