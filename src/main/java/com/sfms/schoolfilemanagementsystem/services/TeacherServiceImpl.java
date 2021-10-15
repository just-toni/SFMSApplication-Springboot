package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.dto.StudentRegistrationDto;
import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.repository.StudentRepository;
import com.sfms.schoolfilemanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherServices{

    @Autowired
    private TeacherRepository teacherRepository;

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private StudentServices studentServices;

    @Override
    public Teacher registerWith(TeacherRegistrationDto teacherRegistrationDto){
        Teacher teacher = new Teacher();
        System.out.println(teacherRegistrationDto.getTeacherName());
        teacher.setName(teacherRegistrationDto.getTeacherName());
        teacher.setDateOfBirth(LocalDate.parse(teacherRegistrationDto.getDateOfBirth()));
        return teacherRepository.save(teacher);
    }

    public void deleteBy(Long id){
        teacherRepository.deleteById(id);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findTeacherById(Long teacherId){
        return teacherRepository.findById(teacherId);
    }

    @Override
    public Student addStudent(Long teacherId, Long studentId) {
        return null;
    }

    @Override
    public Subject assignSubject(Long teacherId, Long subjectId) {
        return null;
    }

    @Override
    public Class assignTeacher(Long teacherId, Long classId) {
        return null;
    }

    @Override
    public List<Student> findAllStudentsForTeacherBy(Long teacherId) {
        return null;
    }

    @Override
    public List<Subject> findAllSubjectsForTeacherBy(Long teacherId) {
        return null;
    }

    @Override
    public List<Class> findAllClassesForTeacherBy(Long teacherId) {
        return null;
    }

//    Set<Student> students= new HashSet<>();
//    public void addStudents(Student student){
//        students.add(student);
//    }

//    public void assignStudent(Long teacherId, Long studentId){
//        Optional<Teacher> teacher = findByTeacherId(teacherId);
//        Optional<Student> student = studentServices.findByStudentId(studentId);
//        if(teacher.isPresent()){
//            Student student1 = new Student();
//            if(student.isPresent()){
//                student1.getName();
//                student1.getStudentId();
//                student1.getDateOfBirth();
//                addStudents(student1);
//                studentRepository.save(student1);
//            }
//            Teacher teacher1 = new Teacher();
//            teacher1.setStudents(students);
//        }
//    }

}
