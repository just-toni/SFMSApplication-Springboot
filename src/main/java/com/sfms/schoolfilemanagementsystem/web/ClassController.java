package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;


}
