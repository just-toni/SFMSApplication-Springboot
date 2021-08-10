package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.model.Teacher;

import java.util.List;

public interface TeacherServices {

    Teacher registerWith(TeacherRegistrationDto teacherRegistrationDto);
    void deleteBy(Long id);
    List<Teacher> findAll();

}

