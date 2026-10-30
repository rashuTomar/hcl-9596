
package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee(Employee newEmp) {

        employeeRepository.save(newEmp);

        return "Employees are added successfully";
    }

    public Employee getEmployeeById(long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    public Employee updateEmployee(long empId, Employee updatedEmployee) {

        Employee employee = employeeRepository.findById(empId).orElse(null);

        if (employee == null) {
            return null;
        }

        employee.setEmpName(updatedEmployee.getEmpName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPassword(updatedEmployee.getPassword());
        employee.setStack(updatedEmployee.getStack());
        employee.setDesignation(updatedEmployee.getDesignation());

        return employeeRepository.save(employee);
    }

    public Employee DeleteById(long empId) {

        Employee employee = employeeRepository.findById(empId).orElse(null);

        if (employee != null) {
            employeeRepository.deleteById(empId);
        }

        return employee;
    }

    public String login(Employee loginRequest) {
        if (loginRequest == null || loginRequest.getPassword() == null) {
            return "Invalid employee ID or password";
        }

        Employee employee = employeeRepository.findById(loginRequest.getEmpId()).orElse(null);
        if (employee == null || !loginRequest.getPassword().equals(employee.getPassword())) {
            return "Invalid employee ID or password";
        }
        return "Login successful";
    }
}
