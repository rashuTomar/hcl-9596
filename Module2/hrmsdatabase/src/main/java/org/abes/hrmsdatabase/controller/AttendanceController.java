package org.abes.hrmsdatabase.controller;


import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/v1/user/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendanceService.markAttendance(attendance);
    }
}
