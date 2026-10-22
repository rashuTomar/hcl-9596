package com.example.hrms.repository;

import org.springframework.stereotype.Component;

@Component
public class EmpRepImp implements EmpRepo {
    @Override
    public double squareroot(double d){
        double result = Math.sqrt(d);
        return result;
    }

    @Override
    public String empData(){
        return "";
    }

    @Override
    public int add(int a, int b){
        return a+b ;
    }

    @Override
    public int checkGreater(int a, int b){
        int max = (a > b) ? a : b;
        return max;
    }

}
