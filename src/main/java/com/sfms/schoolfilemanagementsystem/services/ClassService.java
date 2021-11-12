package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.model.Class;

import java.util.List;
import java.util.Optional;

public interface ClassService {

    Class registerWith(ClassRegistrationDto classRegistrationDto);

    Optional<Class> findByClassId(Long classId);

    void deleteClassBy(Long classId);

    List<Class> findAll();

    List<Student> findAllStudentsInThisClassWith(Long classId);

    List<Subject> findAllSubjectsForThisClassWith(Long classId);
}
