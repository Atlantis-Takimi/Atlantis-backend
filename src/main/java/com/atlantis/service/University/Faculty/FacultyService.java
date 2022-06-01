package com.atlantis.service.University.Faculty;

import com.atlantis.model.University.Faculty;
import com.atlantis.repository.University.FacultyRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public List<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }
    public Optional<Faculty> getFacultyById(String id){
        return facultyRepository.findFacultyById(id);
    }
    public Optional<Faculty> getFacultyByName(String name){
        return facultyRepository.findFacultyByName(name);
    }
    public void addNewFaculty(Faculty faculty) {
        Optional<Faculty> facultyById = facultyRepository.findFacultyById(faculty.getFacultyId());
        if(facultyById.isPresent()){
            throw new IllegalStateException(
                    "There is already a Faculty with the given id!");
        }
        System.out.println(faculty.getFacultyName());
        facultyRepository.save(faculty);
        System.out.println(faculty);
    }
    public void deleteFacultyById(String facultyId) {
        boolean exist =facultyRepository.existsFacultyByFacultyId(facultyId);
        if(!exist){
            throw new IllegalStateException(
                    "Faculty with id="+ facultyId+ " does not exist!");
        }
        facultyRepository.deleteById(facultyId);
    }
    public void deleteFacultyByName(String facultyName) {
        boolean exist =facultyRepository.existsFacultyByFacultyName(facultyName);
        if(!exist){
            throw new IllegalStateException(
                    "Faculty with name="+ facultyName+ " does not exist!");
        }
        facultyRepository.deleteById(facultyName);
    }
    public void updateFaculty(String facultyId, Optional<String> facultyName){
        Faculty faculty = facultyRepository.findFacultyById(facultyId).orElseThrow(()->
                new IllegalStateException("Faculty does not exist"));
        facultyName.ifPresent(faculty::setFacultyName);
    }
}
