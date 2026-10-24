package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee(){
        Employee emp1= new Employee(200L, "Mishra", "javaStack", "sde");
        Employee emp2= new Employee(199L, "Yashu", "javaStack", "quality analysis");
        Employee emp3= new Employee(198L, "Riya", "MERN", "manager");

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        return "Employees are added successfully";
    }


    public Employee getEmployeeById(long empid){
        return employeeRepository.findById(empid).orElse(null);
    }

    public Employee updateEmployee(long empid, Employee updatedEmployee){
        Employee employee = employeeRepository.findById(empid).orElse(null);
        if (employee == null) {
            return null;
        }

        employee.setEmp_name(updatedEmployee.getEmp_name());
        employee.setStack(updatedEmployee.getStack());
        employee.setDesignation(updatedEmployee.getDesignation());
        return employeeRepository.save(employee);
    }

    public Employee DeleteById(long empid){
        Employee employee = employeeRepository.findById(empid).orElse(null);
        if (employee != null) {
            employeeRepository.deleteById(empid);
        }
        return employee;
    }
}
