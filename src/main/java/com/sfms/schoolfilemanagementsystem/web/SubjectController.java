package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectServices subjectServices;

}
