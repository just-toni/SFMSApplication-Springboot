package com.sfms.schoolfilemanagementsystem.services;


import com.sfms.schoolfilemanagementsystem.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectServices {
    Subject registerWith(SubjectRegistrationDto studentRegistrationDto);
    Optional<Subject> findBySubjectId(Long studentId);
    void deleteSubjectBy(Long id);
    List<Subject> findAll();
}
