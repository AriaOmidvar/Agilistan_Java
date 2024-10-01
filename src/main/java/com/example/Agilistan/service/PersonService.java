package com.example.Agilistan.service;

import com.example.Agilistan.entity.Person;
import com.example.Agilistan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons(String name) {
        if (name != null) {
            return personRepository.findByNameContaining(name);
        } else {
            return personRepository.findAll();
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<String> getAllNames() {
        return personRepository.findAll().stream().map(Person::getName).collect(Collectors.toList());
    }

    public Person getPersonByName(String name) {
            return personRepository.findByName(name).getFirst();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
