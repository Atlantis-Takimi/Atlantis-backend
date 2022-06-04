package com.atlantis.controller.Lesson;

import com.atlantis.model.University.Lesson;
import com.atlantis.service.University.Lesson.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LessonViewController {
    private final LessonService lessonService;

    public LessonViewController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @RequestMapping("/lessons")
    public String getLesson(Model model){
        List<Lesson> res = lessonService.getLessons();
        model.addAttribute("lessons", res);
        return "lesson_details";
    }
}
