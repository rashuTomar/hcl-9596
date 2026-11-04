
package org.abes.hrmsdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Employee {

    @Id
    private long empId;

    private String empName;

    private String email;

    private String password;

    private String designation;

    private String stack;

    // Default constructor compulsory for JPA
    public Employee() {
    }

    public Employee(long empId, String empName, String email,
                    String password, String designation, String stack) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.password = password;
        this.designation = designation;
        this.stack = stack;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
