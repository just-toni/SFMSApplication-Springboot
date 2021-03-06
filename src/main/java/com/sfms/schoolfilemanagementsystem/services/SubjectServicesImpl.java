package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.data.model.Class;
import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.model.Teacher;
import com.sfms.schoolfilemanagementsystem.data.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectServicesImpl implements SubjectServices {

    Subject subject = new Subject();

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherServices teacherServices;

    @Autowired
    StudentServices studentServices;

    @Autowired
    ClassService classService;

    @Override
    public Subject registerWith(SubjectRegistrationDto subjectRegistrationDto) {
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

    @Override
    public List<Teacher> findAllTeachersBy(Long subjectId) {
        return teacherServices.findAll().stream().filter(teacher -> {
            for (Subject subject : teacher.getSubject()) {
                return subject.getSubjectId().equals(subjectId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Student> findAllStudentsBy(Long subjectId) {
        return studentServices.findAll().stream().filter(student -> {
            for (Subject subject : student.getSubject()) {
                return subject.getSubjectId().equals(subjectId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Class> findAllClassesBy(Long subjectId) {
        return classService.findAll().stream().filter(class1 -> {
            for (Subject subject : class1.getSubject()) {
                return subject.getSubjectId().equals(subjectId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteStudentFromSubjectBy(Long studentId, Long subjectId) {
        Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);
        if (subjectOptional.isPresent()) {
            Student student = new Student();
            if (student.getStudentId().equals(studentId)) {
                studentServices.deleteStudentBy(studentId);
            }
        }
    }


}
