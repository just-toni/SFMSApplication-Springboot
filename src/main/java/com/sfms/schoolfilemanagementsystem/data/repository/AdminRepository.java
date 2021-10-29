package com.sfms.schoolfilemanagementsystem.data.repository;

import com.sfms.schoolfilemanagementsystem.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
