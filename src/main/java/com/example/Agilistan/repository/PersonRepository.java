package com.example.Agilistan.repository;

import com.example.Agilistan.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContaining(String name);
    List<Person> findByName(String name);
}
