package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentResp= studentRepository.save(studentReq);
        return studentResp;
    }
    public Student getStudent(Long id){
        Optional<Student> studentResp= studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudents(){
        List<Student> studentResp = studentRepository.findByDeletedIsFalse();
        return studentResp;
    }

    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student updated = existingStudent.get();

        updated.setAge(studentReq.getAge());
        updated.setEmail(studentReq.getEmail());
        updated.setName(studentReq.getName());
        updated.setRollNo(studentReq.getRollNo());
        updated.setSubject(studentReq.getSubject());

        updated.setDeleted(false);

        return studentRepository.save(updated);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteSoftly(Long id){
        Optional<Student> existingStudent= studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student updatedStudent= existingStudent.get();
        updatedStudent.setDeleted(true);
        studentRepository.save(updatedStudent);
        return true;
    }
}
