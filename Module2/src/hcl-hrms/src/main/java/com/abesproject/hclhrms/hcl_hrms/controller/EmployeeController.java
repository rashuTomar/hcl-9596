package com.abesproject.hclhrms.hcl_hrms.controller;

import com.abesproject.hclhrms.hcl_hrms.EmployeeServiceImp;
import com.abesproject.hclhrms.hcl_hrms.entity.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to ABES HRMS ";
    }

    @GetMapping("/addemp")
    public String addnewEmployee(){
        return employeeServiceImp.addEmp();
    }

    @GetMapping("/addempbulk")
    public String addEmployeesInBulk() {
        return employeeServiceImp.addBulkEmp();
    }

    @GetMapping("/getemp")
    public List<Employee> getEmp(){
        return employeeServiceImp.getEmp();
    }
    @GetMapping("getempbyid")
    public Employee getEmpById(){
        return  employeeServiceImp.getEmpById();
    }

    @DeleteMapping("/deleteemp/{empId}")
    public String deleteEmployee(@PathVariable long empId) {
        return employeeServiceImp.deleteById(empId);
    }

}