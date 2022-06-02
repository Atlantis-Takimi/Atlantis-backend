package com.atlantis.controller.Faculty;

import com.atlantis.model.University.Faculty;
import com.atlantis.service.University.Faculty.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FacultyViewController {
    private final FacultyService facultyService;

    public FacultyViewController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @RequestMapping("/faculties")
    public String getFaculties(Model model){
        List<Faculty> res = facultyService.getFaculty();
        model.addAttribute("faculties" , res);
        return "faculty_details";
    }
}
