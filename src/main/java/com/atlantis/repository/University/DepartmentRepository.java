package com.atlantis.repository.University;


import com.atlantis.model.University.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
