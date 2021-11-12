package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Student;
import com.sfms.schoolfilemanagementsystem.data.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void createStudents() {
        LocalDate date1 = LocalDate.of(2003, 3, 1);
        Student student1 = new Student("Jasmine Reelwood", date1);
        LocalDate date2 = LocalDate.of(2003, 12, 3);
        Student student2 = new Student("Jack Scollof", date2);
        LocalDate date3 = LocalDate.of(2003, 1, 3);
        Student student3 = new Student("Yara Shahidi", date3);
        LocalDate date4 = LocalDate.of(2002, 3, 3);
        Student student4 = new Student("Ryan Van-Kirk", date4);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        assertEquals(4, studentRepository.count());

    }


    @Test
    void testThatAStudentsHaveBeCreated() {
        assertEquals(4, studentRepository.count());
    }

    @Test
    void testThatStudentCanBeUpdatedById() {
        Optional<Student> optionalStudent = studentRepository.findById(3L);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName("Tayna James");
            studentRepository.save(student);
            assertEquals("Tayna James", student.getName());
        }

    }

}