package com.sfms.schoolfilemanagementsystem.repository;

import com.sfms.schoolfilemanagementsystem.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
