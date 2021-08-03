package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.model.Admin;
import com.sfms.schoolfilemanagementsystem.model.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    void createAdmin(){
        Admin admin1 = new Admin("Jack Frost");
        Admin admin2 = new Admin("Meghan Markle");
        Admin admin3 = new Admin("Johann Yale");
        LocalDate date1 = LocalDate.of(1976, 5, 25);
        Admin admin4 = new Admin("Hugh Markson");
        admin4.setDateOfBirth(date1);
        Admin admin5 = new Admin("Red Tyler");
        adminRepository.save(admin1);
        adminRepository.save(admin2);
        adminRepository.save(admin3);
        adminRepository.save(admin4);
        adminRepository.save(admin5);
        assertEquals(5, adminRepository.count());
    }

    @Test
    void testThatParentCanBeUpdatedById(){
        Optional<Admin> optionalAdmin = adminRepository.findById(1L);
        if(optionalAdmin.isPresent()){
            Admin admin = optionalAdmin.get();
            admin.setName("Matthew Ruckerberg");
            adminRepository.save(admin);
            assertEquals("Matthew Ruckerberg", admin.getName());
        }
    }

    @Test
    void testThatParentCanBeDeletedById(){
        Optional<Admin> optionalAdmin = adminRepository.findById(5L);
        if(optionalAdmin.isPresent()){
            Admin admin = optionalAdmin.get();
            adminRepository.delete(admin);
            assertEquals(4, adminRepository.count());
        }
    }

}