package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.model.Class;

import java.util.List;
import java.util.Optional;

public interface TeacherServices {

    Teacher registerWith(TeacherRegistrationDto teacherRegistrationDto);
    void deleteBy(Long id);
    List<Teacher> findAll();
    Optional<Teacher> findTeacherById(Long teacherId);
    Student addStudent(Long teacherId, Long studentId);
    Subject assignSubject(Long teacherId, Long subjectId);
    Class assignTeacher (Long teacherId, Long classId);
    List<Student> findAllStudentsForTeacherBy(Long teacherId);
    List<Subject> findAllSubjectsForTeacherBy(Long teacherId);
    List<Class> findAllClassesForTeacherBy(Long teacherId);
}

