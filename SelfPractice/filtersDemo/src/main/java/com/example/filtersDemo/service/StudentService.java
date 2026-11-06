package com.example.filtersDemo.service;

import com.example.filtersDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student){
        System.out.println("Student created");
        System.out.println(student.getName());
    }

}


