package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentServices{
   @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student registerWith(StudentRegistrationDto studentRegistrationDto) {
        Student student = new Student();
        System.out.println(studentRegistrationDto.getStudentName());
        student.setName(studentRegistrationDto.getStudentName());
        student.setDateOfBirth(LocalDate.parse(studentRegistrationDto.getDateOfBirth()));
        return studentRepository.save(student);
    }
}
