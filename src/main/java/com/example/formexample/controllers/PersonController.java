package com.example.formexample.controllers;

import com.example.formexample.entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ConcurrentHashMap;

@Controller
public class PersonController {

    public static final String ATTR_PERSON = "person";
    public static final String ATTR_NAME = "name";

    private final ConcurrentHashMap<String, Person> persons;

    public PersonController(ConcurrentHashMap<String, Person> persons) {
        this.persons = persons;
    }

    @Bean
    public static ConcurrentHashMap<String, Person> makePersonsMap() {
        return new ConcurrentHashMap<>();
    }

    @GetMapping("/person-form")
    public String getPersonForm(Model model) {
        model.addAttribute(ATTR_PERSON, new Person());
        return "person-form";
    }

    @PostMapping("/register-person")
    public String postPerson(Person person, RedirectAttributes attributes) {
        persons.put(person.getName(), person);
        attributes.addAttribute(ATTR_NAME, person.getName());
        return "redirect:/person/{name}";
    }

    @GetMapping("/person/{name}")
    public String getPerson(@PathVariable String name, Model model) {
        model.addAttribute(ATTR_PERSON, persons.get(name));
        return "person";
    }
}
