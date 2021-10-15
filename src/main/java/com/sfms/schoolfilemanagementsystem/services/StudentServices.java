package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface StudentServices {

    Student registerWith(StudentRegistrationDto studentRegistrationDto);
    Optional<Student> findByStudentId(Long studentId);
    void deleteStudentBy(Long id);
    List<Student> findAll();
    Subject registerSubjectWith(StudentRegistrationDto studentRegistrationDto);
    Class registerClassWith(StudentRegistrationDto studentRegistrationDto);
    List<Subject> findAllSubjectsForStudentBy(Long studentId);
    List<Class> findAllClassesForStudentBy(Long studentId);
    List<Teacher> findAllTeachersForStudentBy(Long studentId);
}
