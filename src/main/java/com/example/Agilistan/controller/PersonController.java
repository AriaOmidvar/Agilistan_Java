package com.example.Agilistan.controller;

import com.example.Agilistan.entity.Person;
import com.example.Agilistan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String getPersons(@RequestParam(required = false) String name,
                              Model model) {
        List<Person> persons = personService.getPersons(name);
        model.addAttribute("persons", persons);
        return "ListPersons";
    }
}
