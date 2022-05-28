package com.atlantis.controller.Teacher;

import com.atlantis.model.Teacher.Teacher;
import com.atlantis.service.Teacher.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherViewController {
    private final TeacherService teacherService;

    public TeacherViewController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/teachers")
    public String getTeacher(Model model){
        List<Teacher> res = teacherService.getTeachers();
        model.addAttribute("Teachers", res);
        return "Teacher_details";
    }
}
