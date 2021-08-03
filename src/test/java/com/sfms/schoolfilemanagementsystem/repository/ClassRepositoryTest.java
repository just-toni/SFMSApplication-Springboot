package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.model.ClassType;
import com.sfms.schoolfilemanagementsystem.model.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sfms.schoolfilemanagementsystem.model.Class;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassRepositoryTest {

    @Autowired
    ClassRepository classRepository;

    @Test
    void createClasses(){
        Class class1 = new Class("Crystal", ClassType.YEAR4);
        Class class2 = new Class("Glueya", ClassType.YEAR11);
        Class class3 = new Class("Mayers", ClassType.YEAR7);
        Class class4 = new Class("Mnytrds", ClassType.YEAR12);
        classRepository.save(class1);
        classRepository.save(class2);
        classRepository.save(class3);
        classRepository.save(class4);
        assertEquals(4, classRepository.count());
    }

    @Test
    void testThatClassCanBeUpdatedById(){
        Optional<Class> optionalClass = classRepository.findById(4L);
        if(optionalClass.isPresent()){
            Class class1 = optionalClass.get();
            class1.setClassName("Tyherd");
            classRepository.save(class1);
            assertEquals("Tyherd", class1.getClassName());
        }
    }

    @Test
    void testThatClassCanBeDeletedById(){
        Optional<Class> optionalClass = classRepository.findById(4L);
        if(optionalClass.isPresent()){
            Class class1 = optionalClass.get();
            classRepository.delete(class1);
            assertEquals(3, classRepository.count());
        }
    }

}