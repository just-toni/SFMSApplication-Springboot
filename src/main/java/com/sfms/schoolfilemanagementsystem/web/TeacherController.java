package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.services.TeacherRegistrationDto;
import com.sfms.schoolfilemanagementsystem.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherServices teacherServices;

    @PostMapping("teacher/add")
    public Teacher registerTeacher(@RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        return teacherServices.registerWith(teacherRegistrationDto);
    }

    @DeleteMapping("teacher/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherServices.deleteBy(id);
    }

    @GetMapping("teacher/findAll")
    public List<Teacher> findAll() {
        return teacherServices.findAll();
    }

}
