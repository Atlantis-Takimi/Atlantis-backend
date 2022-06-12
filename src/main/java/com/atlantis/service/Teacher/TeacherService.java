package com.atlantis.service.Teacher;

import com.atlantis.model.Student.Student;
import com.atlantis.model.Teacher.Teacher;
import com.atlantis.model.University.Lesson;
import com.atlantis.repository.Teacher.TeacherRepository;
import com.atlantis.repository.University.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final LessonRepository lessonRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, LessonRepository lessonRepository) {
        this.teacherRepository = teacherRepository;
        this.lessonRepository = lessonRepository;
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

    public Lesson enrollTeacherToLesson(String teacherId, String lessonId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId).orElseThrow(()->
                new IllegalStateException("Teacher does not exist"));
        Lesson lesson = lessonRepository.findLessonById(lessonId).orElseThrow(()->
                new IllegalStateException("Lesson does not exist"));

        lesson.enrollTeacher(teacher);
        return lessonRepository.save(lesson);
    }

    public Lesson unEnrollTeacherFromLesson(String teacherId, String lessonId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId).orElseThrow(()->
                new IllegalStateException("Teacher does not exist"));
        Lesson lesson = lessonRepository.findLessonById(lessonId).orElseThrow(()->
                new IllegalStateException("Lesson does not exist"));

        lesson.unEnrollTeacher(teacher);
        return lessonRepository.save(lesson);
    }

    public Set<Lesson> getLessons(String teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId).orElseThrow(()->
                new IllegalStateException("Teacher does not exist"));

        return teacher.getLessons();
    }


}
