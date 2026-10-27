package com.example.crudSpringBootDemo.controller;


import com.example.crudSpringBootDemo.dto.StudentRequestDTO;
import com.example.crudSpringBootDemo.dto.StudentResponseDTO;
import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.net.ssl.HttpsURLConnection;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO createdStudent= studentService.createStudent(studentRequestDTO);
        return ResponseEntity.ok(createdStudent);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp= studentService.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentResp= studentService.getAllStudents();
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq){
        Student studentResp= studentService.updateStudent(id, studentReq);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(! isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Student deleted successfully");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> softDelete (@PathVariable Long id){
        Boolean isDeleted = studentService.deleteSoftly(id);
        if (!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Soft deleted Successfully");
    }

}
