package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;

public interface StudentServices {

    Student registerWith(StudentRegistrationDto studentRegistrationDto);
}
