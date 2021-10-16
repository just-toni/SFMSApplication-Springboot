package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.model.Class;
import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import com.sfms.schoolfilemanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherServices{
    Teacher teacher = new Teacher();

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private ClassService classService;

    @Autowired
    private SubjectServices subjectServices;

    @Override
    public Teacher registerWith(TeacherRegistrationDto teacherRegistrationDto){
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
    public Teacher assignStudentToTeacherWith(StudentRegistrationDto studentRegistrationDto, TeacherRegistrationDto teacherRegistrationDto) {
        Student student = new Student();
        student.setName(studentRegistrationDto.getStudentName());
        student.setDateOfBirth(LocalDate.parse(studentRegistrationDto.getDateOfBirth()));
        teacher.setName(teacherRegistrationDto.getTeacherName());
        teacher.setDateOfBirth(LocalDate.parse(teacherRegistrationDto.getDateOfBirth()));
        teacher.getStudents().add(student);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher assignSubjectToTeacherWith(SubjectRegistrationDto subjectRegistrationDto, TeacherRegistrationDto teacherRegistrationDto) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectRegistrationDto.getSubjectName());
        subject.setSubjectDescription(subjectRegistrationDto.getSubjectDescription());
        teacher.setName(teacherRegistrationDto.getTeacherName());
        teacher.setDateOfBirth(LocalDate.parse(teacherRegistrationDto.getDateOfBirth()));
        teacher.getSubject().add(subject);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher assignClassToTeacherWith(ClassRegistrationDto classRegistrationDto, TeacherRegistrationDto teacherRegistrationDto) {
        Class class1 = new Class();
        class1.setClassName(classRegistrationDto.getClassName());
        class1.setClassType(classRegistrationDto.getClassType());
        teacher.setName(teacherRegistrationDto.getTeacherName());
        teacher.setDateOfBirth(LocalDate.parse(teacherRegistrationDto.getDateOfBirth()));
        teacher.getClasses().add(class1);
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Student> findAllStudentsForTeacherBy(Long teacherId) {
        return studentServices.findAll().stream().filter(student -> {
            for(Teacher teacher: student.getTeachers()){
                return teacher.getTeacherId().equals(teacherId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Subject> findAllSubjectsForTeacherBy(Long teacherId) {
        return subjectServices.findAll().stream().filter(subject -> {
            for(Teacher teacher : subject.getTeacher()){
                return teacher.getTeacherId().equals(teacherId);
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Class> findAllClassesForTeacherBy(Long teacherId) {
        return classService.findAll().stream().filter(class1 -> {
            for(Teacher teacher : class1.getTeachers()){
                return teacher.getTeacherId().equals(teacherId);
            }
            return false;
        }).collect(Collectors.toList());
    }


}
