package com.sfms.schoolfilemanagementsystem.data.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
