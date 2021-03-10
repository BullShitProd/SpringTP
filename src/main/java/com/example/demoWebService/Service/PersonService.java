package com.example.demoWebService.Service;

import com.example.demoWebService.Entity.Person;
import com.example.demoWebService.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.personRepository.save(new Person("Jean-Claude"));
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Person> listOfPersons(){

        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) throws Exception{
        personRepository.save(person);

        return "Person successfully registered";
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person aPerson(@PathVariable("id") long id) throws Exception{
        List<Person> persons = new ArrayList<Person>();

        personRepository.findAll().forEach(persons::add);

        for(Person person : persons) {
            if(person.getId() == id) {
                return person;
            }
        }

        return null;
    }


}
