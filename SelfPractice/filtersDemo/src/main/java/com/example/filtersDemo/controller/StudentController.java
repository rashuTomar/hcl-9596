package com.example.filtersDemo.controller;

import com.example.filtersDemo.dto.Student;
import com.example.filtersDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<String> getStudents(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("List of students");
    }
}

