package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public  String msg(){
        return "welcome to appppp";
    }

    @GetMapping("/addemp")
    public String addnewEmployee(){
        return employeeService.createnewEmployee();
    }

    @GetMapping("/findbyid/{empid}")
    public Employee getEmpById(@PathVariable long empid){
        System.out.println("Employee id: "+ empid);
        return employeeService.getEmployeeById(empid);

    }
    @DeleteMapping("/deletebyid/{empid}")
    public Employee deleteById(@PathVariable long empid){
        return employeeService.DeleteById(empid);
    }

    @PutMapping("/updatebyid/{empid}")
    public Employee updateById(@PathVariable long empid, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployee(empid, updatedEmployee);
    }
}
