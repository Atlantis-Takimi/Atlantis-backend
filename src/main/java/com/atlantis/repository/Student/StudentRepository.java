package com.atlantis.repository.Student;

import com.atlantis.model.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,String> {

    @Query("SELECT s FROM Student s WHERE s.idStudent = ?1")
    Optional<Student> findStudentById(String id);

    @Query("SELECT s FROM Student s WHERE s.studentNumber = ?1")
    Optional<Student> findStudentByNumber(String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.studentNumber=:number")
    void deleteStudentByNumber(@Param("number") String number);

    boolean existsStudentByStudentNumber(String number);
}
