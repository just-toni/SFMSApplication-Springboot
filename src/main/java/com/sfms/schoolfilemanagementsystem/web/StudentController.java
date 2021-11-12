package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.data.model.Class;
import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.model.Teacher;
import com.sfms.schoolfilemanagementsystem.services.ClassRegistrationDto;
import com.sfms.schoolfilemanagementsystem.services.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.services.StudentServices;
import com.sfms.schoolfilemanagementsystem.services.SubjectRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @PostMapping("student/add")
    public Student registerStudent(@RequestBody StudentRegistrationDto studentRegistrationDto) {
        return studentServices.registerWith(studentRegistrationDto);
    }

    @GetMapping("student/findAll")
    public List<Student> findAll() {
        return studentServices.findAll();
    }

    @DeleteMapping("student/delete/{studentId}")
    public void deleteStudentBy(@PathVariable Long studentId) {
        studentServices.deleteStudentBy(studentId);
    }

    @GetMapping("student/findBy/{studentId}")
    public Optional<Student> findByStudentId(@PathVariable Long studentId) {
        return studentServices.findByStudentId(studentId);
    }

    @PutMapping("student/assignSubject")
    public Student registerSubjectWith(@RequestBody StudentRegistrationDto studentRegistrationDto,
                                       @RequestBody SubjectRegistrationDto subjectRegistrationDto) {
        return studentServices.registerSubjectWith(studentRegistrationDto, subjectRegistrationDto);
    }

    @PutMapping("student/assignClass")
    public Student registerClassWith(@RequestBody StudentRegistrationDto studentRegistrationDto,
                                     @RequestBody ClassRegistrationDto classRegistrationDto) {
        return studentServices.registerClassWith(studentRegistrationDto, classRegistrationDto);
    }

    @GetMapping("student/getSubject/{studentId}")
    public List<Subject> findAllSubjectsForStudentBy(@PathVariable Long studentId) {
        return studentServices.findAllSubjectsForStudentBy(studentId);
    }

    @GetMapping("student/getClass/{studentId}")
    public List<Class> findAllClassForStudentBy(@PathVariable Long studentId) {
        return studentServices.findAllClassesForStudentBy(studentId);
    }

    @GetMapping("student/getTeacher/{studentId}")
    public List<Teacher> findAllTeachersForStudentBy(@PathVariable Long studentId) {
        return studentServices.findAllTeachersForStudentBy(studentId);
    }


}
