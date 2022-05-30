package com.atlantis.repository.Admin;

import com.atlantis.model.Admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    @Query("SELECT a FROM Admin a WHERE a.adminId = ?1")
    Optional<Admin> findAdminById(String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Admin a WHERE a.adminId=:id")
    void deleteAdminByID(@Param("id") String id);

    boolean existsAdminByStudentNumber(Integer id);
}
