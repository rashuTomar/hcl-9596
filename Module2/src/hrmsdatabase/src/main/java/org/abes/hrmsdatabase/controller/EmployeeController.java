package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/v1/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public  String msg(){
        return "welcome to appppp";
    }

    @PostMapping("/addemp")
    public String addnewEmployee(@RequestBody Employee newEmp ){
        System.out.println(newEmp.getDesignation());
        return employeeService.createnewEmployee(newEmp);
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee employee) {
        return employeeService.login(employee);
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
