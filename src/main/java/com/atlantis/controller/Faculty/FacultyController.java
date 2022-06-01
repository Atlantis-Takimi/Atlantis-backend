package com.atlantis.controller.Faculty;

import com.atlantis.model.University.Faculty;
import com.atlantis.service.University.Faculty.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping
    public Faculty getFaculty(@RequestParam(name= "facultyId" , required = true) String facultyId){
        return facultyService.getFacultyById(facultyId).orElseThrow(()->
                new IllegalStateException("Faculty does not exist"));
    }
    @PostMapping
    public void addNewFaculty(@RequestBody Faculty faculty) {
        Optional<Faculty> isExist = facultyService.getFacultyById(faculty.getFacultyId());
        isExist.ifPresent(faculty1 -> {
                    throw new IllegalStateException("Faculty with facultyId=" + faculty.getFacultyId() + " already exists!");
                }
        );
        facultyService.addNewFaculty(faculty);
    }
    @DeleteMapping
    public void deleteFacultyById(@PathVariable("facultyId") String facultyId){
        facultyService.deleteFacultyById(facultyId);
    }
    @PutMapping(path = "{facultyId}")
    public void updateFaculty(@PathVariable("facultyId") String facultyId,
                              @RequestParam(required = false) Optional<String> facultyName){
        facultyService.updateFaculty(facultyId,facultyName);
    }
}
