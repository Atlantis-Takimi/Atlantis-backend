package controller.Teacher;

import com.atlantis.model.Teacher.Teacher;
import org.springframework.web.bind.annotation.*;
import service.Teacher.TeacherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getTeacher(@RequestParam(name="TeacherId", required = false) String TeacherId){
        if(TeacherId != null){
            return List.of(teacherService.getTeacher(TeacherId).orElseThrow(()->
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

    @DeleteMapping(path="{TeacherId}")
    public void deleteTeacherById(@PathVariable("TeacherId") String TeacherId){
        teacherService.deleteTeacher(TeacherId);
    }
    @PutMapping(path="{TeacherId}")
    public void updateTeacher(
            @PathVariable("TeacherId") String TeacherId,
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname)
    {
        teacherService.updateTeacher(TeacherId, name,surname);
    }

}
