package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Subject;
import com.sfms.schoolfilemanagementsystem.data.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    void createSubjects() {
        Subject subject = new Subject("Chemistry 101");
        Subject subject1 = new Subject("Math 213");
        Subject subject2 = new Subject("Geography 300");
        Subject subject3 = new Subject("English and Litearture 200");
        subjectRepository.save(subject);
        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        assertEquals(4, subjectRepository.count());
    }

    @Test
    void testThatSubjectCanBeUpdatedById() {
        Optional<Subject> optionalSubject = subjectRepository.findById(2L);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setSubjectName("Math 100");
            subjectRepository.save(subject);
            assertEquals("Math 100", subject.getSubjectName());
            subjectRepository.save(subject);
            assertEquals("Math 100", subject.getSubjectName());
        }
    }

    @Test
    void testThatSubjectCanBeDeletedById() {
        Optional<Subject> optionalSubject = subjectRepository.findById(2L);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subjectRepository.delete(subject);
            assertEquals(3, subjectRepository.count());
        }
    }

}