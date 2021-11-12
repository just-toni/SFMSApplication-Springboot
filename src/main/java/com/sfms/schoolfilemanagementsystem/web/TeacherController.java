package com.sfms.schoolfilemanagementsystem.web;

import com.sfms.schoolfilemanagementsystem.data.model.Class;
import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.model.Teacher;
import com.sfms.schoolfilemanagementsystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherServices teacherServices;


    @PostMapping("teacher/add")
    public Teacher registerTeacher(@RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        return teacherServices.registerWith(teacherRegistrationDto);
    }

    @DeleteMapping("teacher/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherServices.deleteBy(id);
    }

    @GetMapping("teacher/findAll")
    public List<Teacher> findAll() {
        return teacherServices.findAll();
    }

    @GetMapping("teacher/find/{id}")
    public Optional<Teacher> findTeacherById(@PathVariable Long id) {
        return teacherServices.findTeacherById(id);
    }

    @PutMapping("teacher/assignStudent")
    @ResponseBody
    public Teacher assignStudentToTeacherWith(@RequestBody StudentRegistrationDto studentRegistrationDto,
                                              @RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        return teacherServices.assignStudentToTeacherWith(studentRegistrationDto, teacherRegistrationDto);
    }

    @PutMapping("teacher/assignSubject")
    @ResponseBody
    public Teacher assignSubjectToTeacherWith(@RequestBody TeacherRegistrationDto teacherRegistrationDto,
                                              @RequestBody SubjectRegistrationDto subjectRegistrationDto) {
        return teacherServices.assignSubjectToTeacherWith(subjectRegistrationDto, teacherRegistrationDto);
    }

    @PutMapping("teacher/assignClass")
    @ResponseBody
    public Teacher assignClassToTeacherWith(@RequestBody TeacherRegistrationDto teacherRegistrationDto,
                                            @RequestBody ClassRegistrationDto classRegistrationDto) {
        return teacherServices.assignClassToTeacherWith(classRegistrationDto, teacherRegistrationDto);
    }

    @GetMapping("teacher/getStudent/{teacherId}")
    public List<Student> findAllStudentsForTeacherBy(@PathVariable Long teacherId) {
        return teacherServices.findAllStudentsForTeacherBy(teacherId);
    }

    @GetMapping("teacher/getSubject/{teacherId}")
    public List<Subject> findAllSubjectsForTeacherB(@PathVariable Long teacherId) {
        return teacherServices.findAllSubjectsForTeacherBy(teacherId);
    }

    @GetMapping("teacher/getClass/{teacherId}")
    public List<Class> findAllClassesForTeacherBy(@PathVariable Long teacherId) {
        return teacherServices.findAllClassesForTeacherBy(teacherId);
    }


}
