package com.atlantis.controller.Teacher;

import com.atlantis.model.Teacher.Teacher;
import com.atlantis.model.University.Lesson;
import org.springframework.web.bind.annotation.*;
import com.atlantis.service.Teacher.TeacherService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getTeacher(@RequestParam(name="idTeacher", required = false) String idTeacher){
        if(idTeacher != null){
            return List.of(teacherService.getTeacher(idTeacher).orElseThrow(()->
                    new IllegalStateException("Teacher does not exist")));
        }
        else{
            return teacherService.getTeachers();
        }
    }
    @PostMapping
    public void registerNewTeacher( @RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path="{idTeacher}")
    public void deleteTeacherById(@PathVariable("idTeacher") String idTeacher){
        teacherService.deleteTeacher(idTeacher);
    }
    @PutMapping(path="{idTeacher}")
    public void updateTeacher(
            @PathVariable("idTeacher") String idTeacher,
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname)
    {
        teacherService.updateTeacher(idTeacher, name,surname);
    }

    @PutMapping(path="/enrollment")
    Lesson enrollStudentToLesson(@RequestParam(required = true) String teacherId,
                                 @RequestParam(required = true) String lessonId){
        return teacherService.enrollTeacherToLesson(teacherId, lessonId);
    }

    @PutMapping(path="/unenrollment")
    Lesson unEnrollStudentFromLesson(@RequestParam(required = true) String teacherId,
                                     @RequestParam(required = true) String lessonId){
        return teacherService.unEnrollTeacherFromLesson(teacherId, lessonId);
    }

    @PostMapping(path = "/lessons")
    Set<Lesson> getLessons(@RequestParam(required = true) String teacherId){
        return teacherService.getLessons(teacherId);
    }
}
