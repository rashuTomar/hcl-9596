package com.abesproject.hclhrms.hcl_hrms.repository;

import com.abesproject.hclhrms.hcl_hrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EmpRepoImp implements EmployeeRepo {
    private final List<Employee> emplist = new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        emplist.add(emp);
        return "Employee added successfully";
    }

    @Override
    public String addEmpBulk(List<Employee> bulkEmp) {
        emplist.addAll(Objects.requireNonNull(bulkEmp, "bulkEmp must not be null"));
        return "All employees added";
    }

    @Override
    public String addEmpbulk() {
        List<Employee> employeesList = List.of(
                new Employee(890, "Ram", "Test Engineer", "Java", "ram@gmail.com"),
                new Employee(891, "Amit", "Test Engineer", "Java", "amit@gmail.com"),
                new Employee(892, "Priya", "Software Engineer", "Python", "priya@gmail.com"),
                new Employee(893, "Neha", "HR Manager", "HRMS", "neha@gmail.com")
        );
        emplist.addAll(employeesList);
        return "All employees added";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long empid) {
        return  emplist.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);

    }

    @Override
    public String deleteById(long empid) {
        boolean removed = emplist.removeIf(employee -> employee.getEmp_id() == empid);
        return removed ? "Employee deleted successfully" : "Employee not found";
    }

    @Override
    public String updateById(long empid, Employee updatedEmp) {
        Objects.requireNonNull(updatedEmp, "updatedEmp must not be null");
        for (int i = 0; i < emplist.size(); i++) {
            if (emplist.get(i).getEmp_id() == empid) {
                emplist.set(i, updatedEmp);
                return "Employee updated successfully";
            }
        }
        return "Employee not found";
    }
}