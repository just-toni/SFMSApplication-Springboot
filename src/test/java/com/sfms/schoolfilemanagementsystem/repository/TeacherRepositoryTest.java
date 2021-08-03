package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.model.Student;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void createTeachers(){
        LocalDate date1 = LocalDate.of(1989, 3,16);
        Teacher teacher1 = new Teacher("Tasha Daniels", date1);
        LocalDate date2 = LocalDate.of(1991, 8,26);
        Teacher teacher2 = new Teacher("Feraphina Junnsair", date2);
        LocalDate date3 = LocalDate.of(1979, 6,10);
        Teacher teacher3 = new Teacher("Marshal Peterson", date3);
        LocalDate date4 = LocalDate.of(1990, 10,23);
        Teacher teacher4 = new Teacher("Hera Zueser", date4);
        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
        teacherRepository.save(teacher3);
        teacherRepository.save(teacher4);
        assertEquals(4, teacherRepository.count());
    }

    @Test
    void testThatTeachersHaveBeCreated(){
        assertEquals(4, teacherRepository.count());
    }

    @Test
    void testThatTeacherCanBeUpdatedById(){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(2L);
        if(optionalTeacher.isPresent()){
            Teacher teacher = optionalTeacher.get();
            LocalDate date = LocalDate.of(1970, 5, 18);
            teacher.setDateOfBirth(date);
            teacherRepository.save(teacher);
            assertEquals(date, teacher.getDateOfBirth());
        }
    }

    @Test
    void testThatTeacherCanBeDeletedById(){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(1L);
        if(optionalTeacher.isPresent()){
            Teacher teacher = optionalTeacher.get();
            teacherRepository.delete(teacher);
            assertEquals(3, teacherRepository.count());
        }
    }

    @Test
    void testThatTeacherHasStudents(){
        LocalDate date = LocalDate.of(1989, 3,16);
        Teacher teacher1 = new Teacher("Tasha Daniels", date);
        teacherRepository.save(teacher1);
        LocalDate date1 = LocalDate.of(2003, 3, 1);
        Student student1 = new Student("Jasmine Reelwood", date1);
        LocalDate date2 = LocalDate.of(2003, 12, 3);
        Student student2 = new Student("Jack Scollof", date2);
        LocalDate date3 = LocalDate.of(2003, 1, 3);
        Student student3 = new Student("Yara Shahidi", date3);
        LocalDate date4 = LocalDate.of(2002, 3, 3);
        Student student4 = new Student("Ryan Van-Kirk", date4);
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        teacher1.setStudents(students);
        teacherRepository.save(teacher1);
    }

}
