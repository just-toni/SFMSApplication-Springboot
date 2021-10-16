package com.sfms.schoolfilemanagementsystem.services;

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
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServices{

    Student student1 = new Student();

   @Autowired
   private StudentRepository studentRepository;

   @Autowired
   private SubjectServices subjectServices;

   @Autowired
   private ClassService classService;

   @Autowired
   private TeacherServices teacherServices;

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
        subject1.setSubjectName(subjectRegistrationDto.getSubjectName());
        subject1.setSubjectDescription(subjectRegistrationDto.getSubjectDescription());
        student1.setName(studentRegistrationDto.getStudentName());
        student1.setDateOfBirth(LocalDate.parse(studentRegistrationDto.getDateOfBirth()));
        student1.getSubject().add(subject1);
        subject1.getStudents().add(student1);
        return student1;
    }

    @Override
    public Student registerClassWith(StudentRegistrationDto studentRegistrationDto, ClassRegistrationDto classRegistrationDto) {
        Class class1 = new Class();
        class1.setClassName(classRegistrationDto.getClassName());
        class1.setClassType(classRegistrationDto.getClassType());
        student1.setName(studentRegistrationDto.getStudentName());
        student1.setDateOfBirth(LocalDate.parse(studentRegistrationDto.getDateOfBirth()));
        student1.setClasses(class1);
        class1.getStudents().add(student1);
        return student1;
    }

    @Override
    public List<Subject> findAllSubjectsForStudentBy(Long studentId) {
        return subjectServices.findAll().stream().filter(subject -> {
            for(Student student: subject.getStudents()){
                return student.getStudentId().equals(studentId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Class> findAllClassesForStudentBy(Long studentId) {
        return classService.findAll().stream().filter(class1 -> {
            for(Student student: class1.getStudents()){
                return student.getStudentId().equals(studentId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> findAllTeachersForStudentBy(Long studentId) {
        return teacherServices.findAll().stream().filter(teacher -> {
            for(Student student: teacher.getStudents()){
                return student.getStudentId().equals(studentId);
            }
            return false;
        }).collect(Collectors.toList());
    }


}
