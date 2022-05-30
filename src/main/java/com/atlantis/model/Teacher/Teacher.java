package com.atlantis.model.Teacher;

import com.atlantis.model.University.Department;
import com.atlantis.model.University.Faculty;
import com.atlantis.model.University.Lesson;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idTeacher", nullable = false)
    @NonNull private String idTeacher;
    @NonNull private String teacherNumber;
    @NonNull private String name;
    @NonNull private String surname;

    @Type( type = "json" )
    @Column( columnDefinition = "json" )
    @NonNull
    private List<Lesson> lessons;
    @NonNull private String role;

    @Transient private Faculty faculty;
    @Transient private Department department;
}
