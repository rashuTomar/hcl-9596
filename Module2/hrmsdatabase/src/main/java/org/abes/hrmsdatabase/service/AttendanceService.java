package org.abes.hrmsdatabase.service;


import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.repository.AttendanceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public String markAttendance(Attendance attendance) {

        long emp_id = attendance.getEmployee().getEmpId();

        // Check whether employee exists
        if (!employeeRepository.existsById(emp_id)) {
            return "Employee does not exist";
        }

        // Check for duplicate attendance
        boolean alreadyMarked = attendanceRepository.existsByEmployee_EmpIdAndAttendancedate(emp_id, attendance.getAttendancedate());

        if (alreadyMarked) {
            return "Attendance already marked for this employee on this date";
        }
        // Save only if no duplicate exists
        attendanceRepository.save(attendance);

        return "Attendance marked successfully";
    }
}