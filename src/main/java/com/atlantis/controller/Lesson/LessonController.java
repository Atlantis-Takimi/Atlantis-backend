package com.atlantis.controller.Lesson;


import com.atlantis.model.University.Lesson;
import com.atlantis.service.University.Lesson.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }

    @GetMapping
    public Lesson getLesson(@RequestParam(name="lessonId", required = true) String lessonId){
        return lessonService.getLessonById(lessonId).orElseThrow(()->
                new IllegalStateException("Lesson does not exist"));
    }

    @PostMapping
    public void addNewLesson( @RequestBody Lesson lesson){
        Optional<Lesson> isExist = lessonService.getLessonById(lesson.getLessonId());
        isExist.ifPresent(lessonT-> {
            throw new IllegalStateException("Lesson with lessonId="+lesson.getLessonId()+ " already exists!");
        }
      );
        lessonService.addNewLesson(lesson);
    }

    @DeleteMapping
    public void deleteLessonById (@PathVariable("lessonId") String lessonId){
        lessonService.deleteLessonById(lessonId);
    }

    @PutMapping(path="{lessonId}")
    public void updateLesson(
            @PathVariable("lessonId") String lessonId,
            @RequestParam(required = false) Optional<String> lessonName,
            @DateTimeFormat(fallbackPatterns = "yyyy") @RequestParam(required = false) Optional<Date> year,
            @RequestParam(required = false) Optional<String> term
    ){
        lessonService.updateLesson(lessonId, lessonName, year,term);
    }



}
