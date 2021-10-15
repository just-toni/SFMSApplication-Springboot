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
    Student registerSubjectWith(StudentRegistrationDto studentRegistrationDto, SubjectRegistrationDto subjectRegistrationDto);
    Student registerClassWith(StudentRegistrationDto studentRegistrationDto, ClassRegistrationDto classRegistrationDto);
    Optional<Subject> findAllSubjectsForStudentBy(Long studentId);
    Optional<Class> findAllClassesForStudentBy(Long studentId);
    List<Teacher> findAllTeachersForStudentBy(Long studentId);
}
