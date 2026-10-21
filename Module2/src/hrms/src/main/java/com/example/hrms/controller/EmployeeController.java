package com.example.hrms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String welcome(){
        return "<h2>welcome to hrms app</h2>";
    }

}
