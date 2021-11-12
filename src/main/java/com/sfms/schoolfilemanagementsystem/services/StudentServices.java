package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.model.Class;
import com.sfms.schoolfilemanagementsystem.data.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface StudentServices {

    Student registerWith(StudentRegistrationDto studentRegistrationDto);

    Optional<Student> findByStudentId(Long studentId);

    void deleteStudentBy(Long id);

    List<Student> findAll();

    Student registerSubjectWith(StudentRegistrationDto studentRegistrationDto, SubjectRegistrationDto subjectRegistrationDto);

    Student registerClassWith(StudentRegistrationDto studentRegistrationDto, ClassRegistrationDto classRegistrationDto);

    List<Subject> findAllSubjectsForStudentBy(Long studentId);

    List<Class> findAllClassesForStudentBy(Long studentId);

    List<Teacher> findAllTeachersForStudentBy(Long studentId);
}
