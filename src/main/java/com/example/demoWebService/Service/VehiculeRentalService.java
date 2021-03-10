package com.example.demoWebService.Service;

import com.example.demoWebService.Entity.Person;
import com.example.demoWebService.Entity.Rent;
import com.example.demoWebService.Entity.Vehicule;
import com.example.demoWebService.repository.PersonRepository;
import com.example.demoWebService.repository.RentRepository;
import com.example.demoWebService.repository.VehiculeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VehiculeRentalService {

    RentRepository rentRepository;
    VehiculeRepository vehiculeRepository;
    PersonRepository personRepository;

    public VehiculeRentalService(RentRepository rentRepository, VehiculeRepository vehiculeRepository,
                                 PersonRepository personRepository) {
        this.rentRepository = rentRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/rents/{idVehicule}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Rent rentAndGetBack(
            @PathVariable("idVehicule") long idVehicule,
            @RequestBody Rent rent,
            @RequestParam(value="idPerson", required = true)long idPerson
                             ) throws Exception
    {

        //get Vehicule and Personne
        Optional<Vehicule> findVehicule = this.vehiculeRepository.findById(idVehicule);
        Optional<Person> findPerson = this.personRepository.findById(idPerson);
        if(findVehicule.isEmpty() || findPerson.isEmpty()) {
            return null;
        }
        Vehicule vehicule = findVehicule.get();
        Person person = findPerson.get();

        if(vehicule.isRent(rent.getBenginRent(), rent.getEndRent())) {
            return null;
        }

        rent.setPerson(person);
        rent.setVehicule(vehicule);

        vehicule.getRents().add(rent);

        person.getRents().add(rent);

        this.rentRepository.save(rent);
        this.vehiculeRepository.save(vehicule);
        this.personRepository.save(person);


        return rent;
    }




}
