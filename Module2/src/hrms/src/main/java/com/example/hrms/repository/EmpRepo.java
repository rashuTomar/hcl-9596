package com.example.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo {
    double squareroot(double d);
    String empData();

    public int add(int a, int b);
    public int checkGreater(int a, int b);


}
