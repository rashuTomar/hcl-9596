package com.example.hrms.controller;

import com.example.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private DemoEmployee demoEmployee;

    @GetMapping("/")
    public String welcome(){
        return "<h2 >welcome to hrms app</h2>";
    }
    @GetMapping("/add")
    public int add(){
        System.out.println("inside /add controller point");
        int result= demoEmployee.add(20, 50);
        System.out.println("result from model= "+ result);
        return result;
    }

    @GetMapping("/sqrt")
    public double getSqureRoot(){
        return demoEmployee.squareRoot(678);
    }

    @GetMapping("/gtn")
    public int checkgtn(){
        return demoEmployee.checkGreater(100, 99);

    }

}
