package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.services.SubjectRegistrationDto;
import com.sfms.schoolfilemanagementsystem.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectServices subjectServices;

    @PostMapping("subject/add")
    public Subject registerWith(@RequestBody SubjectRegistrationDto subjectRegistrationDto){
        return subjectServices.registerWith(subjectRegistrationDto);
    }


}
