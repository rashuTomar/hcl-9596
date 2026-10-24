package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentResp= studentRepository.save(studentReq);
        return studentResp;
    }
    public Student getStudent(Long id){
        Optional<Student> studentResp= studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }
}
