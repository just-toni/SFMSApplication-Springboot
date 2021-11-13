package com.sfms.schoolfilemanagementsystem.services;

import com.sfms.schoolfilemanagementsystem.data.model.Class;
import com.sfms.schoolfilemanagementsystem.data.repository.ClassRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ClassServiceImplTest {

    @Mock
    ClassRepository classRepository;

    @InjectMocks
    ClassService classService;

    @Test
    void testToCreateClass(){
        given(classRepository.save(new Class())).willReturn(any(Class.class));

        Class class1 = classService.registerWith(new ClassRegistrationDto());

    }

}