package com.example.formexample.controllers;

import com.example.formexample.entities.Person;
import com.example.formexample.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ConcurrentHashMap;

@Controller
public class StudentController {

    public static final String ATTR_STUDENT = "student";
    public static final String ATTR_NAME = "name";

    private final ConcurrentHashMap<String, Student> students;

    public StudentController(ConcurrentHashMap<String, Student> students) {
        this.students = students;
    }

    @Bean
    public static ConcurrentHashMap<String, Student> makeStudentsMap() {
        return new ConcurrentHashMap<>();
    }

    @GetMapping("/student-form")
    public String getPersonForm(Model model) {
        model.addAttribute(ATTR_STUDENT, new Student());
        return "student-form";
    }

    @PostMapping("/register-student")
    public String postStudent(Student student, RedirectAttributes attributes) {
        students.put(student.getName(), student);
        attributes.addAttribute(ATTR_NAME, student.getName());
        return "redirect:/student/{name}";
    }

    @GetMapping("/student/{name}")
    public String getPerson(@PathVariable String name, Model model) {
        model.addAttribute(ATTR_STUDENT, students.get(name));
        return "student";
    }
}
