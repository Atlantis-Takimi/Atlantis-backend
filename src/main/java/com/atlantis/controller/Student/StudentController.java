package com.atlantis.controller.Student;

import com.atlantis.model.Student.Student;
import com.atlantis.model.University.Lesson;
import com.atlantis.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService= studentService;
    }

    @GetMapping()
    public List<Student> getStudent(@RequestParam(name="studentId", required = false) String studentId,
                                    @RequestParam(name="studentNumber", required = false) String studentNumber){
        if(studentId != null){
            return List.of(studentService.getStudent(studentId).orElseThrow(()->
                    new IllegalStateException("Student does not exist")));
        }
        else if(studentNumber != null){
            return List.of(studentService.getStudentByNumber(studentNumber).orElseThrow(()->
                    new IllegalStateException("Student does not exist")));
        }
        else{
            return studentService.getStudents();
        }
    }

    @PostMapping
    public void registerNewStudent( @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudentById(@PathVariable("studentId") String studentId){
        studentService.deleteStudent(studentId);
    }

    @DeleteMapping(path="/number/{studentNumber}")
    public void deleteStudentByNumber(@PathVariable("studentNumber") String studentNumber){
        studentService.deleteStudentByNumber(studentNumber);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") String studentId,
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname
            ){
        studentService.updateStudent(studentId, name,surname);
    }

    @PutMapping(path="/enrollment")
    Lesson enrollStudentToLesson(@RequestParam(required = true) String studentId,
                                 @RequestParam(required = true) String lessonId){
        return studentService.enrollStudentToLesson(studentId, lessonId);
    }

    @PutMapping(path="/unenrollment")
    Lesson unEnrollStudentFromLesson(@RequestParam(required = true) String studentId,
                                 @RequestParam(required = true) String lessonId){
        return studentService.unEnrollStudentFromLesson(studentId, lessonId);
    }

    @PostMapping(path = "/lessons")
    Set<Lesson> getLessons(@RequestParam(required = true) String studentId){
        return studentService.getLessons(studentId);
    }

}
