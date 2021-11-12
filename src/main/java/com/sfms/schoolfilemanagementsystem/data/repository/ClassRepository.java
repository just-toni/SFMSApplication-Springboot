package com.sfms.schoolfilemanagementsystem.data.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
