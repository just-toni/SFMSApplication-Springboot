package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.services.ClassRegistrationDto;
import com.sfms.schoolfilemanagementsystem.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("class/add")
    public Class registerWith(@RequestBody ClassRegistrationDto classRegistrationDto){
        return classService.registerWith(classRegistrationDto);
    }

    @GetMapping("class/findAll")
    public List<Class> findAll(){
        return classService.findAll();
    }

    @GetMapping("class/findBy{classId}")
    public Optional<Class> findByClassId(@PathVariable Long classId){
        return classService.findByClassId(classId);
    }

    @DeleteMapping("class/delete/{classId}")
    public void deleteClassBy(@PathVariable Long classId){
        classService.deleteClassBy(classId);
    }

    @GetMapping("subject/findAllStudentsForClassWith/{classId}")
    public List<Student> findAllStudentBy(@PathVariable Long classId){
        return classService.findAllStudentsInThisClassWith(classId);
    }

    @GetMapping("subject/findAllSubjectsForClassWith/{classId}")
    public List<Subject> findAllClassesBy(@PathVariable Long classId){
        return classService.findAllSubjectsForThisClassWith(classId);
    }
}
