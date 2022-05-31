package com.atlantis.repository.LessonOperations;


import com.atlantis.model.University.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LessonOperations extends JpaRepository<Lesson,String> {

    @Query("SELECT a FROM Lesson a WHERE a.lessonId =?1")
    Optional<Lesson> findLessonByLessonId(String lessonId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Lesson a WHERE a.lessonId=:id")
    void deleteLessonByLessonId(@Param("id") String id);
}
