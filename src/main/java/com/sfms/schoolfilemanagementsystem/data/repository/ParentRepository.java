package com.sfms.schoolfilemanagementsystem.data.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
