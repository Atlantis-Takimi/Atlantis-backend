package com.atlantis.service.Teacher;

import com.atlantis.model.Teacher.Teacher;
import com.atlantis.repository.Teacher.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public Optional<Teacher> getTeacher(String id){
        return teacherRepository.findTeacherById(id);
    }
    public Optional<Teacher> getTeacherByNumber(String number){
        return teacherRepository.findTeacherByNumber(number);
    }
    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> TeacherById = teacherRepository.findTeacherById(teacher.getIdTeacher());
        if(TeacherById.isPresent()){
            throw new IllegalStateException(
                    "There is already a Teacher with the given id!");
        }
        System.out.println(teacher.getDepartment());
        teacherRepository.save(teacher);
        System.out.println(teacher);
    }
    public void deleteTeacher(String TeacherId) {
        boolean exist =teacherRepository.existsById(TeacherId);
        if(!exist){
            throw new IllegalStateException(
                    "Teacher with id="+ TeacherId + " does not exist!");
        }
        teacherRepository.deleteById(TeacherId);
    }
    @Transactional
    public void updateTeacher(String TeacherId, Optional<String> name, Optional<String> surname){
        Teacher teacher = teacherRepository.findTeacherById(TeacherId).orElseThrow(()->
                new IllegalStateException("Teacher does not exist"));
        name.ifPresent(teacher::setName);
        surname.ifPresent(teacher::setSurname);
    }
}
