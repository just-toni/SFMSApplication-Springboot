package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;

import java.util.Optional;

public interface StudentServices {

    Student registerWith(StudentRegistrationDto studentRegistrationDto);
    Optional<Student> findByStudentId(Long studentId);
}
