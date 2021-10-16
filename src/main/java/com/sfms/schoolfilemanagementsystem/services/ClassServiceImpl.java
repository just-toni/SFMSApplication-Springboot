package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;

    Class class1 = new Class();

    @Autowired
    StudentServices studentServices;

    @Autowired
    SubjectServices subjectServices;

    @Override
    public Class registerWith(ClassRegistrationDto classRegistrationDto) {
        class1.setClassName(classRegistrationDto.getClassName());
        class1.setClassType(classRegistrationDto.getClassType());
        return classRepository.save(class1);
    }

    @Override
    public Optional<Class> findByClassId(Long classId) {
        return classRepository.findById(classId);
    }

    @Override
    public void deleteClassBy(Long classId) {
        classRepository.deleteById(classId);
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsInThisClassWith(Long classId) {
//        class1.getClassId().equals(classId);
//        return class1.getStudents();
        Optional<Class> optionalClass = classRepository.findById(classId);
        if(optionalClass.isPresent()){
            return (List<Student>) optionalClass.get().getStudents();
        }
        return null;
    }

    @Override
    public List<Subject> findAllSubjectsForThisClassWith(Long classId) {
        return subjectServices.findAll().stream().filter(subject -> {
            for(Class class1 : subject.getClasses()){
                return class1.getClassId().equals(classId);
            }
            return false;
        }).collect(Collectors.toList());
    }


}
