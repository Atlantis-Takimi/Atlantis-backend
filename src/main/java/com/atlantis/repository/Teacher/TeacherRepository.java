package com.atlantis.repository.Teacher;

import com.atlantis.model.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


    @Repository
    public interface TeacherRepository extends JpaRepository<Teacher,String>
             {

        @Query("SELECT a FROM Teacher a WHERE a.idTeacher = ?1")
        Optional<Teacher> findTeacherById(String id);

        @Query("SELECT a FROM Teacher a WHERE a.TeacherRole = ?1")
        Optional<Teacher> findTeacherByRole(String role);

        @Transactional
        @Modifying
        @Query("DELETE FROM Teacher a WHERE a.idTeacher=:id")
        void deleteTeacherById(@Param("id") String id);

        boolean existsTeacherByTeacherId(String id);
    }
