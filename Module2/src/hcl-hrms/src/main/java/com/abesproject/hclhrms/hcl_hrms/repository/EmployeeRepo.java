package com.abesproject.hclhrms.hcl_hrms.repository;

import com.abesproject.hclhrms.hcl_hrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
    String addEmp(Employee emp);
    String addEmpBulk(List<Employee> bulkEmp);
    String addEmpbulk();
    List<Employee> getEmp();
    Employee getEmpById(long empId);
    String deleteById(long empId);
    String updateById(long empId, Employee updatedEmp);
}
