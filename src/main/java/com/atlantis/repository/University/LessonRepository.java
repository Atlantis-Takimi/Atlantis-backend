package com.atlantis.repository.University;

import com.atlantis.model.Student.Student;
import com.atlantis.model.University.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {
    @Query("SELECT l FROM Lesson l WHERE l.lessonId = ?1")
    Optional<Lesson> findLessonById(String id);

    @Query("SELECT l FROM Lesson l WHERE l.lessonName = ?1")
    Optional<Student> findStudentByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Lesson l WHERE l.lessonId=:number")
    void deleteLessonById(@Param("number") String id);

    boolean existsLessonByLessonId(String id);
}
