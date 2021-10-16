package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.services.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @PostMapping("student/add")
    public Student registerStudent(@RequestBody StudentRegistrationDto studentRegistrationDto){
        return studentServices.registerWith(studentRegistrationDto);
    }

}
