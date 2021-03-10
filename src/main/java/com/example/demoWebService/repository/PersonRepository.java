package com.example.demoWebService.repository;

import com.example.demoWebService.Entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
