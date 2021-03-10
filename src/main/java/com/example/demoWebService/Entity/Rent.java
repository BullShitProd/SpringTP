package com.example.demoWebService.Entity;

import com.example.demoWebService.Utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;

@Entity
public class Rent {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date benginRent, endRent;

    @ManyToOne
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JsonIgnore
    private Vehicule vehicule;


    public Rent() {super(); }

    public Rent(Date benginRent, Date endRent, Person person, Vehicule vehicule) {
        this.benginRent = benginRent;
        this.endRent = endRent;
        this.person = person;
        this.vehicule = vehicule;
    }

    public Rent(String benginRent, String endRent) throws ParseException {
        this.benginRent = DateUtils.getDate(benginRent);
        this.endRent = DateUtils.getDate(endRent);
        this.person = null;
        this.vehicule = null;
    }



    public Person getPerson() {
        return person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getBenginRent() {
        return benginRent;
    }

    public void setBenginRent(Date benginRent) {
        this.benginRent = benginRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

}
