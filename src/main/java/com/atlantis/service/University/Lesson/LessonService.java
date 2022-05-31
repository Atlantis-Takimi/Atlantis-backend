package com.atlantis.service.University.Lesson;

import com.atlantis.model.University.Lesson;
import com.atlantis.repository.University.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLesson(String id){
        return lessonRepository.findLessonById(id);
    }

    public Optional<Lesson> getLessonByName(String name){
        return lessonRepository.findLessonByName(name);
    }

    public void addNewLesson(Lesson lesson) {
        Optional<Lesson> lessonById = lessonRepository.findLessonById(lesson.getLessonId());
        if(lessonById.isPresent()){
            throw new IllegalStateException(
                    "There is already a Lesson with the given id!");
        }
        System.out.println(lesson.getLessonName());
        lessonRepository.save(lesson);
        System.out.println(lesson);
    }

    public void deleteLesson(String lessonId) {
        boolean exist =lessonRepository.existsLessonByLessonId(lessonId);
        if(!exist){
            throw new IllegalStateException(
                    "lesson with id="+ lessonId+ " does not exist!");
        }
        lessonRepository.deleteById(lessonId);
    }

    public void deleteLessonByName(String lessonName) {
        boolean exist =lessonRepository.existsLessonByLessonName(lessonName);
        if(!exist){
            throw new IllegalStateException(
                    "student with name="+ lessonName+ " does not exist!");
        }
        lessonRepository.deleteLessonByLessonName(lessonName);
    }

    @Transactional
    public void updateStudent(String lessonId, Optional<String> lessonName, Optional<Date> year, Optional<String> term){
        Lesson lesson = lessonRepository.findLessonById(lessonId).orElseThrow(()->
                new IllegalStateException("Lesson does not exist"));
        lessonName.ifPresent(lesson::setLessonName);
        year.ifPresent(lesson::setYear);
        term.ifPresent(lesson::setTerm);
    }
}
