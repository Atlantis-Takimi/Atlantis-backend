package com.atlantis.controller.Student;

import com.atlantis.model.Student.Student;
import com.atlantis.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentViewController {
    private final StudentService studentService;

    @Autowired
    public StudentViewController(StudentService studentService){
        this.studentService= studentService;
    }

    @RequestMapping("/students")
    public String getStudents(Model model){
        List<Student> res = studentService.getStudents();
        model.addAttribute("students", res);
        return "students_details";
    }
}
