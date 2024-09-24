package com.example.Agilistan.service;

import com.example.Agilistan.entity.Person;
import com.example.Agilistan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
