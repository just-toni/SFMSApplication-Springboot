package com.sfms.schoolfilemanagementsystem.data.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
