package com.example.hrms.model;

import com.example.hrms.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {

    @Autowired
    private EmpRepo repo;
    public int add(int a, int b){
        return repo.add(20,40);
    }

    public double squareRoot(double d){
        return repo.squareroot(2000);
    }

    public int checkGreater(int a, int b){
        return repo.checkGreater(100,99);
    }

}
