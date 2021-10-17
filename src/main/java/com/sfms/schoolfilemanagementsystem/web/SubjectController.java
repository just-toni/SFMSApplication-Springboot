package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.services.SubjectRegistrationDto;
import com.sfms.schoolfilemanagementsystem.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    @Autowired
    private SubjectServices subjectServices;

    @PostMapping("subject/add")
    public Subject registerWith(@RequestBody SubjectRegistrationDto subjectRegistrationDto){
        return subjectServices.registerWith(subjectRegistrationDto);
    }

    @GetMapping("subject/findAll")
    public List<Subject> findAll(){
        return subjectServices.findAll();
    }

    @GetMapping("subject/findby{subjectId}")
    public Optional<Subject> findBySubjectId(@PathVariable Long subjectId){
        return subjectServices.findBySubjectId(subjectId);
    }

    @DeleteMapping("subject/delete/{subjectId}")
    public void deleteSubjectBy(@PathVariable Long subjectId){
        subjectServices.deleteSubjectBy(subjectId);
    }



}
