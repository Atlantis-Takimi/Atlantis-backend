package com.atlantis.controller.Department;

import com.atlantis.model.University.Department;
import com.atlantis.service.University.Department.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public Department getDepartment(@RequestParam(name = "departmentId", required = true) String departmentId){
        return departmentService.getDepartmentById(departmentId).orElseThrow(()->
                new IllegalStateException("Department does not exist"));
    }
    @PostMapping
    public void addNewDepartment(@RequestBody Department department) {
        Optional<Department> isExist = departmentService.getDepartmentById(department.getDepartmentId());
        isExist.ifPresent(department1 -> {
                    throw new IllegalStateException("Department with departmentId=" + department.getDepartmentId() + " already exists!");
                }
        );
        departmentService.addNewDepartment(department);
    }
    @DeleteMapping
    public void deleteDepartmentById(@PathVariable("departmentId") String departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }
    @PutMapping(path = "{departmentId}")
    public void updateDepartment(@PathVariable("departmentId") String departmentId,
                              @RequestParam(required = false) Optional<String> departmentName){
        departmentService.updateDepartment(departmentId,departmentName);
    }
}
