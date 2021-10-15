package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;
    Student student1 = new Student();

    @Override
    public Class registerWith(ClassRegistrationDto classRegistrationDto) {
        Class class1 = new Class();
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


}
