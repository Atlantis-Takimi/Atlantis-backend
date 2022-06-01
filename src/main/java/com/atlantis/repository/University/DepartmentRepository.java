package com.atlantis.repository.University;


import com.atlantis.model.University.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query("SELECT d FROM Department d WHERE d.departmentId = ?1")
    Optional<Department> findDepartmentById(String id);

    @Query("SELECT d FROM Department d WHERE d.departmentName = ?1")
    Optional<Department> findDepartmentByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.departmentId=:id")
    void deleteDepartmentById(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.departmentName=:departmentName")
    void deleteDepartmentByName(@Param("departmentName") String departmentName);

    boolean existsDepartmentByDepartmentId(String id);
    boolean existsDepartmentByDepartmentName(String name);
}
