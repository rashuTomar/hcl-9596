package com.example.crudDtoDemo.service;


import com.example.crudDtoDemo.entity.Student;
import com.example.crudDtoDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }


    public Student createStudent(Student studentReq){
        return studentRepository.save(studentReq);
    }
}
