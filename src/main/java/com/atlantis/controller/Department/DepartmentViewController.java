package com.atlantis.controller.Department;

import com.atlantis.model.Student.Student;
import com.atlantis.model.University.Department;
import com.atlantis.service.University.Department.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentViewController {
    private final DepartmentService departmentService;

    public DepartmentViewController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @RequestMapping("/departments")
    public String getDepartments(Model model){
        List<Department> res = departmentService.getDepartment();
        model.addAttribute("departments", res);
        return "department_details";
    }
}
