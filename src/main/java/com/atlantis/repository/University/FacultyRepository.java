package com.atlantis.repository.University;

import com.atlantis.model.University.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {

    @Query("SELECT f FROM Faculty f WHERE f.facultyId =?1")
    Optional<Faculty> findFacultyById(String id);

    @Query("SELECT f FROM Faculty f WHERE f.facultyName = ?1")
    Optional<Faculty> findFacultyByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Faculty f WHERE f.facultyId=:id")
    void deleteFacultyById(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Faculty f WHERE f.facultyName=:facultyName")
    void deleteFacultyByName(@Param("facultyName") String facultyName);

    boolean existsFacultyByFacultyId(String id);
    boolean existsFacultyByFacultyName(String name);

}
