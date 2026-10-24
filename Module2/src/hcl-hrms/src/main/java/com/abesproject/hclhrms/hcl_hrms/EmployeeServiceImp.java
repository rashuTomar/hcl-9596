package com.abesproject.hclhrms.hcl_hrms;

import com.abesproject.hclhrms.hcl_hrms.entity.Employee;
import com.abesproject.hclhrms.hcl_hrms.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    private final EmployeeRepo emprepo;

    public EmployeeServiceImp(EmployeeRepo emprepo) {
        this.emprepo = emprepo;
    }

    Employee emp1=new Employee(200l,"Rahul","FSD","Java","ptomer40@yahoo.com");

    public String addEmp(){
        //Employee emp1=new Employee(200l,"Rahul","FSD","Java","ptomer40@yahoo.com");
        return emprepo.addEmp(emp1);
    }

    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }

    public Employee getEmpById(){
        return  emprepo.getEmpById(2001);
    }


    public String addBulkEmp(){
        return  emprepo.addEmpbulk();
    }

    public String addBulkEmp(List<Employee> employees) {
        return emprepo.addEmpBulk(employees);
    }

    public String deleteById(long empId){
        return emprepo.deleteById(empId);
    }


}
