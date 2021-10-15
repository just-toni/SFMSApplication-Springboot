package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectServicesImpl implements SubjectServices{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject registerWith(SubjectRegistrationDto subjectRegistrationDto) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectRegistrationDto.getSubjectName());
        subject.setSubjectDescription(subjectRegistrationDto.getSubjectDescription());
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findBySubjectId(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public void deleteSubjectBy(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }


}
