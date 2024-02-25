package com.example.ru.spring4.controllers;

import com.example.ru.spring4.model.Student;
import com.example.ru.spring4.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/student")
    public String getStudents(Model model) {
        service.getAllStudents();
        model.addAttribute("students", service.getAllStudents());
        return "student";
    }

    @PostMapping("/student")
    public String addStudent(Student student, Model model) {
        service.addStudent(student);
        model.addAttribute("students", service.getAllStudents());
        return "student";
    }
}
