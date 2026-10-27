package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.dto.StudentRequestDTO;
import com.example.crudSpringBootDemo.dto.StudentResponseDTO;
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

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
        Student student= mapToEntity(studentRequestDTO);
        Student studentResp= studentRepository.save(student);
        return mapToDTO(studentResp);
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

    private Student mapToEntity(StudentRequestDTO studentRequestDTO){
        Student student= new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());
        student.setDeleted(false);

        return student;
    }
    private StudentResponseDTO mapToDTO(Student student){
        StudentResponseDTO responseDTO= new StudentResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setMessage("Student saved successfully");

        return responseDTO;

    }

}
