package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.model.Parent;
import com.sfms.schoolfilemanagementsystem.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentRepositoryTest {

    @Autowired
    ParentRepository parentRepository;
    @Test
    void createParents(){
        Parent parent1 = new Parent("Maura Reelwood");
        Parent parent2 = new Parent("Ben Scollof");
        LocalDate date1 = LocalDate.of(1976, 5, 25);
        Parent parent3 = new Parent("Joey Shahidi");
        parent3.setDateOfBirth(date1);
        Parent parent4 = new Parent("Laura Van-Kirk");
        parentRepository.save(parent1);
        parentRepository.save(parent2);
        parentRepository.save(parent3);
        parentRepository.save(parent4);
        assertEquals(4, parentRepository.count());
    }

    @Test
    void testThatParentCanBeUpdatedById(){
        Optional<Parent> optionalParent = parentRepository.findById(2L);
        if(optionalParent.isPresent()){
            Parent parent = optionalParent.get();
            parent.setName("Paul Scollof");
            parentRepository.save(parent);
            assertEquals("Paul Scollof", parent.getDateOfBirth());
        }
    }

    @Test
    void testThatParentCanBeDeletedById(){
        Optional<Parent> optionalParent = parentRepository.findById(2L);
        if(optionalParent.isPresent()){
            Parent parent = optionalParent.get();
            parentRepository.delete(parent);
            assertEquals(3, parentRepository.count());
        }
    }

}