package com.sfms.schoolfilemanagementsystem.services;


import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.model.Class;

import java.util.List;
import java.util.Optional;

public interface SubjectServices {
    Subject registerWith(SubjectRegistrationDto subjectRegistrationDto);
    Optional<Subject> findBySubjectId(Long subjectId);
    void deleteSubjectBy(Long id);
    List<Subject> findAll();
    List<Teacher> findAllTeachersBy(Long subjectId);
    List<Student> findAllStudentsBy(Long subjectId);
    List<Class> findAllClassesBy(Long subjectId);
    void deleteStudentFromSubjectBy(Long studentId, Long subjectId);

}
