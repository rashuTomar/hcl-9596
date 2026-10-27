package com.example.crudDtoDemo.controller;


import com.example.crudDtoDemo.entity.Student;
import com.example.crudDtoDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestBody("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService= studentService;
    }


    @PostMapping("/")
    public ResponseEntity<Student> create(@RequestBody Student studentReq){
        Student studentRes = studentService.createStudent(Student studentReq);
        return ResponseEntity.ok(studentRes);
    }
}
