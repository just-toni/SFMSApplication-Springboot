package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Student> findByStudentId(Long studentId){
        return studentRepository.findById(studentId);
    }

    public void deleteStudentBy(Long studentId){
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student registerSubjectWith(StudentRegistrationDto studentRegistrationDto, SubjectRegistrationDto subjectRegistrationDto) {
        Subject subject1 = new Subject();
        Student student1 = new Student();
        subject1.setSubjectName(subjectRegistrationDto.getSubjectName());
        subject1.setSubjectDescription(subjectRegistrationDto.getSubjectDescription());
        student1.setName(studentRegistrationDto.getStudentName());
        student1.setDateOfBirth(LocalDate.parse(studentRegistrationDto.getDateOfBirth()));
    }

    @Override
    public Class registerClassWith(StudentRegistrationDto studentRegistrationDto) {
        return null;
    }

    @Override
    public List<Subject> findAllSubjectsForStudentBy(Long studentId) {
        return null;
    }

    @Override
    public List<Class> findAllClassesForStudentBy(Long studentId) {
        return null;
    }

    @Override
    public List<Teacher> findAllTeachersForStudentBy(Long studentId) {
        return null;
    }


}
