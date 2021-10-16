package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.services.ClassRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Class;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ClassService {

    Class registerWith(ClassRegistrationDto classRegistrationDto);
    Optional<Class> findByClassId(Long classId);
    void deleteClassBy(Long classId);
    List<Class> findAll();
    List<Student> findAllStudentsInThisClassWith(Long classId);
    List<Subject> findAllSubjectsForThisClassWith(Long classId);
}
