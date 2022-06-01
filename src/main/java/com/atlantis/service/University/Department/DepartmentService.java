package com.atlantis.service.University.Department;

import com.atlantis.model.University.Department;
import com.atlantis.repository.University.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }
    public Optional<Department> getDepartmentById(String id){
        return departmentRepository.findDepartmentById(id);
    }
    public Optional<Department> getDepartmentByName(String name){
        return departmentRepository.findDepartmentByName(name);
    }
    public void addNewDepartment(Department department){
        Optional<Department> departmentById = departmentRepository.findDepartmentById(department.getDepartmentId());
        if(departmentById.isPresent()){
            throw new IllegalStateException(
                    "There is already a Department with the given id!");
        }
        System.out.println(department.getDepartmentName());
        departmentRepository.save(department);
        System.out.println(department);
    }
    public void deleteDepartmentById(String departmentId) {
        boolean exist =departmentRepository.existsDepartmentByDepartmentId(departmentId);
        if(!exist){
            throw new IllegalStateException(
                    "Department with id="+ departmentId+ " does not exist!");
        }
        departmentRepository.deleteById(departmentId);
    }
    public void deleteDepartmentByName(String departmentName) {
        boolean exist =departmentRepository.existsDepartmentByDepartmentName(departmentName);
        if(!exist){
            throw new IllegalStateException(
                    "Department with name="+ departmentName+ " does not exist!");
        }
        departmentRepository.deleteDepartmentByName(departmentName);
    }
    public void updateDepartment(String departmentId, Optional<String> departmentName){
        Department department = departmentRepository.findDepartmentById(departmentId).orElseThrow(()->
                new IllegalStateException("Department does not exist"));
        departmentName.ifPresent(department::setDepartmentName);
    }
}
